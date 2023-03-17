package IHM;

import javax.swing.JButton;
import javax.swing.JPanel;

import main.Controleur;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class PanelPaletteForme extends JPanel
{
    private Controleur ctrl;

    private JPanel panel;
    private ArrayList<JButton> listeBoutons;
    private String formeSelectionnee;

    public PanelPaletteForme(Controleur ctrl) 
    {
        this.ctrl = ctrl;

        this.panel = new JPanel();

        listeBoutons = new ArrayList<JButton>();

        // Création des boutons
        for (int i = 0; i < 6; i++) {
            JButton bouton = new JButton();
            bouton.setBackground(Color.WHITE);
            bouton.setPreferredSize(new Dimension(125, 50));
            listeBoutons.add(bouton);
        }

        // Ajout des boutons au panel
        for (JButton bouton : listeBoutons) {
            this.panel.add(bouton);
        }

        // Ajout des noms aux boutons
        listeBoutons.get(0).setText("Carré");
        listeBoutons.get(1).setText("Rond");
        listeBoutons.get(2).setText("Ligne");
        listeBoutons.get(3).setText("Texte");
        listeBoutons.get(4).setText("Undo");
        listeBoutons.get(5).setText("Plein/Vide");

        // Ajout du panel à la palette
        this.add(this.panel);

    }

    public String getFormeSelectionnee()
    {
        return formeSelectionnee;
    }

    public void ActionPerformed(ActionEvent e)
    {
        if (e.getSource() == listeBoutons.get(0)) {
            formeSelectionnee = "Carré";
        } else if (e.getSource() == listeBoutons.get(1)) {
            formeSelectionnee = "Rond";
        } else if (e.getSource() == listeBoutons.get(2)) {
            formeSelectionnee = "Ligne";
        } else if (e.getSource() == listeBoutons.get(3)) {
            formeSelectionnee = "Texte";
        } else if (e.getSource() == listeBoutons.get(4)) {
            formeSelectionnee = "Undo";
        } else if (e.getSource() == listeBoutons.get(5)) {
            formeSelectionnee = "Plein/Vide";
        }
    }
    
}
