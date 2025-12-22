/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion.fichiers.cli;



/**
 *
 * @author tkossi
 */
public class CmTouch extends Commande {
    private String nom;

    @Override
    public void executer() {
        if(Navigateur.getInstance().getRepertoireCourant().existeFichierSimple(nom)){
            System.out.println("Ce fichier existe déjà");
        }else{
             Navigateur.getInstance().getRepertoireCourant().ajouterFichierSimple(nom);
        }
       
    }

    @Override
    public void setPararmetres(String[] parametres) {
        this.nom = parametres[0];
    }
     
}