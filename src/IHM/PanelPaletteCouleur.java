package IHM;

import main.Controleur;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class PanelPaletteCouleur extends JPanel
{
    private Controleur ctrl;

    private JPanel panel;

    private JScrollPane scrollPane;

    private ArrayList<JButton> listeBoutons;
    private JButton boutonAjoutCouleur;

    private Color couleurSelectionnee;

    public PanelPaletteCouleur(Controleur ctrl)
    {

        this.ctrl = ctrl;

        this.panel = new JPanel();
        //this.scrollPane = new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        //this.scrollPane.setPreferredSize(new Dimension(125, 300));
        this.listeBoutons = new ArrayList<JButton>();

        // Création des boutons
        for (int i = 0; i < 6; i++) {
            JButton bouton = new JButton();
            bouton.setPreferredSize(new Dimension(125, 50));
            this.listeBoutons.add(bouton);
        }
        
        this.boutonAjoutCouleur = new JButton();
        this.boutonAjoutCouleur.setPreferredSize(new Dimension(125, 50));
        this.boutonAjoutCouleur.setText("+");;

        // Changement de couleur des boutons
        this.listeBoutons.get(0).setBackground(Color.BLACK);
        this.listeBoutons.get(1).setBackground(Color.RED);
        this.listeBoutons.get(2).setBackground(Color.BLUE);
        this.listeBoutons.get(3).setBackground(Color.GREEN);
        this.listeBoutons.get(4).setBackground(Color.YELLOW);
        this.listeBoutons.get(5).setBackground(Color.WHITE);

        // Ajout des boutons au panel
        for (JButton bouton : listeBoutons) {
            this.panel.add(bouton);
        }
        this.panel.add(this.boutonAjoutCouleur);

        // Ajout du panel à la palette
        //this.add(this.scrollPane);
        this.add(this.panel);
    }

    public void ActionPerformed(ActionEvent e)
    {
        if (e.getSource() == listeBoutons.get(0)) {
            this.couleurSelectionnee = Color.BLACK;
        } else if (e.getSource() == listeBoutons.get(1)) {
            this.couleurSelectionnee = Color.RED;
        } else if (e.getSource() == listeBoutons.get(2)) {
            this.couleurSelectionnee = Color.BLUE;
        } else if (e.getSource() == listeBoutons.get(3)) {
            this.couleurSelectionnee = Color.GREEN;
        } else if (e.getSource() == listeBoutons.get(4)) {
            this.couleurSelectionnee = Color.YELLOW;
        } else if (e.getSource() == listeBoutons.get(5)) {
            this.couleurSelectionnee = Color.WHITE;
        }

        if (e.getSource() == this.boutonAjoutCouleur) {
            // On ouvre la fenêtre de choix de couleur
            Color couleur = JColorChooser.showDialog(this, "Choisissez une couleur", Color.BLACK);

            // On ajoute le bouton à la liste
            JButton bouton = new JButton();
            bouton.setPreferredSize(new Dimension(125, 50));
            bouton.setBackground(couleur);
            this.listeBoutons.add(bouton);
            this.panel.add(bouton);
        }
    }

    public Color getCouleurSelectionnee()
    {
        return this.couleurSelectionnee;
    }
}