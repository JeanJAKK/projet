/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion.fichiers.cli;

import gestion.fichier.metier.Fichier;
import gestion.fichier.metier.Repertoire;
import java.io.FileNotFoundException;

/**
 *
 * @author jakk
 */
public class Navigateur {
    private static Navigateur instance;
    private Repertoire repertoireCourant;
    static {
        instance = new Navigateur();
    }
    
    private Navigateur() {
        
    }
    
    public static Navigateur getInstance() {
        return instance;
    }
    
    public Repertoire getRepertoireCourant(){
        return this.repertoireCourant;
    }
    public Repertoire getRepertoireCourant(String parametre){
        return this.repertoireCourant;
    }
    public void setRepertoireCourant(Repertoire repertoireCourant){
        this.repertoireCourant = repertoireCourant;
    }
    
    public void changerRepertoire(String nom){
        if(nom == null){
            Navigateur.getInstance().setRepertoireCourant(Fichier.getRoot());
            return;
        }
        if(".".equals(nom)){
            Navigateur.getInstance().setRepertoireCourant(repertoireCourant);
            return;
        }
        
        String[] nomsRepertoire = nom.split("/");
        Repertoire r = this.repertoireCourant;
        try{
           this.changerRepertoire(nomsRepertoire);    
        }catch(FileNotFoundException e){
            this.repertoireCourant = r;
            System.err.println(e.getMessage());
        }
        
    }
    
    public void changerRepertoire(String[] nomsRepertoire)throws FileNotFoundException{
        for (String nomRepertoire : nomsRepertoire) {
            if(nomRepertoire.equals("..")&&this.repertoireCourant.getRepertoireParent()!= null){
              this.repertoireCourant = this.repertoireCourant.getRepertoireParent();
              continue;
        }
            try {
                this.repertoireCourant = this.repertoireCourant.getRepertoire(nomRepertoire);
            } catch (FileNotFoundException e) {
                System.err.println( e.getMessage());
            }
        
        }
    }
    
   
}