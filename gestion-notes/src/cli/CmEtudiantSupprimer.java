/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cli;

import metier.Etudiant;

public class CmEtudiantSupprimer extends Commande {

    private int numeroCarte;

    @Override
    public void executer() {
        if (this.numeroCarte != 0) {

            boolean supprime = Etudiant.supprimerEtudiant(this.numeroCarte);

            if (supprime) {
                System.out.println("Étudiant avec numéro de carte " + this.numeroCarte + " supprimé avec succès.");
            } else {
                System.out.println("Aucun étudiant trouvé avec le numéro de carte " + this.numeroCarte);
            }
        }
    }

    @Override
    public void setParametres(String[] parametres) {
        this.numeroCarte = Integer.parseInt(parametres[0]);
    }
}
