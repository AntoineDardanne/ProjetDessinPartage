package IHM;

import main.Controleur;

import javax.swing.JFrame;

import java.awt.BorderLayout;

public class Frame extends JFrame
{
    private Controleur ctrl;

    private PanelPaletteCouleur panelPaletteCouleur;
    private PanelPaletteForme panelPaletteForme;
    private PanelDessin panelDessin;

    public Frame(Controleur ctrl) {
        this.ctrl = ctrl;
        this.panelPaletteCouleur = new PanelPaletteCouleur(this.ctrl);
        this.panelPaletteForme = new PanelPaletteForme(this.ctrl);
        this.panelDessin = new PanelDessin(this.ctrl);

        this.setTitle("Dessin");
        this.setSize(2000, 1000);
        this.setLayout(new BorderLayout());
        this.setLocation(0, 0);
        
        
        // Ajout des panels
        this.add(this.panelPaletteCouleur, BorderLayout.SOUTH);
        this.add(this.panelPaletteForme, BorderLayout.NORTH);
        this.add(this.panelDessin, BorderLayout.CENTER);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setVisible(true);

        
    }

    // Méthode getPaletteForme
    public PanelPaletteForme getPaletteForme() {
        return this.panelPaletteForme;
    }

    // Méthode getPaletteCouleur
    public PanelPaletteCouleur getPaletteCouleur() {
        return this.panelPaletteCouleur;
    }

    public void dessiner(int x1, int y1, int x2, int y2) {
        this.panelDessin.dessiner(x1, y1, x2, y2);
    }
}
