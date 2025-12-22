/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion.fichiers.cli;

/**
 *
 * @author jakk
 */
public class CmAide extends Commande {

    @Override
    public void executer() {
        System.out.println("Exit : quitter le programme");
        System.out.println("Help : aide");
        System.out.println("ls : ls <chemin> ou ls    \t[affiche le contenu d\'un repertoire]");
        System.out.println("cp : cp <source> <cible> \t [copie]");
        System.out.println("mv : mv <source> <cible> \t [move]");
        System.out.println("rm : rm <fichier> \t\t [supprimer]");
    }

    @Override
    public void setPararmetres(String[] parametres) {
        
    }
    
}