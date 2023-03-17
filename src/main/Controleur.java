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
        metier = new Metier();
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
}
