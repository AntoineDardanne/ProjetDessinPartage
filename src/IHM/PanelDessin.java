package IHM;

import javax.swing.JPanel;

import main.Controleur;
import metier.Couleur;

import java.awt.Color;
import java.awt.event.*;




public class PanelDessin extends JPanel
{
    private Controleur ctrl;

    private JPanel panel;
    private Couleur couleurSelectionnee;

    private int x1, y1;
    private int x2, y2;

    public PanelDessin(Controleur ctrl)
    {
        this.ctrl = ctrl;

        this.panel = new JPanel();
        this.panel.setBackground(Color.WHITE);
           
    }


    public void initComponent()
    {
        panel = new JPanel();
        panel.setBackground(Color.WHITE);
        
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                x1 = e.getX();
                y1 = e.getY();
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                x2 = e.getX();
                y2 = e.getY();
            }
        });

        panel.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                x2 = e.getX();
                y2 = e.getY();
                ctrl.dessiner(x1, y1, x2, y2);
                x1 = x2;
                y1 = y2;
            }
        });
    }

    public void dessiner(int x12, int y12, int x22, int y22) {
        this.x1 = x12;
        this.y1 = y12;
        this.x2 = x22;
        this.y2 = y22;
        repaint();
    }
}
