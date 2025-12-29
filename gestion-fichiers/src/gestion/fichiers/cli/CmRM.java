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
public class CmRM extends Commande{
    private String nom;
    
  @Override
   public void executer() {
        Repertoire repertoireCourant = Navigateur.getInstance().getRepertoireCourant();

        Fichier cible = null;

        for (Fichier f : repertoireCourant.getFichier()) {
            if (f.getNom().equals(nom)) {
                cible = f;
                break;
            }
        }

        if (cible == null) {
            System.err.println("Fichier ou répertoire introuvable : " + nom);
            return;
        }

        cible.remove(); 
}

    @Override
    public void setPararmetres(String[] parametres) {
        this.nom = parametres[0];
    } 
    
}
