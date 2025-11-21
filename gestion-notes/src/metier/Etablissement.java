/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metier;

import metier.Parcours;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jakk
 */
public class Etablissement {
    private String code;
    private String libelle;
    private List<Parcours> parcourss = new ArrayList<>();
    
    public Etablissement() {
        
    }
    
    public Etablissement(String code, String libelle) {
        this.code = code;
        this.libelle = libelle;
    }
    
    public String getCode (){
        return this.code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    
    public String getLibelle (){
        return this.libelle;
    }
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
    
    public List<Parcours> getParcourss (){
        return this.parcourss;
    }
    public void setParcourss(List<Parcours> parcourss) {
        this.parcourss = parcourss;
    }
    
    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return this.libelle;
    }
    
    public String presenterParcours() {
        return "\n" + this.libelle + " --> Parcours : "+ this.getParcourss().toString();
    }
}