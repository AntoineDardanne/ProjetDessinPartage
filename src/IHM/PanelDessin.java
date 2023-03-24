package src.IHM;

import src.Metier.Dessin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class PanelDessin extends JPanel {

	private FramePaint frame;
	private int x1, y1, x2, y2;
	private int formeSelectionnee;
	private Color couleurSelectionnee;
	private boolean dessinTermine = false;
	private boolean formePleine = false;
	private String texte;
	ArrayList<Dessin> dessinsClient = new ArrayList<Dessin>();

	public PanelDessin(FramePaint frame)
    {
		this.frame = frame;
		this.setBackground(Color.WHITE);
		
        // ArrayList pour stocker les dessins du client
		this.dessinsClient = new ArrayList<Dessin>();
		setBackground(Color.WHITE);
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				x1 = x2 = e.getX();
				y1 = y2 = e.getY();

				if (getSelectionForme() == 4) {
					texte = JOptionPane.showInputDialog("Entrez le texte à écrire");
					dessinTermine = true;
					if (texte == null) {
						System.out.println("Texte null");
						return;
					}
				}
				repaint();
			}

			public void mouseReleased(MouseEvent e) {
				x2 = e.getX();
				y2 = e.getY();
				dessinTermine = true;
				repaint();
			}
		});
		addMouseMotionListener(new MouseAdapter() {
			public void mouseDragged(MouseEvent e) {
				x2 = e.getX();
				y2 = e.getY();
				repaint();
			}
		});
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		if (x1 != 0 && x2 != 0 && y1 != 0 && y2 != 0) {
			// On redessine les dessins du client en fonction de le l'arrayList
			if (!this.dessinsClient.isEmpty()) {
				for (Dessin dessin : dessinsClient) {
					g.setColor(dessin.getColor());
					switch (dessin.getType()) {
						case 1:
							// Carré
							if (dessin.isFilled()) {
								g.fillRect(dessin.getX(), dessin.getY(), dessin.getWidth(), dessin.getHeight());
							} else {
								g.drawRect(dessin.getX(), dessin.getY(), dessin.getWidth(), dessin.getHeight());
							}
							break;
						case 2:
							// Rond
							if (dessin.isFilled()) {
								g.fillOval(dessin.getX(), dessin.getY(), dessin.getWidth(), dessin.getHeight());
							} else {
								g.drawOval(dessin.getX(), dessin.getY(), dessin.getWidth(), dessin.getHeight());
							}
							break;
						case 3:
							// Ligne
							g.drawLine(dessin.getX(), dessin.getY(), dessin.getWidth(), dessin.getHeight());
							break;
						case 4:
							// Texte
							g.drawString(dessin.getTexte(), dessin.getX(), dessin.getY());
							break;
					}
				}
			}
			// On dessine le dessin en cours après avoir redessiné les dessins du client
			g.setColor(couleurActu);
			int width, height, x, y;
			switch (this.selectionForme) {
				case 1:
					// Carré
					width = Math.abs(x2 - x1);
					height = Math.abs(y2 - y1);
					x = Math.min(x1, x2);
					y = Math.min(y1, y2);
					if (dessinTermine) {
						dessinsClient.add(new Dessin(this.selectionForme, x, y, width, height, couleurActu, plein));
						dessinTermine = false;
					}
					if (plein) {
						g.fillRect(x, y, width, height);
					} else {
						g.drawRect(x, y, width, height);
					}
					break;
				case 2:
					// Rond
					width = Math.abs(x2 - x1);
					height = Math.abs(y2 - y1);
					x = Math.min(x1, x2);
					y = Math.min(y1, y2);
					if (dessinTermine) {
						dessinsClient.add(new Dessin(this.selectionForme, x, y, width, height, couleurActu, plein));
						dessinTermine = false;
					}
					if (plein) {
						g.fillOval(x, y, width, height);
					} else {
						g.drawOval(x, y, width, height);
					}
					break;
				case 3:
					// Ligne
					if (dessinTermine) {
						dessinsClient.add(new Dessin(this.selectionForme, x1, y1, x2, y2, couleurActu, false));
						dessinTermine = false;
					}
					g.drawLine(x1, y1, x2, y2);
					break;
				case 4:
					// Texte
					g.drawString(texte, x1, y1);
					if (dessinTermine) {
						dessinsClient.add(new Dessin(this.selectionForme, x1, y1, 0, 0, couleurActu, false, texte));
						dessinTermine = false;
					}
					break;
			}
		}
	}

	public void setFormeSelectionnee(int selectionForme) { this.formeSelectionnee = formeSelectionnee; }

	public int getFormeSelectionnee() { return this.formeSelectionnee; }

	public void setChoixCouleur(Color couleurSelectionnee) { this.couleurSelectionnee = couleurSelectionnee; }

	public void undoDessin() {
		if (!dessinsClient.isEmpty()) {
			dessinsClient.remove(dessinsClient.size() - 1);
			this.revalidate();
			this.repaint();
			frame.majIHM();
		}
	}

	public void setFormePleine() { this.formePleine = !formePleine; }

	public boolean getFormePleine() { return formePleine; }

}
