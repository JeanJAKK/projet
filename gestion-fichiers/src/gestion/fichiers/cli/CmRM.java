/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion.fichiers.cli;

import gestion.fichier.metier.Fichier;
import gestion.fichier.metier.Repertoire;
import java.util.List;

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
        
        String[] nomsFichierARemove = nom.split("/"); //split le nom complet du fichier à remove
       
        for(String folder : nomsFichierARemove){ //va dans le dossier parent du fichier a remove
            try{
              Navigateur.getInstance().changerRepertoire(folder);  
                List<Fichier> fichierARemoveParentContenu = Navigateur.getInstance().getRepertoireCourant().getFichier();
                for(Fichier f : fichierARemoveParentContenu){
                    if(f.getNom().equals(nomsFichierARemove[nomsFichierARemove.length-1])){
                        f.remove();
                        break;
                    }
                }
            }catch(Exception e){
                System.err.println("Repertoire inexistant" + e.getMessage());
            }finally{
                Navigateur.getInstance().setRepertoireCourant(RepertoireDepart);
            }
            
            
        }
    }
    @Override
    public void setPararmetres(String[] parametres) {
        this.nom = parametres[0];
    } 
    
}
