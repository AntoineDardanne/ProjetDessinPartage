package IHM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Panel de la palette de couleur
 *
 * @author Antoine Dardanne, Noemie Claccin
 * @version 1.0
 */
public class PanelPaletteCouleur extends JPanel implements ActionListener {

    private final FramePaint frame;
    JButton btnRouge, btnVert, btnBleu, btnJaune, btnNoir, btnBlanc;

    /**
     * Constructeur de la classe PanelPaletteCouleur
     * @param frame
     */
    public PanelPaletteCouleur(FramePaint frame) {
        this.frame = frame;
        this.setLayout(new GridLayout(1, 6, 5, 5));

        this.btnRouge = new JButton();
        this.btnVert = new JButton();
        this.btnBleu = new JButton();
        this.btnJaune = new JButton();
        this.btnNoir = new JButton();
        this.btnBlanc = new JButton();

        this.btnRouge.setPreferredSize(new Dimension(125, 50));
        this.btnVert.setPreferredSize(new Dimension(125, 50));
        this.btnBleu.setPreferredSize(new Dimension(125, 50));
        this.btnJaune.setPreferredSize(new Dimension(125, 50));
        this.btnNoir.setPreferredSize(new Dimension(125, 50));
        this.btnBlanc.setPreferredSize(new Dimension(125, 50));

        this.btnRouge.setBackground(java.awt.Color.RED);
        this.btnVert.setBackground(java.awt.Color.GREEN);
        this.btnBleu.setBackground(java.awt.Color.BLUE);
        this.btnJaune.setBackground(java.awt.Color.YELLOW);
        this.btnNoir.setBackground(java.awt.Color.BLACK);
        this.btnBlanc.setBackground(java.awt.Color.WHITE);

        this.add(btnRouge);
        this.add(btnVert);
        this.add(btnBleu);
        this.add(btnJaune);
        this.add(btnNoir);
        this.add(btnBlanc);

        this.btnRouge.addActionListener(this);
        this.btnVert.addActionListener(this);
        this.btnBleu.addActionListener(this);
        this.btnJaune.addActionListener(this);
        this.btnNoir.addActionListener(this);
        this.btnBlanc.addActionListener(this);
    }

    /**
     * Methode qui permet de gerer les evenements sur les boutons
     * @param actionEvent
     */
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource() == this.btnRouge)
        {
            // disable the button
            this.btnRouge.setEnabled(false);
            // enable the other buttons
            this.btnVert.setEnabled(true);
            this.btnBleu.setEnabled(true);
            this.btnJaune.setEnabled(true);
            this.btnNoir.setEnabled(true);
            this.btnBlanc.setEnabled(true);
            frame.setCouleurSelectionnee(Color.RED);
        }
        else if(actionEvent.getSource() == this.btnVert)
        {
            // disable the button
            this.btnVert.setEnabled(false);
            // enable the other buttons
            this.btnRouge.setEnabled(true);
            this.btnBleu.setEnabled(true);
            this.btnJaune.setEnabled(true);
            this.btnNoir.setEnabled(true);
            this.btnBlanc.setEnabled(true);
            frame.setCouleurSelectionnee(Color.GREEN);
        }
        else if(actionEvent.getSource() == this.btnBleu)
        {
            // disable the button
            this.btnBleu.setEnabled(false);
            // enable the other buttons
            this.btnRouge.setEnabled(true);
            this.btnVert.setEnabled(true);
            this.btnJaune.setEnabled(true);
            this.btnNoir.setEnabled(true);
            this.btnBlanc.setEnabled(true);
            frame.setCouleurSelectionnee(Color.BLUE);
        }
        else if(actionEvent.getSource() == this.btnJaune)
        {
            // disable the button
            this.btnJaune.setEnabled(false);
            // enable the other buttons
            this.btnRouge.setEnabled(true);
            this.btnVert.setEnabled(true);
            this.btnBleu.setEnabled(true);
            this.btnNoir.setEnabled(true);
            this.btnBlanc.setEnabled(true);
            frame.setCouleurSelectionnee(Color.YELLOW);
        }
        else if(actionEvent.getSource() == this.btnNoir)
        {
            // disable the button
            this.btnNoir.setEnabled(false);
            // enable the other buttons
            this.btnRouge.setEnabled(true);
            this.btnVert.setEnabled(true);
            this.btnBleu.setEnabled(true);
            this.btnJaune.setEnabled(true);
            this.btnBlanc.setEnabled(true);
            frame.setCouleurSelectionnee(Color.BLACK);
        }
        else if(actionEvent.getSource() == this.btnBlanc)
        {
            // disable the button
            this.btnBlanc.setEnabled(false);
            // enable the other buttons
            this.btnRouge.setEnabled(true);
            this.btnVert.setEnabled(true);
            this.btnBleu.setEnabled(true);
            this.btnJaune.setEnabled(true);
            this.btnNoir.setEnabled(true);
            frame.setCouleurSelectionnee(Color.WHITE);
        }
    }
}
