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
import java.nio.file.FileAlreadyExistsException;
import java.time.LocalDateTime;

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
        FileOutputStream fichier = new FileOutputStream("/home/jakk/Bureau/CoursPOO/output/gestion_fichier_exam.ser");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fichier);
        objectOutputStream.writeObject(root);
        objectOutputStream.flush();
    }
    
    public static void restaurer()throws Exception{
        try{
            FileInputStream fichier = new FileInputStream("/home/jakk/Bureau/CoursPOO/output/gestion_fichier_exam.ser");
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
   public abstract void copie(String chemin) throws FileNotFoundException, FileAlreadyExistsException;
              
   public abstract void remove();
   
   public void move(String chemin) throws FileNotFoundException, FileAlreadyExistsException{


    Repertoire depart = Navigateur.getInstance().getRepertoireCourant();

    // Aller à la destination
    Navigateur.getInstance().changerRepertoire(chemin);
    Repertoire destination = Navigateur.getInstance().getRepertoireCourant();
    
    if (destination == null) {
        throw new FileNotFoundException("Répertoire destination inexistant");
    }
    
    // Vérifier conflit de nom
    for (Fichier f : destination.getFichier()) {
        if (f.getNom().equals(this.nom)) {
            throw new FileAlreadyExistsException( nom + " existe déjà" );
        }
    }
    
    // move
    this.repertoireParent.getFichier().remove(this);
    destination.getFichier().add(this);
    this.repertoireParent = destination;

    // repertoire de départ
    Navigateur.getInstance().setRepertoireCourant(depart);
}

}
