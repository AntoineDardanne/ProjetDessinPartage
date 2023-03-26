package IHM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Panel de la palette de formes
 *
 * @author Antoine Dardanne, Noemie Claccin
 * @version 1.0
 */
public class PanelPaletteForme extends JPanel implements ActionListener {

    private final FramePaint frame;
    JButton btnCarre, btnRond, btnLigne, btnText, btnUndo, btnPleinVide;
    int formeSelectionnee;

    /**
     * Constructeur de la classe PanelPaletteForme
     * @param frame
     */
    public PanelPaletteForme(FramePaint frame) {
        this.frame = frame;
        this.setLayout(new GridLayout(1, 4, 5, 5));

        this.btnCarre = new JButton("Carre");
        this.btnRond  = new JButton("Rond");
        this.btnLigne = new JButton("Ligne");
        this.btnText =  new JButton("Texte");
        this.btnUndo = new JButton("Undo");
        this.btnPleinVide = new JButton("Vide");

        this.btnCarre.setBackground(java.awt.Color.WHITE);
        this.btnRond.setBackground(java.awt.Color.WHITE);
        this.btnLigne.setBackground(java.awt.Color.WHITE);
        this.btnText.setBackground(java.awt.Color.WHITE);
        this.btnUndo.setBackground(java.awt.Color.WHITE);
        this.btnPleinVide.setBackground(Color.RED);

        this.add(btnCarre);
        this.add(btnRond);
        this.add(btnLigne);
        this.add(btnText);
        this.add(btnUndo);
        this.add(btnPleinVide);

        this.btnCarre.addActionListener(this);
        this.btnRond.addActionListener(this);
        this.btnLigne.addActionListener(this);
        this.btnText.addActionListener(this);
        this.btnUndo.addActionListener(this);
        this.btnPleinVide.addActionListener(this);

    }

    /**
     * Methode qui permet de recuperer la forme selectionnee
     * @return
     */
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == this.btnCarre)
        {
            // disabled le bouton
            this.btnCarre.setEnabled(false);
            // enabled les autres boutons
            this.btnRond.setEnabled(true);
            this.btnLigne.setEnabled(true);
            this.btnText.setEnabled(true);

            frame.setFormeSelectionnee(1);
        }
        if (e.getSource() == this.btnRond)
        {
            // disabled le bouton
            this.btnRond.setEnabled(false);
            // enabled les autres boutons
            this.btnCarre.setEnabled(true);
            this.btnLigne.setEnabled(true);
            this.btnText.setEnabled(true);

            frame.setFormeSelectionnee(2);
        }
        if (e.getSource() == this.btnLigne)
        {
            // disabled le bouton
            this.btnLigne.setEnabled(false);
            // enabled les autres boutons
            this.btnCarre.setEnabled(true);
            this.btnRond.setEnabled(true);
            this.btnText.setEnabled(true);

            frame.setFormeSelectionnee(3);
        }
        if (e.getSource() == this.btnText)
        {
            // disabled le bouton
            this.btnText.setEnabled(false);
            // enabled les autres boutons
            this.btnCarre.setEnabled(true);
            this.btnRond.setEnabled(true);
            this.btnLigne.setEnabled(true);
            frame.setFormeSelectionnee(4);
        }
		if (e.getSource() == this.btnUndo)
		{
			frame.undoDessin();
		}
        if (e.getSource() == this.btnPleinVide) {
            frame.setFormePleine();
            if (frame.estPleine() == true) {
                this.btnPleinVide.setBackground(Color.GREEN);
                this.btnPleinVide.setText("Plein");
            } else {
                this.btnPleinVide.setBackground(Color.RED);
                this.btnPleinVide.setText("Vide");
            }
        }
    }

    /**
     * Methode qui permet de recuperer la forme selectionnee
     * @return
     */
    public int getFormeSelectionnee()
    {
        return this.formeSelectionnee;
    }
}
