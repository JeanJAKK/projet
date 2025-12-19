/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion.fichiers.cli;

import gestion.fichier.metier.Fichier;
import gestion.fichier.metier.FichierSimple;
import gestion.fichier.metier.Repertoire;
import gestion.fichiers.cli.Navigateur;
import static gestion.fichiers.cli.Navigateur.getInstance;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.util.Arrays;



/**
 *
 * @author jakk
 */
public class CmMV extends Commande {
    
    private String nom;
    private String chemin;
    
    
   @Override
    public void executer() {
        // recuperer le repertoire de depart
        Repertoire RepertoireDepart = Navigateur.getInstance().getRepertoireCourant();
        
        String[] nomsRepertoire = RepertoireDepart.getNomComplet().split("/");
        String[] chmin = Arrays.copyOfRange(nomsRepertoire, 1, nomsRepertoire.length);
        for(var ch : chmin){
            Navigateur.getInstance().changerRepertoire(ch);
            for(Fichier f: Navigateur.getInstance().getRepertoireCourant().getFichier()){
            // Verifie si c'est un fichier puis copie 
                if(f instanceof Fichier && this.nom.equals(f.getNom())){
                    try{
                            // Aller au repertoire cible
                       Navigateur.getInstance().setRepertoireCourant(Fichier.getRoot());
                       Navigateur.getInstance().changerRepertoire(this.chemin);

                       Repertoire repertoireCible = Navigateur.getInstance().getRepertoireCourant();

                       FichierSimple copie = new FichierSimple((FichierSimple)f);
                       repertoireCible.ajouterFichierSimple(copie.getNom());
                       }catch(Exception e){
                          e.getMessage();
                       }finally{
                           Navigateur.getInstance().setRepertoireCourant(RepertoireDepart);
                           Navigateur.getInstance().getRepertoireCourant().getFichier().remove(f);
                       }
        }
        }
//            if(this.nom.equals(f.getNom())){
//                try{
//                    Navigateur.getInstance().setRepertoireCourant(Fichier.getRoot());
//                    Navigateur.getInstance().changerRepertoire(this.chemin);
//                    Navigateur.getInstance().getRepertoireCourant().getFichier().add(f);
//                    
//                    Navigateur.getInstance().setRepertoireCourant(Fichier.getRoot());
//                    Navigateur.getInstance().changerRepertoire(path);
//                    
//                }catch(FileNotFoundException e){
//                    System.out.println(e.getMessage());
//                }
//            }
        }
    }
    

    @Override
    public void setPararmetres(String[] parametres) {
        this.nom = parametres[0];
        try{
            this.chemin = parametres[1];
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    } 
}
