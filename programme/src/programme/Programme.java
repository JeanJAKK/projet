/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package programme;

/**
 *
 * @author jakk
 */
public class Programme {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Personne p1 = new Personne();
        p1.setNom("KOFFI");
        p1.afficher();
        Personne p2 = p1;
        p2.setNom("KODJO");
        p1.afficher();
        p2.afficher();
        
        // equations
        EquationSecondDegre eq = new EquationSecondDegre();
        EquationSecondDegre eq1 = new EquationSecondDegre();
        eq1.setA(1);
        eq1.setB(-2);
        eq1.setC(1);
        
        eq1.afficherEquation();
        System.out.println(eq1.resoudre());
    }
    
}
