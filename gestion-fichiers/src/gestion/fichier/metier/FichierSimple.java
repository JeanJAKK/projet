/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion.fichier.metier;

import gestion.fichiers.cli.Navigateur;
import java.io.FileNotFoundException;
import java.io.Serial;

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
    
    
//    // methode pour move 
//    @Override
//    public void move(String chemin) {
//       // Recuperer le repertoire courant
//       Repertoire repertoireCourant = Navigateur.getInstance().getRepertoireCourant();
//  
//        try {
//            Navigateur.getInstance().setRepertoireCourant(Fichier.getRoot());
//            Navigateur.getInstance().changerRepertoire(chemin);
//            
//            Repertoire destination = Navigateur.getInstance().getRepertoireCourant();
//            
//                if (this.repertoireParent != null){
//                    for (Fichier f : this.repertoireParent.getFichier()){
//                        if(this.getNom().equals(f.getNom()))
//                          this.remove(); 
//            }
//           
//            }
//            
//            destination.getFichier().add(this);
//            this.repertoireParent = destination;
//            
//        } catch (FileNotFoundException e) {
//            System.err.println(e.getMessage());
//        } finally {
//            Navigateur.getInstance().setRepertoireCourant(repertoireCourant);
//        }
//     }
    
    @Override
    public void copie(String chemin) {
       // Recuperer le repertoire courant
       Repertoire repertoireCourant = Navigateur.getInstance().getRepertoireCourant();
  
        try {
            Navigateur.getInstance().setRepertoireCourant(Fichier.getRoot());
            Navigateur.getInstance().changerRepertoire(chemin);
            
            Repertoire destination = Navigateur.getInstance().getRepertoireCourant();
            
//            if (this.repertoireParent != null){
//                this.repertoireParent.getFichier().remove(this);
//            }
            
            destination.getFichier().add(this);
            this.repertoireParent = destination;
            
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        } finally {
            Navigateur.getInstance().setRepertoireCourant(repertoireCourant);
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

