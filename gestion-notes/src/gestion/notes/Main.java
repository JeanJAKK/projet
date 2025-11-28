/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gestion.notes;

import cli.Commande;
import cli.ParseurCommande;
import java.time.LocalDate;
import java.util.Scanner;
import metier.Etablissement;
import metier.Etudiant;
import metier.Parcours;

/**
 *
 * @author jakk
 */
public class Main {
    private static Scanner clavier = new Scanner(System.in);
    private static ParseurCommande parseur = new ParseurCommande();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Parcours lproGL = new Parcours(1, "lproGL");
        lproGL.inscrireEtudiant( new Etudiant("HI", "cc", LocalDate.now(), 12422));
        lproGL.inscrireEtudiant( new Etudiant("HIOU", "cucci", LocalDate.now(), 12587));

        // TODO code application logic here
        System.out.println("Bonjour !!!");
        System.out.println("Tapez votre commande :");
        while (true) {            
             String strCmde = clavier.nextLine();
             Commande commande = parseur.parser(strCmde);
             commande.executer();
        }
    }
    
    public void test(String[] args) {
//        Parcours lproGL = new Parcours("LPro GL");
//        Parcours lproSRI = new Parcours("LPro SRI");
//        Etablissement epl = new Etablissement("EPL", "Ecole Polytechnique de Lomé");
//        Etablissement fds = new Etablissement("FDS", "Faculté Des Sciences");
//        
        /*List<Parcours>pcrs = new ArrayList();
        pcrs.add(lproGL);
        pcrs.add(lproSRI);
        epl.setParcourss(pcrs);*/
//        
//        epl.getParcourss().add(lproGL);
//        lproGL.getEtablissements().add(epl);
//        epl.getParcourss().add(lproSRI);
//        lproSRI.getEtablissements().add(epl);
//        
//        fds.getParcourss().add(lproGL);
//        lproGL.getEtablissements().add(fds);
//        
//        System.out.println(epl.presenterParcours());
//        System.out.println(fds.presenterParcours());
//        
//        System.out.println(lproGL.presenterEtablissement());
//        System.out.println(lproSRI.presenterEtablissement());
//        /*Etudiant et1 = new Etudiant("KODJO", "Afi", LocalDate.now(), 600235);
//        Etudiant et2 = new Etudiant("KOFFI", "Abalo", LocalDate.now(), 600265);
//        
//        UniteEnseignement poo = new UniteEnseignement("INF 1326", "POO");
//        UniteEnseignement uml = new UniteEnseignement("INF 1436", "UML");
//        
//        poo.getInscriptionUEs().add(new InscriptionUE(et1, poo));
//        poo.getInscriptionUEs().add(new InscriptionUE(et2, poo));
//        
//        et1.getInscriptionUEs().add(new InscriptionUE(et1, poo));
//        et2.getInscriptionUEs().add(new InscriptionUE(et2, poo));*/
    }
}