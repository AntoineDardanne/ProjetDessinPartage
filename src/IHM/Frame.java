package IHM;

import main.Controleur;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class Frame extends JFrame
{
    private Controleur ctrl;

    private PanelPaletteCouleur panelPaletteCouleur;
    private PanelPaletteForme panelPaletteForme;
    private PanelDessin panelDessin;

    public Frame(Controleur ctrl) {
        this.ctrl = ctrl;
        this.panelPaletteCouleur = new PanelPaletteCouleur();
        this.panelPaletteForme = new PanelPaletteForme();
        this.panelDessin = new PanelDessin();
    }
}
