/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metier;

import metier.UniteEnseignement;
import java.util.List;

/**
 *
 * @author jakk
 */
public class InscriptionUE {
    private float moyenne;
    private Etudiant etudiant;
    private UniteEnseignement uniteEnseignement;
    
    public InscriptionUE(Etudiant etudiant, UniteEnseignement uniteEnseignement) {
        this.etudiant = etudiant;
        this.uniteEnseignement = uniteEnseignement;
    }
    
    public InscriptionUE() {
        
    }
    
    public float getMoyenne (){
        return this.moyenne;
    }
    public void setMoyenne(float moyenne) {
        this.moyenne = moyenne;
    }
    
    public Etudiant getEtudiant (){
        return this.etudiant;
    }
    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }
    
    public UniteEnseignement getUniteEnseignement (){
        return this.uniteEnseignement;
    }
    public void setUniteEnseignement(UniteEnseignement uniteEnseignement) {
        this.uniteEnseignement = uniteEnseignement;
    }
}