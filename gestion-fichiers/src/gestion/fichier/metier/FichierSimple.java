/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion.fichier.metier;

import gestion.fichiers.cli.Navigateur;
import java.io.FileNotFoundException;
import java.io.Serial;
import java.nio.file.FileAlreadyExistsException;

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
    public boolean estRepertoire(){
        return false;
    }
    
   
//    public void copie(String chemin) {
//       // Recuperer le repertoire courant
//       Repertoire repertoireCourant = Navigateur.getInstance().getRepertoireCourant();
//  
//        try {
//            Navigateur.getInstance().setRepertoireCourant(Fichier.getRoot());
//            Navigateur.getInstance().changerRepertoire(chemin);
//            
//            Repertoire destination = Navigateur.getInstance().getRepertoireCourant();
//            
//            // Vérifier conflit de nom
//            for (Fichier f : destination.getFichier()) {
//                if (f.getNom().equals(this.nom)) {
//                    System.err.println( "\'" + this.nom + "\'" + " existe déjà" );
//                    throw new FileAlreadyExistsException("Erreur" + this.nom);
//                }
//            }
//            
//            destination.getFichier().add(this);
//            this.repertoireParent = destination;
//    
//        } catch (FileNotFoundException e) {
//            System.err.println(e.getMessage());
//        } catch (FileAlreadyExistsException ex) {
//            ex.getMessage();
//        } finally {
//            Navigateur.getInstance().setRepertoireCourant(repertoireCourant);
//        }
//     }
//    
    @Override
    public void copie(String chemin)
        throws FileNotFoundException, FileAlreadyExistsException {

    Repertoire depart = Navigateur.getInstance().getRepertoireCourant();

    try {
        Repertoire destination;

        if (chemin == null) {
            destination = depart;
        } else {
            Navigateur.getInstance().changerRepertoire(chemin);
            destination = Navigateur.getInstance().getRepertoireCourant();
        }

        // Conflit de nom
        for (Fichier f : destination.getFichier()) {
            if (f.getNom().equals(this.nom)) {
                throw new FileAlreadyExistsException(nom +" existe déjà");
            }
        }

        // Création d'une NOUVELLE instance
        new FichierSimple(this.nom, destination);
    
    }catch(FileNotFoundException e){
        e.getMessage();
    }finally {
        Navigateur.getInstance().setRepertoireCourant(depart);
    }
}

    @Override
    public void remove() {
        if (repertoireParent == null){
            return;
        }

        repertoireParent.getFichier().remove(this);
        repertoireParent = null;
}


}

