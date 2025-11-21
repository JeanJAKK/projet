/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programme;

/**
 *
 * @author jakk
 */
public class EquationSecondDegre {
    private double a;
    private double b;                                           
    private double c;
    
    // Constructeur
    // Constructeur d' initialisation 
    public void EquationSecondDegre(double _a, double _b, double _c){
    
        this.a = _a;
        this.b = _b;
        this.c = _c; 
    }
    // Constructeur par défaut
    public void EquationSecondDegre(){
    
        
    }
    // Accesseurs
    public double getA(){
        return a;
    }
    public void setA(double _a){
         this.a = _a;
    }   
    public double getB(){
        return b;
    }
    public void setB(double _b){
         this.b = _b;
    }
    
    public double getC(){
        return c;
    }
    public void setC(double _c){
         this.c = _c;
    }
    public void afficherEquation(){
         System.out.println("(E):" + this.a + "X^2 + " + this.b + "X + " + this.c );
    }
    
    private double getDiscriminant(){
        return (this.b*this.b - 4*this.a*this.c);
    }
    
    // admet soluion
    private boolean admetSolution(){
        return (this.b*this.b - 4*this.a*this.c) >= 0;
    }
    
    // Methode resoudre
    
    public String resoudre(){
        String message;
        if(admetSolution()){
            double s1 = (-this.b - Math.sqrt(getDiscriminant())) / (2 * this.a);
            double s2 = (-this.b + Math.sqrt(getDiscriminant())) / (2 * this.a);
            message = "Les solutions sont : S1 = " + s1 + " et S2 = " + s2;
        }else{
            message = "Pas de solution à votre équation dans R.";
       }
        return message;
    }
}
