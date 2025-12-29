/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion.fichier.metier;

import gestion.fichiers.cli.Navigateur;
import java.io.FileNotFoundException;
import java.io.Serial;
import java.nio.file.FileAlreadyExistsException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jakk
 */
public class Repertoire extends Fichier {

    @Serial
    private static final long serialVersionUID = 64234876235145L;
    private List<Fichier> fichiers = new ArrayList<>();

    public Repertoire() {

    }

    public Repertoire(String nom, Repertoire repertoireParent) {
        super(nom, repertoireParent);
    }

    public Repertoire(Repertoire repertoire) {
        this();
        this.nom = repertoire.nom;
        this.fichiers = new ArrayList<>(repertoire.fichiers);
        this.repertoireParent = repertoire.repertoireParent;

    }

    public void ajouterRepertoire(String nom) {
        new Repertoire(nom, this);
    }

    public void ajouterFichierSimple(String nom) {
        new FichierSimple(nom, this);
    }

    public void afficherContenu() {
        for (Fichier fichier : fichiers) {
            System.out.print(fichier.getNom() + "\t");
        }
    }

    public void afficherContenuR(Repertoire getRepertoire) {
        List<Fichier> files = getRepertoire.getFichier();
        for (Fichier fichier : files) {
            System.out.print(fichier.getNom() + "\t");
        }
    }

    @Override
    public int getTaille() {
        int taille = 0;
        for (Fichier fichier : fichiers) {
            taille += fichier.getTaille();
        }
        return taille;
    }

    @Override
    public boolean estRepertoire() {
        return true;
    }

    public boolean existeFichierSimple(String nom) {
        if (nom == null) {
            return false;
        }
        for (Fichier f : fichiers) {
            if (!f.estRepertoire() && f.getNom().equals(nom)) {
                return true;
            }
        }
        return false;
    }

    public boolean existeRepertoire(String nom) {
        if (nom == null) {
            return false;
        }
        for (Fichier f : fichiers) {
            if (f.estRepertoire() && f.getNom().equals(nom)) {
                return true;
            }
        }
        return false;
    }

    public Repertoire getRepertoire(String nom) throws FileNotFoundException {
        for (Fichier f : fichiers) {
            if (f.estRepertoire() && f.getNom().equals(nom)) {
                return (Repertoire) f;
            }
        }
        return null;
    }

    public List<Fichier> getFichier() {
        return this.fichiers;
    }

    @Override
    public void copie(String chemin) throws FileNotFoundException, FileAlreadyExistsException {

        Repertoire depart = Navigateur.getInstance().getRepertoireCourant();

        try {
            // Déterminer la destination
            Repertoire destination;

            if (chemin == null) {
                destination = depart;
            } else {
                Navigateur.getInstance().changerRepertoire(chemin);
                destination = Navigateur.getInstance().getRepertoireCourant();
                if (destination == null) {
                    throw new FileNotFoundException("Destination inexistante");
                }
            }

            // Vérifier conflit de nom
            for (Fichier f : destination.getFichier()) {
                if (f.getNom().equals(this.nom)) {
                    throw new FileAlreadyExistsException(nom + " existe déjà ");
                }
            }

            // Créer le nouveau répertoire (COPIE)
            Repertoire copie = new Repertoire(this.nom, destination);

            // Copier de maniere recursive le contenu
            for (Fichier f : this.getFichier()) {
                if (f.estRepertoire()) {
                    f.copie(copie.getNomComplet());
                } else {
                    // copie fichier simple
                    new FichierSimple(f.getNom(), copie);
                }
            }

        } finally {
            Navigateur.getInstance().setRepertoireCourant(depart);
        }
    }

    // remover
    @Override
    public void remove() {

        // supprimer le contenu
        for (Fichier f : new ArrayList<>(getFichier())) {
            f.remove();
        }

        // se supprimer du parent
        if (repertoireParent != null) {
            repertoireParent.getFichier().remove(this);
            repertoireParent = null;
        }
    }



}
