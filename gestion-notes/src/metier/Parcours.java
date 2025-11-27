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
public class Parcours {
    private static List<Parcours> liste = new ArrayList<>();
    public static int sequence = 1;
    private int id;
    private String libelle;
    private List<Etudiant> etudiants = new ArrayList<>();
    private List<Etablissement> etablissements = new ArrayList<>();
    private List<UniteEnseignement> uniteEnseignements = new ArrayList<>();
    
    public Parcours() {
         liste.add(this);
         sequence = sequence + 1;  
    }
    
    public Parcours(String libelle){
        this(sequence, libelle);    
    }
    
    public Parcours(int sequence, String libelle) {
        this();
        this.id = sequence;
        this.libelle = libelle;
        
    }
    
    public static String getHeader(){
        return "Identifiant \t Libelle";
    }
    
    public static void afficherTout(){
        System.out.println(getHeader());
        for(Parcours p : liste){
            System.out.println(p);

        }
        
    }
    
   
    // Méthode pour afficher parcours
    public void afficher(){
        System.out.println(this);
    }
    
    // Méthode pour afficher liste étudiants
    public void afficherEtudiant(){
        int i = 1;
        System.out.println(Etudiant.getHeader());
        for(Etudiant etudiant : this.etudiants){
            System.out.println( etudiant);
            i++;
        }
    }
    
    public String getLibelle (){
        return this.libelle;
    }
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
    
    
    public static List<Parcours> getListe(){
        return liste;
    }
    
    public List<Etudiant> getEtudiants (){
        return this.etudiants;
    }
    public void setEtudiants(List<Etudiant> etudiants) {
        this.etudiants = etudiants;
    }
    
    public int getId(){
        return this.id;
    }
    
    public List<Etablissement> getEtablissements (){
        return this.etablissements;
    }
    public void setEtablissements(List<Etablissement> etablissements) {
        this.etablissements = etablissements;
    }
    
    public List<UniteEnseignement> getUniteEnseignements (){
        return this.uniteEnseignements;
    }
    public void setUniteEnseignements(List<UniteEnseignement> uniteEnseignements) {
        this.uniteEnseignements = uniteEnseignements;
    }
    
    /**
     *
     * @return
     */
//    @Override
//    public String toString() {
//        return this.libelle;
//    }
    
    public String presenterEtablissement() {
        return "\n" + this.libelle + " --> Etablissements : " + this.getEtablissements().toString();
    }
    
    public void inscrireEtudiant(Etudiant etudiant){
        etudiant.setParcours(this);
        this.etudiants.add(etudiant);
    }
    
    @Override
    public String toString(){
        return this.id + "\t" + this.libelle;
    }
  
}
