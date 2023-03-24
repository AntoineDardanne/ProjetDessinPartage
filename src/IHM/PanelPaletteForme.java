package IHM;

import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class PanelPaletteForme extends JPanel
{
    private final FramePaint frame;
    private ArrayList<JButton> listeBoutons;
    private String formeSelectionnee;

    public PanelPaletteForme(FramePaint frame) 
    {
        this.frame = frame;

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
            this.add(bouton);
        }

        // Ajout des noms aux boutons
        listeBoutons.get(0).setText("Carré");
        listeBoutons.get(1).setText("Rond");
        listeBoutons.get(2).setText("Ligne");
        listeBoutons.get(3).setText("Texte");
        listeBoutons.get(4).setText("Undo");
        listeBoutons.get(5).setText("Plein/Vide");

    }

    public String getFormeSelectionnee()
    {
        return formeSelectionnee;
    }

    public void ActionPerformed(ActionEvent e)
    {
        if (e.getSource() == listeBoutons.get(0)) {
            frame.setFormeSelectionnee(1);
        } else if (e.getSource() == listeBoutons.get(1)) {
            frame.setFormeSelectionnee(2);
        } else if (e.getSource() == listeBoutons.get(2)) {
            frame.setFormeSelectionnee(3);
        } else if (e.getSource() == listeBoutons.get(3)) {
            frame.setFormeSelectionnee(4);
        } else if (e.getSource() == listeBoutons.get(4)) {
            frame.setFormeSelectionnee(5);
        } else if (e.getSource() == listeBoutons.get(5)) {
            frame.setFormePleine();
            if(frame.estPleine() == true) {
                listeBoutons.get(5).setBackground(Color.GREEN);
                listeBoutons.get(5).setText("Plein");
            } else {
                listeBoutons.get(5).setBackground(null);
                listeBoutons.get(5).setText("Vide");
            }
        }
    }
}
