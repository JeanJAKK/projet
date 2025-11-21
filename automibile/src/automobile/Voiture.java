/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package automobile;

/**
 *
 * @author jakk
 */
public class Voiture {
    private static int nombreDeVoitures = 1;
    
    private int numSerie;
    private String marque;
    private String modele;
    private String couleur;
    private String numeroDeChassis;
    private int nombreDePlaces;
    
    
    public Voiture() {
        this.numSerie = nombreDeVoitures;
        nombreDeVoitures++;
    }
    public String afficher(){
        
        return "Voiture de marque: " + this.marque
                + "\nModèle: " + this.modele 
                + "\nCouleur: " + this.couleur
                + "\nNumero de chassis: " + this.numeroDeChassis
                + "\nNombre de places: " + this.nombreDePlaces;
    }
    
    // Constructeur par defaut
    public void Voiture(){
        this.numSerie = nombreDeVoitures +1;
        this.marque = "";
        this.modele = "";
        this.couleur = "";
        this.numeroDeChassis = "";
        this.nombreDePlaces = 0;

    }
    
        
    // getter nombreDeVoitures
    public int getNombreDeVoitures(){
        return this.nombreDeVoitures;
    }
    
    // Constructeur d' initialisation 
    public Voiture(String _marque, String _modele, String _couleur, String _numeroDeChassis, int _nombreDePlaces){
        
        this();
        this.marque = _marque;
        this.modele = _modele;
        this.couleur = _couleur;
        this.numeroDeChassis = _numeroDeChassis;
        this.nombreDePlaces = _nombreDePlaces;
    }
    
    // Constructeur de recopie
    public Voiture(Voiture voiture){
        this();
        this.marque = voiture.marque;
        this.modele = voiture.modele;
        this.couleur = voiture.couleur;
        this.numeroDeChassis = voiture.numeroDeChassis;
        this.nombreDePlaces = voiture.nombreDePlaces; 
    }
    
    // Accesseurs
    public String getMarque(){
        return this.marque;
    }
    public void setMarque(String _marque){
        this.marque = _marque;
    }
    
    public String getModele(){
        return this.modele;
    }
    public void setModele(String _modele){
        this.modele = _modele;
    }
    
    public String getCouleur(){
        return this.couleur;
    }
    public void setCouleur(String _couleur){
        this.couleur = _couleur;
    }
    
    public String getNumeroDeChassis(){
        return this.numeroDeChassis;
    }
    public void setNumeroDeChassis(String _numeroDeChassis){
        this.numeroDeChassis = _numeroDeChassis;
    }
    
    public int getNombreDePlaces(){
        return this.nombreDePlaces;
    }
    public void setNombreDePlaces(int _nombreDePlaces){
        this.nombreDePlaces = _nombreDePlaces;
    }
    // 1.2.4 methode setCouleur
    
    // comparaison objet
    public boolean estEgal(Voiture voiture){
        return this.numeroDeChassis.equals(voiture.numeroDeChassis);
    }
}