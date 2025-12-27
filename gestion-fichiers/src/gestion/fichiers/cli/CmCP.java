/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion.fichiers.cli;

import gestion.fichier.metier.Fichier;
import gestion.fichier.metier.Repertoire;



/**
 *
 * @author jakk
 */
public class CmCP extends Commande {
    
    private String nom;       // nom du fichier à copier
    private String chemin;
    
    
   @Override
    public void executer() {
        //recuperer le repertoire courant
        Repertoire repertoireCourant = Navigateur.getInstance().getRepertoireCourant();
        
        for(Fichier f : Navigateur.getInstance().getRepertoireCourant().getFichier()){
            if(f.getNom().equals(nom)){
                f.copie(chemin);
            }
        }

        // REVENIR AU DEPART
        Navigateur.getInstance().setRepertoireCourant(repertoireCourant);
    }
    

    @Override
    public void setPararmetres(String[] parametres) {
        this.nom = parametres[0];
        try{
            this.chemin = parametres[1];
        }catch(Exception e){
            System.err.println("Erreur:" + e.getMessage());
        }
        
    } 
}
