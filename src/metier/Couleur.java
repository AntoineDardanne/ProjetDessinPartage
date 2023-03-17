package metier;

import java.awt.Color;

public class Couleur {
    private Color couleur;
    private String nom;

    public Couleur(Color couleur, String nom) {
        this.couleur = couleur;
        this.nom = nom;
    }

    public Color getCouleur() {
        return couleur;
    }

    public void setCouleur(Color couleur) {
        this.couleur = couleur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
