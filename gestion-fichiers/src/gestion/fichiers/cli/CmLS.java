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
public class CmLS extends Commande {
    private String chemin;
    private Repertoire repertoire;

    @Override
    public void executer() {
        Repertoire repertoireCourant = Navigateur.getInstance().getRepertoireCourant();
        if (repertoire != null && chemin == null) {
            try {
                Navigateur.getInstance().getRepertoireCourant().afficherContenuR(repertoire);
                System.out.println("");
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else if (repertoire == null && chemin == null){
            Navigateur.getInstance().getRepertoireCourant().afficherContenu();
            System.out.println("");
        } else {
            try{
                Navigateur.getInstance().setRepertoireCourant(Fichier.getRoot());
                Navigateur.getInstance().changerRepertoire(chemin);
                Navigateur.getInstance().getRepertoireCourant().afficherContenu();
            }catch(Exception e){
                System.err.println("Erreur : " + e.getMessage());
            }
        }
        Navigateur.getInstance().setRepertoireCourant(repertoireCourant);
        
        
    }

    
    public void setParametres(String[] parametres) {
        if (parametres.length > 0) {
            try {
                this.repertoire = Navigateur.getInstance().getRepertoireCourant(parametres[0]);
            } catch (Exception e) {
                this.chemin = parametres[0];
            }
        }
    }

    @Override
    public void setPararmetres(String[] parametres) {
        throw new UnsupportedOperationException("Not supported yet."); 
     // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
     
}