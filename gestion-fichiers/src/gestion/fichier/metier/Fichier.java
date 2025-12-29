/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion.fichier.metier;

import gestion.fichiers.cli.Navigateur;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author jakk
 */
public abstract class Fichier implements Serializable{
    @Serial
    private static final long serialVersionUID = 22222444444445L;
    private static Repertoire root = new Repertoire("", null);
    public static final String chemin = "/home/jakk/Bureau/CoursPOO/output/gestion_fichier.ser";
    private LocalDateTime dateCreation;
    String nom;
    Repertoire repertoireParent;
    
    
    public Fichier(){
        this.dateCreation = LocalDateTime.now();
    }
    public Fichier(String nom){
        this();
        this.nom = nom;
    }
       public Fichier(String nom, Repertoire repertoireParent){
        this(nom);
        this.repertoireParent = repertoireParent;
        if(repertoireParent != null){
            this.repertoireParent.getFichier().add(this);
        }
    }
    
     public static void sauvegarder() throws Exception{
        FileOutputStream fichier = new FileOutputStream("/home/jakk/Bureau/CoursPOO/output/gestion_fichier.ser");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fichier);
        objectOutputStream.writeObject(root);
        objectOutputStream.flush();
    }
    
    public static void restaurer()throws Exception{
        try{
            FileInputStream fichier = new FileInputStream("/home/jakk/Bureau/CoursPOO/output/gestion_fichier.ser");
            ObjectInputStream objectInputStream = new ObjectInputStream(fichier);
            root = (Repertoire) objectInputStream.readObject();
        }catch(FileNotFoundException e){
            
        }catch(IOException e){
            
        }catch(ClassNotFoundException e){
            
        }
    }
    
    //
    public abstract boolean estRepertoire();
    
    public static Repertoire getRoot(){
        return root;
    }
    
    public abstract int getTaille();
    
    public String getNomComplet(){
        if(repertoireParent == null){
            return this.nom;
        }
        return repertoireParent.getNomComplet() + "/" + this.nom;
    }
    
    public String getNom(){
       return this.nom;
   } 
    
   public Repertoire getRepertoireParent(){
       return this.repertoireParent;
   }
   
   // copie method
   public abstract void copie(String chemin);
   
           
    
    public abstract void move(String chemin);
    public abstract void remove();

}
