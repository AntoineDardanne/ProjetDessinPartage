package main;

import IHM.FrameManager;
import IHM.FramePaint;
import metier.Dessin;
import server.ServeurDessin;
import server.ClientDessin;

import java.util.ArrayList;

public class Controleur
{
    private FrameManager frameManager;
    private FramePaint framePaint;
    private ServeurDessin serveur;
    private ClientDessin client;
    private boolean estServeur;

    public Controleur()
    {
        this.frameManager = new FrameManager(this);
    }

    public static void main(String[] args)
    {
        new Controleur();
    }

    public FramePaint getFramePaint()
    {
        return framePaint;
    }

    public void setFramePaint(FramePaint framePaint)
    {
        this.framePaint = framePaint;
    }

    public void setServeur(ServeurDessin serveur)
    {
        this.serveur = serveur;
    }

    public void ajouterDessinIHM(Dessin dessin) {
        // Ajouter le dessin dans la liste des dessins de PanelDessin
        System.out.println("8: Ajout du dessin dans la liste via le controleur");
        do {
            try {
                Thread.sleep(100);
                System.out.println("8.1: Attente de la création de la framePaint");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (framePaint == null);
        framePaint.getPanelDessin().ajouterDessin(dessin);
    }

    public void envoyerDessin(Dessin dessin) {
        if (estServeur) {
            serveur.envoiDessinAll(dessin.toSend());
        } else {
            client.envoyerNouveauDessin(dessin.toSend());
        }

    }

    public void setFrameManager(FrameManager frameManager) {
        this.frameManager = frameManager;
    }

    public void setClient(ClientDessin client) {
        this.client = client;
    }

    public void setEstServeur(boolean estServeur) {
        this.estServeur = estServeur;
    }

    public boolean getEstServeur() {
        return estServeur;
    }

    public ArrayList<Dessin> getDessins() {
        return framePaint.getPanelDessin().getDessinsClient();
    }
    
}
