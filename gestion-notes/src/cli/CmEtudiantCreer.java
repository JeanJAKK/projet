/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cli;

import java.time.LocalDate;
import metier.Etudiant;

/**
 *
 * @author jakk
 */
public class CmEtudiantCreer extends Commande{
    private int numeroCarte;
    private String nom;
    private String prenom;
    private LocalDate dateNaissance;
    @Override
    public void executer() {
          if (this.numeroCarte != 0 ){
              new Etudiant(this.numeroCarte, this.nom, this.prenom, this.dateNaissance);
//              System.out.println(this.numeroCarte);
        }
    }

    @Override
    public void setParametres(String[] parametres) {
        this.numeroCarte = Integer.parseInt(parametres[0]);
        this.nom = parametres[1];
        this.prenom = parametres[2];
//        this.dateNaissance = LocalDate.parse(parametres[3]);
    }
}
