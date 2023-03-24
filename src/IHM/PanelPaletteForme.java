package IHM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PanelPaletteForme extends JPanel implements ActionListener {

    private final FramePaint frame;
    ArrayList<JButton> listeBoutons;
    //JButton btnCarre, btnRond, btnLigne, btnText, btnUndo, btnPleinVide;
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

        /*
        this.btnCarre = new JButton("Carre");
        this.btnRond  = new JButton("Rond");
        this.btnLigne = new JButton("Ligne");
        this.btnText =  new JButton("Texte");
        this.btnUndo = new JButton("Undo");
        this.btnPleinVide = new JButton("Vide");
        */

        /*
        this.add(btnCarre);
        this.add(btnRond);
        this.add(btnLigne);
        this.add(btnText);
        this.add(btnUndo);
        this.add(btnPleinVide);
        */

        for (JButton bouton : listeBoutons) {
            this.add(bouton);
        }

        /*
        this.btnCarre.addActionListener(this);
        this.btnRond.addActionListener(this);
        this.btnLigne.addActionListener(this);
        this.btnText.addActionListener(this);
        this.btnUndo.addActionListener(this);
        this.btnPleinVide.addActionListener(this);
        */

        for (JButton bouton : listeBoutons) {
            bouton.addActionListener(this);
        }
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == this.listeBoutons.get(0))
        {
            frame.setFormeSelectionnee(1);
        }
        {
            frame.setFormeSelectionnee(1);
        }
        if (e.getSource() == this.listeBoutons.get(1))
        {
            frame.setFormeSelectionnee(2);
        }
        if (e.getSource() == this.listeBoutons.get(2))
        {
            frame.setFormeSelectionnee(3);
        }
        if (e.getSource() == this.listeBoutons.get(3))
        {
            frame.setFormeSelectionnee(4);
        }
        if (e.getSource() == this.listeBoutons.get(4))
        {
            frame.undoDessin();
        }
        if (e.getSource() == this.listeBoutons.get(5)) {
            frame.setFormePleine();
            if (frame.estPleine() == true) {
                this.listeBoutons.get(5).setBackground(Color.GREEN);
                this.listeBoutons.get(5).setText("Plein");
            } else {
                this.listeBoutons.get(5).setBackground(null);
                this.listeBoutons.get(5).setText("Vide");
            }

        }
    }

    public int getSelectionForme()
    {
        return this.selectionForme;
    }
}
