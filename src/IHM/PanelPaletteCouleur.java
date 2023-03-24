package IHM;

import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PanelPaletteCouleur extends JPanel implements ActionListener
{
    private final FramePaint frame;
    private ArrayList<JButton> listeBoutons;

    public PanelPaletteCouleur(FramePaint frame)
    {
        this.frame = frame;
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
            this.add(bouton);
        }

        // Activation des boutons
        for (JButton bouton : listeBoutons) {
            bouton.addActionListener(this);
        }
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