/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cli;

import metier.Parcours;


/**
 *
 * @author jakk
 */
public class CmParcoursAfficher extends Commande{
    int id;
    @Override
    public void executer() {
//        Parcours.afficherTout();
        try {
            for(Parcours p : Parcours.getListe()){
                if(this.id == p.getId()){
                    p.afficher();
                }
            }
        } catch (Exception e) {
        }
    }

    @Override
    public void setParametres(String[] parametres) {
        this.id = Integer.parseInt(parametres[0]);
    }
    
}
