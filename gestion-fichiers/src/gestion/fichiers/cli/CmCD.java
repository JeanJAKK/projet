/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion.fichiers.cli;

/**
 *
 * @author jakk
 */
public class CmCD extends Commande {
    private String nom;
    
    @Override
    public void executer() {
        try {
             Navigateur.getInstance().changerRepertoire(nom);

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void setPararmetres(String[] parametres) {
        this.nom = parametres[0];
    }
}