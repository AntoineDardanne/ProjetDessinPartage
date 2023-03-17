package IHM;

import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PanelPaletteForme {
    private JPanel panel;
    private ArrayList<JButton> listeBoutons;
    private String formeSelectionnee;

    public PanelPaletteForme() {
        panel = new JPanel();
        panel.setPreferredSize(new Dimension(100, 100));
        panel.setBackground(Color.WHITE);
        panel.setLayout(new GridLayout(2, 2));

        listeBoutons = new ArrayList<JButton>();

        JButton bouton1 = new JButton();
        bouton1.setText("Carré");
        bouton1.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                formeSelectionnee = "Carré";
            }
        });
        listeBoutons.add(bouton1);

        JButton bouton2 = new JButton();
        bouton2.setText("Rond");
        bouton2.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                formeSelectionnee = "Rond";
            }
        });
        listeBoutons.add(bouton2);

        JButton bouton3 = new JButton();
        bouton3.setText("Ligne");
        bouton3.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                formeSelectionnee = "Ligne";
            }
        });
        listeBoutons.add(bouton3);

        JButton bouton4 = new JButton();
        bouton4.setText("Texte");
        bouton4.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                formeSelectionnee = "Texte";
            }
        });
        listeBoutons.add(bouton4);

        JButton bouton5 = new JButton();
        bouton5.setText("Undo");
        bouton5.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                formeSelectionnee = "Undo";
            }
        });
        listeBoutons.add(bouton5);

        JButton bouton6 = new JButton();
        bouton6.setText("Plein/Vide");
        bouton6.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                formeSelectionnee = "Plein/Vide";
            }
        });
        listeBoutons.add(bouton6);

        for (JButton bouton : listeBoutons) {
            panel.add(bouton);
        }
    }

    public JPanel getPanel() {
        return panel;
    }

    public String getFormeSelectionnee() {
        return formeSelectionnee;
    }
    
}
