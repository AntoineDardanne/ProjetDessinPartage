package metier;

import java.awt.Color;

public class Dessin
{
    private int type, x, y, largeur, hauteur;
    private Color couleur;
    private boolean plein;
    private String texte;

    public Dessin(int type, int x, int y, int largeur, int hauteur, Color couleur, boolean plein, String texte)
    {
        this.type = type;
        this.x = x;
        this.y = y;
        this.largeur = largeur;
        this.hauteur = hauteur;
        this.couleur = couleur;
        this.plein = plein;
        this.texte = texte;
    }

    public Dessin(int type, int x, int y, int largeur, int hauteur, Color couleur, boolean plein)
    {
        this.type = type;
        this.x = x;
        this.y = y;
        this.largeur = largeur;
        this.hauteur = hauteur;
        this.couleur = couleur;
        this.plein = plein;
    }

    public int getType()        { return type; }
    public int getX()           { return x; }
    public int getY()           { return y; }
    public int getLargeur()     { return largeur; }
    public int getHauteur()     { return hauteur; }
    public Color getCouleur()   { return couleur; }
    public boolean estPleine()    { return plein; }
    public String getTexte()    { return texte; }
}