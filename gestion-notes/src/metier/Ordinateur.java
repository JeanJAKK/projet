/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metier;

/**
 *
 * @author jakk
 */
public class Ordinateur {
    private String marque;
    private int numeroSerie;
    private Etudiant etudiant;
    
    public String getMarque() {
        return this.marque;
    }
    public void setMarque(String marque) {
        this.marque = marque;
    }
    
    public int getNumeroSerie() {
        return this.numeroSerie;
    }
    public void setNumeroSerie(int numeroSerie) {
        this.numeroSerie = numeroSerie;
    }
    
    public Etudiant getEtudiant() {
        return this.etudiant;
    }
    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }
}
