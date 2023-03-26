package metier;

import java.awt.Color;

public class Dessin implements java.io.Serializable
{
    public static final int CARRE = 1;
    public static final int ROND = 2;
    public static final int LIGNE = 3;
    public static final int TEXTE = 4;

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

    /*public Dessin(int type, int x, int y, int largeur, int hauteur, Color couleur, boolean plein)
    {
        this.type = type;
        this.x = x;
        this.y = y;
        this.largeur = largeur;
        this.hauteur = hauteur;
        this.couleur = couleur;
        this.plein = plein;
    }*/

    public int getType()        { return type; }
    public int getX()           { return x; }
    public int getY()           { return y; }
    public int getLargeur()     { return largeur; }
    public int getHauteur()     { return hauteur; }
    public Color getCouleur()   { return couleur; }
    public boolean estPleine()    { return plein; }
    public String getTexte()    { return texte; }

    public String toString()
    {
        return "Dessin [type=" + type + ", x=" + x + ", y=" + y + ", largeur=" + largeur + ", hauteur=" + hauteur + ", couleur=" + couleur + ", plein=" + plein + ", texte=" + texte + "]";
    }

    public String toSend()
    {
        return type + ";" + x + ";" + y + ";" + largeur + ";" + hauteur + ";" + couleur.getRed() + ";" + couleur.getGreen() + ";" + couleur.getBlue() + ";" + plein + ";" + texte;
    }

    public static Dessin fromString(String dessinString)
    {
        // Séparation des données
        String[] tab = dessinString.split(";");

        // Récupération des données
        int type = Integer.parseInt(tab[0]);
        int x = Integer.parseInt(tab[1]);
        int y = Integer.parseInt(tab[2]);
        int largeur = Integer.parseInt(tab[3]);
        int hauteur = Integer.parseInt(tab[4]);
        Color couleur = new Color(Integer.parseInt(tab[5]), Integer.parseInt(tab[6]), Integer.parseInt(tab[7]));
        boolean plein = Boolean.parseBoolean(tab[8]);
        String texte = tab[9];

        // Création du dessin
        return new Dessin(type, x, y, largeur, hauteur, couleur, plein, texte);
    }
}