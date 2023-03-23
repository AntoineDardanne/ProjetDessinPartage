package main;

import IHM.Frame;
import metier.Metier;


public class Controleur
{
    private Frame ihm;
    private Metier metier;
    
    public Controleur()
    {
        ihm = new Frame(this);
        metier = new Metier(this);
    }

    public static void main(String[] args)
    {
        Controleur ctrl = new Controleur();
    }

    public Frame getIhm()
    {
        return ihm;
    }

    public Metier getMetier()
    {
        return metier;
    }

    public void dessiner(int x1, int y1, int x2, int y2) {
        ihm.dessiner(x1, y1, x2, y2);
    }
}
