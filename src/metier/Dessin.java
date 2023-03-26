package metier;

import java.awt.*;
import java.io.Serializable;

/**
 * Classe qui représente un dessin
 *
 * @author Antoine Dardanne, Noemie Claccin
 * @version 1.0
 */
public class Dessin implements Serializable
{

    public static final int CARRE = 1;
    public static final int ROND = 2;
    public static final int LIGNE = 3;
    public static final int TEXTE = 4;

    private int type, x, y, width, height;
    private Color color;
    private boolean plein;
    private String texte;

    /**
     * Constructeur de la classe Dessin
     *
     * @param type
     *            Le type de dessin
     * @param x
     *            La position en x du dessin
     * @param y
     *            La position en y du dessin
     * @param width
     *            La largeur du dessin
     * @param height
     *            La hauteur du dessin
     * @param color
     *            La couleur du dessin
     * @param plein
     *            Si le dessin est plein ou non
     * @param texte
     *            Le texte du dessin, si c'en est un
     */
    public Dessin(int type, int x, int y, int width, int height, Color color, boolean plein, String texte) {
        this.type = type;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
        this.plein = plein;
        this.texte = texte;
    }

    public int getType() {return this.type;}
    public int getX() {return this.x;}
    public int getY() {return this.y;}
    public int getLargeur() {return this.width;}
    public int getHauteur() {return this.height;}
    public Color getCouleur() {return this.color;}
    public boolean estPleine() {return this.plein;}
    public String getTexte() {return this.texte;}

    public String toString() {
        return "Dessin{" +
                "type=" + type +
                ", x=" + x +
                ", y=" + y +
                ", width=" + width +
                ", height=" + height +
                ", color={" + color.getRed() + ", " + color.getGreen() + ", " + color.getBlue() + "}" +
                ", plein=" + plein +
                ", texte='" + texte + '\'' +
                '}';
    }

    public String toSend() {
        return type + ";" + x + ";" + y + ";" + width + ";" + height + ";" + color.getRed() + ";" + color.getGreen() + ";" + color.getBlue() + ";" + plein + ";" + texte;
    }

    /**
     * Méthode qui permet de créer un objet Dessin à partir d'une chaîne de caractères
     *
     * @param dessinString
     *            La chaîne de caractères à convertir
     * @return L'objet Dessin correspondant
     */
    public static Dessin fromString(String dessinString) {
        // Si le String est null (le client s'est déconnecté), on aura une erreur mais on ne s'en soucie pas
        // car le dessin sera ignoré donc ça n'ira pas plus loin

        // Diviser la chaîne de caractères en parties séparées par des virgules
        String[] parts = dessinString.split(";");

        // Convertir chaque partie en la valeur appropriée
        int type = Integer.parseInt(parts[0]);
        int x = Integer.parseInt(parts[1]);
        int y = Integer.parseInt(parts[2]);
        int width = Integer.parseInt(parts[3]);
        int height = Integer.parseInt(parts[4]);
        Color color = new Color(Integer.parseInt(parts[5]), Integer.parseInt(parts[6]), Integer.parseInt(parts[7]));
        boolean plein = Boolean.parseBoolean(parts[8]);
        String texte = parts[9];

        // Créer l'objet Dessin correspondant
        return new Dessin(type, x, y, width, height, color, plein, texte);
    }
}
