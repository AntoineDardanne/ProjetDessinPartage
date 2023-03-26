package main;

import java.awt.Window;
import java.util.ArrayList;

import IHM.FrameManager;
import IHM.FramePaint;
import metier.Dessin;
import server.ClientDessin;
import server.ServeurDessin;

/**
 * Classe qui gère le fonctionnement de l'application
 *
 * @author Antoine Dardanne, Noemie Claccin
 * @version 1.0
 */
public class Controleur {
    private FrameManager frameManager;
    private FramePaint framePaint;
    private ServeurDessin serveur;
    private ClientDessin client;
    private boolean estServeur;

    /**
     * Constructeur du controleur
     */
    public Controleur() {
        this.frameManager = new FrameManager(this);
    }

    /**
     * Méthode main
     *
     * @param args
     *            Arguments de la ligne de commande
     */
    public static void main(String[] args) {
        new Controleur();
    }

    public FramePaint getFramePaint() {
        return framePaint;
    }

    public void setFramePaint(FramePaint framePaint) {
        this.framePaint = framePaint;
    }

    public void setServeur(ServeurDessin serveur) {
        this.serveur = serveur;
    }

    /**
     * Méthode qui permet d'ajouter un dessin dans la liste des dessins du
     * panelDessin
     *
     * @param dessin
     *            Le dessin à ajouter
     */
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

    /**
     * Méthode qui permet d'envoyer un dessin à tous les clients
     *
     * @param dessin
     *            Le dessin à envoyer
     */
    public void envoyerDessin(Dessin dessin) {
        if (estServeur) {
            serveur.envoiDessinAll(dessin.toSend());
        } else {
            client.envoyerNouveauDessin(dessin.toSend());
        }

    }

    public Window getFrameManager() {
        return frameManager;
    }

    public void setFrameManager(FrameManager frameManager) {
        this.frameManager = frameManager;
    }

    public void setEstServeur(boolean b) {
        this.estServeur = b;
    }

    public boolean getEstServeur() {
        return estServeur;
    }

    public void setClient(ClientDessin c) {
        this.client = c;
    }

    public ArrayList<Dessin> getDessins() {
        return framePaint.getPanelDessin().getDessins();
    }


}
