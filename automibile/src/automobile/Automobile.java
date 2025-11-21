/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package automobile;

/**
 *
 * @author jakk
 */
public class Automobile {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Voiture voiture1 = new Voiture();
        Voiture voiture2 = new Voiture("TOYOTA", "Avensis", "Noir", "H2344LI", 5);
        Voiture voiture3 = new Voiture(voiture2);
        Voiture voiture4 = new Voiture(voiture3);
        
        // Affichage
        voiture1.afficher();
        voiture2.afficher();
        voiture3.afficher();
        
        // Comparaison
        System.out.println(voiture3 == voiture4);
        System.out.println(voiture3.estEgal(voiture4));
        // 1.3 2.c Le .equals est différent de ==
        
        // 
    }
    
}