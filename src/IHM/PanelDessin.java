package IHM;

import javax.swing.JPanel;

import main.Controleur;
import metier.Couleur;

import java.awt.Color;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.BasicStroke;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;


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

    public void MouseEvent(MouseEvent e)
    {
        if (e.getButton() == MouseEvent.BUTTON1) {
            System.out.println("Clic gauche");
            // On récupère la position du clic
            this.x1 = e.getX();
            this.y1 = e.getY();

        } else if (e.getButton() == MouseEvent.BUTTON3) {
            System.out.println("Clic droit");
            // On récupère la position du clic
            this.x2 = e.getX();
            this.y2 = e.getY();
        }

        // On dessine la forme
        String formeSelectionnee = ctrl.getIhm().getPaletteForme().getFormeSelectionnee();
        Graphics2D g2 = (Graphics2D) this.panel.getGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setStroke(new BasicStroke(3));

        if (formeSelectionnee == "Carré") {
            g2.setColor(ctrl.getIhm().getPaletteCouleur().getCouleurSelectionnee());
            g2.fill(new Rectangle2D.Double(this.x1, this.y1, 100, 100));
        } else if (formeSelectionnee == "Rond") {
            g2.setColor(ctrl.getIhm().getPaletteCouleur().getCouleurSelectionnee());
            g2.fill(new Rectangle2D.Double(this.x1, this.y1, 100, 100));
        } else if (formeSelectionnee == "Ligne") {
            g2.setColor(ctrl.getIhm().getPaletteCouleur().getCouleurSelectionnee());
            g2.draw(new Line2D.Double(this.x1, this.y1, 200, 200));
        } else if (formeSelectionnee == "Texte") {
            g2.setColor(ctrl.getIhm().getPaletteCouleur().getCouleurSelectionnee());
            g2.drawString("Hello World", this.x1, this.y1);
        }

        // On redessine le panel
        this.panel.repaint();
    }
    
}
