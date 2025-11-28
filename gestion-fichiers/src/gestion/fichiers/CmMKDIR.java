/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion.fichiers;

import gestion.fichiers.cli.Commande;
import gestion.fichiers.cli.Navigateur;
import gestion.fichiers.metier.Repertoire;

/**
 *
 * @author jakk
 */
public class CmMKDIR extends Commande{
    private String nom;
    
    
    @Override
    public void executer(){
        Repertoire repertoire = new Repertoire(this.nom, Navigateur.getInstance().getRepertoireCourant());
    }
    @Override
    public void setParametres(String[] parametres){
        this.nom = parametres[0];
    }
}
