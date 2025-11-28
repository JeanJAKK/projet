/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gestion.exception;

/**
 *
 * @author jakk
 */
public class GestionException {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        methode1();
    }
    
    private static void methode1(){
        System.out.println("Debut methode 1");
        methode2();
        System.out.println("Fin methode 1");        
    }
     private static void methode2(){
        System.out.println("Debut methode 2");
        try{
            methode3();
        }catch (Exception e){
            System.out.println(e.getMessage()); 
        }
        
        System.out.println("Fin methode 2");        
    }
     private static void methode3()throws Exception{
        System.out.println("Debut methode 3");
        int a = 5;
        int b = 0;
        float c = diviser(a, b);
        System.out.println("Fin methode 3");        
    }
    
    private static float diviser(int a, int b)throws Exception{
        
        if(b!=0){
            return a/b;
        }else{
            throw new Exception("Le diviseur doit etre nul");
        }
    }
}
