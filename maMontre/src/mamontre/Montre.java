/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mamontre;

/**
 *
 * @author jakk
 */
public class Montre {
    private static int compteur = 1;
    
    private int numSerie;
    private int annee;
    private int mois;
    private int jour;
    private int heure;
    private int minute;
    private int seconde;
    
    public Montre() {
        this.numSerie = compteur;
        compteur++;
    }
    
    public Montre(int _annee, int _mois, int _jour, int _heure, int _minute, 
            int _seconde){
        this();
        this.annee = _annee;
        this.mois = _mois;
        this.jour = _jour;
        this.heure = _heure;
        this.minute = _minute;
        this.seconde = _seconde;
    }
    
    public Montre(Montre montre){
        this();
        this.annee = montre.annee;
        this.mois = montre.mois;
        this.jour = montre.jour;
        this.heure = montre.heure;
        this.minute = montre.minute;
        this.seconde = montre.seconde;
    }
    
    //Accesseurs
    public int getNumSerie(){
        return this.numSerie;
    }
    public void setNumserie(int compteur){
        this.numSerie = compteur;
    }
    public int getAnnee(){
        return this.annee;
    }
    public void setAnnee(int _annee){
        this.annee = _annee;
    }
    
    public int getMois(){
        return this.mois;
    }
    public void setMois(int _mois){
        this.mois = _mois;
    }
    
    public int getJour(){
        return this.jour;
    }
    public void setJour(int _jour){
        this.mois = _jour;
    }

    public int getHeure(){
        return this.heure;
    }
    public void setHeure(int _heure){
        this.mois = _heure;
    }
    
    public int getMinute(){
        return this.minute;
    }
    public void setMinute(int _minute){
        this.minute = _minute;
    }
    public int getSeconde(){
        return this.seconde;
    }
    public void setSeconde(int _seconde){
        this.seconde = _seconde;
    }
    @Override
    public String toString(){
        return this.numSerie + ":" + this.annee + "-" + this.mois + "-" + this.jour + " " + this.heure
                + "-" + this.minute + "-" + this.seconde;
    }
    
}
