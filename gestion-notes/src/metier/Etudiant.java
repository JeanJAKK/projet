/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metier;
import metier.Ordinateur;
import metier.InscriptionUE;
import metier.Parcours;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jakk
 */
public class Etudiant {
    private static List<Etudiant> liste = new ArrayList<>();
    public static int sequence;
    private int id;
    private String nom;
    private String prenom;
    private LocalDate dateNaissance;
    private int numeroCarte;
    private Parcours parcours;
    private List<InscriptionUE> inscriptionUEs = new ArrayList<>();
    private Ordinateur ordinateur;
   
    public Etudiant(){
        liste.add(this);
    }
    
    public static boolean supprimerEtudiant(int numeroCarte) {
         return liste.removeIf(etd -> etd.getNumeroCarte() == numeroCarte);
    }
    
    public static Etudiant modifierEtudiant(int numeroCarte) {
    for (Etudiant e : liste) {
        if (e.getNumeroCarte() == numeroCarte) {
            return e;
        }
    }
    return null;
}


    
//    public Etudiant(int numeroCarte){
//        
//    }
   
    public Etudiant(String nom, String prenom, LocalDate dateNaissance, int numeroCarte) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.numeroCarte = numeroCarte;
    }
    
    public Etudiant(int id, int numeroCarte){
        this();
        this.id = id;
        this.numeroCarte = numeroCarte;
    }
     
    public Etudiant(int numeroCarte, String nom, String prenom, LocalDate dateNaissance){
        this();   
        sequence = sequence + 1;
        this.numeroCarte = numeroCarte;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
    }
    
    public static String getHeader(){
        return "N° \t Carte \t Nom \t Prénom \t Date de naissance";
    }
    
    public static void afficherTout() {
        int i = 1;
        System.out.println(getHeader());
        for(Etudiant etd : liste){
            System.out.println(etd.numeroCarte + "\t" + etd.nom + "\t" + etd.prenom + "\t" + etd.dateNaissance);
            i++;
        }
        
    }
   
    // Méthode pour afficher étudiant
    public void afficher(){
        System.out.println(this);
    }

    public float getMoyenne(){
        int sommeCredits = 0;
        float moyenneAlgebrique = 0;
        for(InscriptionUE iUE : this.inscriptionUEs){
            sommeCredits += iUE.getUniteEnseignement().getNbreCredits();
            moyenneAlgebrique += iUE.getMoyenne();
        }
        return moyenneAlgebrique/sommeCredits;
    }
   
    // Accesseurs
    public String getNom (){
        return this.nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
   
    public String getPrenom (){
        return this.prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
   
    public LocalDate getDateNaissance (){
        return this.dateNaissance;
    }
    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }
   
    public int getNumeroCarte (){
        return this.numeroCarte;
    }
    public void setNumeroCarte(int numeroCarte) {
        this.numeroCarte = numeroCarte;
    }
   
    public Parcours getParcours (){
        return this.parcours;
    }
    public void setParcours(Parcours parcours) {
        this.parcours = parcours;
    }
   
    public List<InscriptionUE> getInscriptionUEs (){
        return this.inscriptionUEs;
    }
    public void setInscriptionUEs(List<InscriptionUE> inscriptionUEs) {
        this.inscriptionUEs = inscriptionUEs;
    }
   
    public Ordinateur getEtudiant (){
        return this.ordinateur;
    }
    public void setEtudiant(Ordinateur ordinateur) {
        this.ordinateur = ordinateur; 
    }
    
   
    @Override
    public String toString() {
        return this.numeroCarte + "\t"
                + this.nom + "\t"
                + this.prenom + "\t"
                + this.dateNaissance ;
    }
  
}