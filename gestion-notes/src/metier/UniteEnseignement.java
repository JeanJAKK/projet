/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metier;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jakk
 */
public class UniteEnseignement {
    private String code;
    private String libelle;
    private int nbreCredits;
    private List<InscriptionUE> inscriptionUEs = new ArrayList<>();
    private Parcours parcours;
    
    public UniteEnseignement() {
        
    }
    
    public UniteEnseignement(String code, String libelle) {
        this.code = code;
        this.libelle = libelle;
    }
    
    public String getCode (){
        return this.code;
    }
    public void setCode (String code) {
        this.code = code;
    }
    
    public String getLibelle (){
        return this.libelle;
    }
    public void setLibelle (String libelle) {
        this.libelle = libelle;
    }
    
    public int getNbreCredits (){
        return this.nbreCredits;
    }
    public void setNbreCredits (int nbreCredits) {
        this.nbreCredits = nbreCredits;
    }
    
    public List<InscriptionUE> getInscriptionUEs (){
        return this.inscriptionUEs;
    }
    public void setInscriptionUEs(List<InscriptionUE> inscriptionUEs) {
        this.inscriptionUEs = inscriptionUEs;
    }
    
    public Parcours getParcours (){
        return this.parcours;
    }
    public void setParcours(Parcours parcours) {
        this.parcours = parcours;
    }
}