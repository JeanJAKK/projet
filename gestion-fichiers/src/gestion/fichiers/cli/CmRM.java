/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion.fichiers.cli;

import gestion.fichier.metier.Fichier;
import gestion.fichier.metier.FichierSimple;
import gestion.fichier.metier.Repertoire;
import gestion.fichiers.cli.Navigateur;
import java.io.FileNotFoundException;
import java.util.Arrays;

/**
 *
 * @author jakk
 */
public class CmRM extends Commande{
    private String nom;
    
   @Override
    public void executer() {
          // recuperer le repertoire de depart
        Repertoire RepertoireDepart = Navigateur.getInstance().getRepertoireCourant();
        
//        String[] nomsRepertoire = RepertoireDepart.getNomComplet().split("/");
//        String[] chemin = Arrays.copyOfRange(nomsRepertoire, 1, nomsRepertoire.length);
        
        for(Fichier f: Navigateur.getInstance().getRepertoireCourant().getFichier()){
            if (f.getNom().equals(nom)){
                try{
                   Navigateur.getInstance().getRepertoireCourant().getFichier().remove(f);
                           
    
//                     // Aller au repertoire cible
//                Navigateur.getInstance().setRepertoireCourant(Fichier.getRoot());
//                Navigateur.getInstance().changerRepertoire(this.chemin);
//                
//                Repertoire repertoireCible = Navigateur.getInstance().getRepertoireCourant();
//                
//                FichierSimple copie = new FichierSimple((FichierSimple)f);
//                repertoireCible.ajouterFichierSimple(copie.getNom());
                }catch(Exception e){
                   e.getMessage();
                }finally{
                    Navigateur.getInstance().setRepertoireCourant(RepertoireDepart);
                }       
                break;
             }
        }
    }
    @Override
    public void setPararmetres(String[] parametres) {
        this.nom = parametres[0];
//        try{
//            this.chemin = parametres[1];
//        }catch(Exception e){
//            System.out.println(e.getMessage());
//        }
        
    } 
    
}
