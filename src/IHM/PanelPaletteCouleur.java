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

    private Color couleurSelectionnee;

    public PanelPaletteCouleur(Controleur ctrl)
    {

        this.ctrl = ctrl;

        this.panel = new JPanel();
        this.listeBoutons = new ArrayList<JButton>();

        // Création des boutons
        for (int i = 0; i < 6; i++) {
            JButton bouton = new JButton();
            bouton.setPreferredSize(new Dimension(125, 50));
            this.listeBoutons.add(bouton);
        }
        
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

        // Ajout du panel à la palette
        this.add(this.panel);
    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == listeBoutons.get(0)) {
            frame.setCouleurSelectionnee(Color.BLACK);
        } else if (e.getSource() == listeBoutons.get(1)) {
            frame.setCouleurSelectionnee(Color.RED);
        } else if (e.getSource() == listeBoutons.get(2)) {
            frame.setCouleurSelectionnee(Color.BLUE);
        } else if (e.getSource() == listeBoutons.get(3)) {
            frame.setCouleurSelectionnee(Color.GREEN);
        } else if (e.getSource() == listeBoutons.get(4)) {
            frame.setCouleurSelectionnee(Color.YELLOW);
        } else if (e.getSource() == listeBoutons.get(5)) {
            frame.setCouleurSelectionnee(Color.WHITE);
        }
    }
}