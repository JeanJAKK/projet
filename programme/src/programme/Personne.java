/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programme;

/**
 *
 * @author jakk
 */
public class Personne {
    public String nom;
    
    // Accesseur
    public String getNom(){
        return nom;
    }
    public void setNom(String _nom){
         this.nom = _nom;
    }
    
    // Methode afficher
    public void afficher(){
        System.out.println("Je suis " + this.nom);
    }
}
