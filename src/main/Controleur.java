package main;

import IHM.FrameManager;
import server.*;

public class Controleur
{
    public Controleur()
    {
        FrameManager frameManager = new FrameManager(this);
    }

    public static void main(String[] args)
    {
        new Controleur();
    }

    public boolean connecterServeur()
    {
        return false;
    }

    public void setIpServeur(String ip)
    {
        ServeurDessin serveur = new ServeurDessin(ip);
    }
}
