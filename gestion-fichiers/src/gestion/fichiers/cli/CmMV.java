/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion.fichiers.cli;

import gestion.fichier.metier.Fichier;
import java.nio.file.FileAlreadyExistsException;
import gestion.fichier.metier.Repertoire;
import java.io.FileNotFoundException;



/**
 *
 * @author jakk
 */

public class CmMV extends Commande {

    private String source;
    private String destination;
    String cheminDestination;

    @Override
    public void executer() {

        Repertoire repertoireCourant = Navigateur.getInstance().getRepertoireCourant();

        Fichier cible = null;

        // Trouver la source dans le répertoire courant
        for (Fichier f : repertoireCourant.getFichier()) {
            if (f.getNom().equals(source)) {
                cible = f;
                break;
            }
        }

        if (cible == null) {
            System.err.println("Source introuvable : " + source);
            return;
        }
        
        
        if (destination == null) {
            // répertoire courant
            cheminDestination = repertoireCourant.getNomComplet();
        } else {
            cheminDestination = destination;
        }
        
        // Déplacer
        try {
            cible.move(cheminDestination);
        } catch (FileNotFoundException e) {
            System.err.println("Destination introuvable : " + e.getMessage());
        } catch (FileAlreadyExistsException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            System.err.println("Erreur : " + e.getMessage());
        }
   
        
    }

    @Override
    public void setPararmetres(String[] parametres) {
         if (parametres.length < 2) {
            this.source = parametres[0];
            this.destination = null;
        }else{
            this.source = parametres[0];
            this.destination = parametres[1];
        }
    }
}
