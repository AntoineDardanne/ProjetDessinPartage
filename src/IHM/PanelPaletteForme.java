package IHM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PanelPaletteForme extends JPanel implements ActionListener {

    private final FramePaint frame;
    ArrayList<JButton> listeBoutons;
    int selectionForme;

    public PanelPaletteForme(FramePaint frame) {
        this.frame = frame;
        this.setLayout(new GridLayout(1, 4, 5, 5));

        this.listeBoutons = new ArrayList<JButton>();
        for (int i = 0; i < 6; i++) {
            JButton bouton = new JButton();
            bouton.setPreferredSize(new Dimension(125, 50));
            bouton.setBackground(Color.WHITE);
            this.listeBoutons.add(bouton);
        }

        this.listeBoutons.get(0).setText("Carre");
        this.listeBoutons.get(1).setText("Rond");
        this.listeBoutons.get(2).setText("Ligne");
        this.listeBoutons.get(3).setText("Texte");
        this.listeBoutons.get(4).setText("Undo");
        this.listeBoutons.get(5).setText("Vide");

        for (JButton bouton : listeBoutons) {
            this.add(bouton);
        }

        for (JButton bouton : listeBoutons) {
            bouton.addActionListener(this);
        }
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == this.listeBoutons.get(0))
        {
            this.listeBoutons.get(0).setEnabled(false);
            this.listeBoutons.get(1).setEnabled(true);
            this.listeBoutons.get(2).setEnabled(true);
            this.listeBoutons.get(3).setEnabled(true);
            this.listeBoutons.get(4).setEnabled(true);
            this.listeBoutons.get(5).setEnabled(true);
            this.selectionForme = 1;
        }
        else if(e.getSource() == this.listeBoutons.get(1))
        {
            this.listeBoutons.get(0).setEnabled(true);
            this.listeBoutons.get(1).setEnabled(false);
            this.listeBoutons.get(2).setEnabled(true);
            this.listeBoutons.get(3).setEnabled(true);
            this.listeBoutons.get(4).setEnabled(true);
            this.listeBoutons.get(5).setEnabled(true);
            this.selectionForme = 2;
        }
        else if(e.getSource() == this.listeBoutons.get(2))
        {
            this.listeBoutons.get(0).setEnabled(true);
            this.listeBoutons.get(1).setEnabled(true);
            this.listeBoutons.get(2).setEnabled(false);
            this.listeBoutons.get(3).setEnabled(true);
            this.listeBoutons.get(4).setEnabled(true);
            this.listeBoutons.get(5).setEnabled(true);
            this.selectionForme = 3;
        }
        else if(e.getSource() == this.listeBoutons.get(3))
        {
            this.listeBoutons.get(0).setEnabled(true);
            this.listeBoutons.get(1).setEnabled(true);
            this.listeBoutons.get(2).setEnabled(true);
            this.listeBoutons.get(3).setEnabled(false);
            this.listeBoutons.get(4).setEnabled(true);
            this.listeBoutons.get(5).setEnabled(true);
            this.selectionForme = 4;
        }
        else if(e.getSource() == this.listeBoutons.get(4))
        {
            this.listeBoutons.get(0).setEnabled(true);
            this.listeBoutons.get(1).setEnabled(true);
            this.listeBoutons.get(2).setEnabled(true);
            this.listeBoutons.get(3).setEnabled(true);
            this.listeBoutons.get(4).setEnabled(false);
            this.listeBoutons.get(5).setEnabled(true);
            this.selectionForme = 5;
        }
        else if(e.getSource() == this.listeBoutons.get(5)) {
            frame.setFormePleine();
            if (frame.estPleine()) {
                this.listeBoutons.get(5).setText("Plein");
                this.listeBoutons.get(5).setBackground(Color.GREEN);
            } else {
                this.listeBoutons.get(5).setText("Vide");
                this.listeBoutons.get(5).setBackground(Color.WHITE);
            }
        }
    }

    public int getSelectionForme()
    {
        return this.selectionForme;
    }
}
