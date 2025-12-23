/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion.fichier.metier;

import gestion.fichiers.cli.Navigateur;
import java.io.Serial;
import java.util.Arrays;

/**
 *
 * @author jakk
 */
public class FichierSimple extends Fichier{
    @Serial
    private static final long serialVersionUID = 3903913317545L;
    private String donnee;
    
    public FichierSimple() {
        
    }
    
    public FichierSimple(String nom, Repertoire repertoireParent) {
        super(nom, repertoireParent);
    }
    
    // Constructeur de copie
    public FichierSimple(FichierSimple fichier){
        super();
        this.nom = fichier.nom;
        this.repertoireParent = fichier.repertoireParent;
       
    }


    @Override
    public int getTaille() {
        return donnee.length();
    }
    
    @Override
     public void copie(String chemin) {
       // Recuperer le repertoire courant
       Repertoire repertoire = Navigateur.getInstance().getRepertoireCourant();
       
       Navigateur.getInstance().changerRepertoire(chemin);
       Navigateur.getInstance().getRepertoireCourant().ajouterFichierSimple(nom);
       
    }
    
    @Override
    public boolean estRepertoire(){
        return false;
    }
    
    
    // methode pour move 
    @Override
    public void move(String chemin) {
       // Recuperer le repertoire courant
       Repertoire repertoireCourant = Navigateur.getInstance().getRepertoireCourant();
       try{
            Navigateur.getInstance().changerRepertoire(chemin);
            Navigateur.getInstance().getRepertoireCourant().ajouterRepertoire(nom);
       }catch(Exception e){
           System.err.println("Erreur :" + e.getMessage());
       }finally{
           Navigateur.getInstance().setRepertoireCourant(repertoireCourant);
           Navigateur.getInstance().getRepertoireCourant().getFichier().remove(nom);
       }
       
     }
}

