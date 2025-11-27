/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cli;

import java.time.LocalDate;
import metier.Etudiant;

public class CmEtudiantModifier extends Commande {

    private int numeroCarte;
    private String nom;
    private String prenom;
    private LocalDate dateNaissance;

    @Override
    public void executer() {

        // On récupère l'étudiant
        Etudiant etd = Etudiant.modifierEtudiant(this.numeroCarte);

        if (etd == null) {
            System.out.println("Aucun étudiant trouvé avec le numéro de carte " + this.numeroCarte);
            return;
        }

        // Modifications selon les valeurs fournies
        if (this.nom != null) {
            etd.setNom(this.nom);
        }

        if (this.prenom != null) {
            etd.setPrenom(this.prenom);
        }

        if (this.dateNaissance != null) {
            etd.setDateNaissance(this.dateNaissance);
        }

        System.out.println("Étudiant mis à jour :");
        etd.afficher();
    }

    @Override
    public void setParametres(String[] parametres) {

        this.numeroCarte = Integer.parseInt(parametres[0]);
        this.nom = parametres[1];
        this.prenom = parametres[2];
//        this.dateNaissance = LocalDate.parse(parametres[3]);
    }
}
