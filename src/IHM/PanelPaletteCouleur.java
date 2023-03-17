package IHM;

import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PanelPaletteCouleur extends JPanel
{
    private JPanel panel;
    private ArrayList<JButton> listeBoutons;
    private Color couleurSelectionnee;

    public PanelPaletteCouleur()
    {
        panel = new JPanel();
        panel.setPreferredSize(new Dimension(100, 100));
        panel.setBackground(Color.WHITE);
        panel.setLayout(new GridLayout(2, 2));

        listeBoutons = new ArrayList<JButton>();

        JButton bouton1 = new JButton();
        bouton1.setBackground(Color.RED);
        bouton1.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                couleurSelectionnee = Color.RED;
            }
        });
        listeBoutons.add(bouton1);

        JButton bouton2 = new JButton();
        bouton2.setBackground(Color.GREEN);
        bouton2.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                couleurSelectionnee = Color.GREEN;
            }
        });
        listeBoutons.add(bouton2);

        JButton bouton3 = new JButton();
        bouton3.setBackground(Color.BLUE);
        bouton3.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                couleurSelectionnee = Color.BLUE;
            }
        });
        listeBoutons.add(bouton3);

        JButton bouton4 = new JButton();
        bouton4.setBackground(Color.YELLOW);
        bouton4.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                couleurSelectionnee = Color.YELLOW;
            }
        });
        listeBoutons.add(bouton4);

        for (JButton bouton : listeBoutons)
        {
            panel.add(bouton);
        }
    }
}