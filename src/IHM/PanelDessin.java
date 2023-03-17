package IHM;

import javax.swing.JButton;
import javax.swing.JPanel;

import metier.Couleur;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PanelDessin {
    // On cherche à faire un panel sur lequel lorsque l'on clique, on dessine une forme qui
    // a été sélectionnée dans la palette de forme et qui a une couleur qui a été sélectionnée
    // dans la palette de couleur.

    private JPanel panel;

    private Couleur couleurSelectionnee;

    public PanelDessin()
    {
        panel = new JPanel();
        panel.setPreferredSize(new Dimension(100, 100));
        panel.setBackground(Color.WHITE);
        panel.setLayout(new GridLayout(2, 2));

           
    }
    
}
