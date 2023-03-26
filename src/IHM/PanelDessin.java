package IHM;

import main.Controleur;
import metier.Dessin;

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
	private Color couleurSelectionnee = Color.BLACK;
	private boolean dessinTermine = false;
	private boolean formePleine = false;
	private String texte;
	private ArrayList<Dessin> dessinsClient;
	private Controleur ctrl;

	public PanelDessin(FramePaint frame, Controleur controleur) {
		this.frame = frame;
		this.ctrl = controleur;
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
			// On redesine les dessins du client en fonction de le l'arrayList
			if (!this.dessinsClient.isEmpty()) {
				for (Dessin dessin : dessinsClient) {
					g.setColor(dessin.getCouleur());
					switch (dessin.getType()) {
						case Dessin.CARRE:
							// Carré
							if (dessin.estPleine()) {
								g.fillRect(dessin.getX(), dessin.getY(), dessin.getLargeur(), dessin.getHauteur());
							} else {
								g.drawRect(dessin.getX(), dessin.getY(), dessin.getLargeur(), dessin.getHauteur());
							}
							break;
						case Dessin.ROND:
							// Rond
							if (dessin.estPleine()) {
								g.fillOval(dessin.getX(), dessin.getY(), dessin.getLargeur(), dessin.getHauteur());
							} else {
								g.drawOval(dessin.getX(), dessin.getY(), dessin.getLargeur(), dessin.getHauteur());
							}
							break;
						case Dessin.LIGNE:
							// Ligne
							g.drawLine(dessin.getX(), dessin.getY(), dessin.getLargeur(), dessin.getHauteur());
							break;
						case Dessin.TEXTE:
							// Texte
							g.drawString(dessin.getTexte(), dessin.getX(), dessin.getY());
							break;
					}
				}
			}
			// On dessine le dessin en cours après avoir redessiné les dessins du client
			g.setColor(couleurSelectionnee);
			int width;
			int height;
			int x;
			int y;
			switch (this.formeSelectionnee) {
				case Dessin.CARRE:
					// Carré
					width = Math.abs(x2 - x1);
					height = Math.abs(y2 - y1);
					x = Math.min(x1, x2);
					y = Math.min(y1, y2);
					if (dessinTermine) {
						Dessin dessin = new Dessin(this.formeSelectionnee, x, y, width, height, couleurSelectionnee, formePleine, null);
						dessinsClient.add(dessin);
						ctrl.envoyerDessin(dessin);
						dessinTermine = false;
					}
					if (formePleine) {
						g.fillRect(x, y, width, height);
					} else {
						g.drawRect(x, y, width, height);
					}
					break;
				case Dessin.ROND:
					// Rond
					width = Math.abs(x2 - x1);
					height = Math.abs(y2 - y1);
					x = Math.min(x1, x2);
					y = Math.min(y1, y2);
					if (dessinTermine) {
						dessinsClient.add(new Dessin(this.formeSelectionnee, x, y, width, height, couleurSelectionnee, formePleine, ""));
						dessinTermine = false;
					}
					if (formePleine) {
						g.fillOval(x, y, width, height);
					} else {
						g.drawOval(x, y, width, height);
					}
					break;
				case Dessin.LIGNE:
					// Ligne
					if (dessinTermine) {
						dessinsClient.add(new Dessin(this.formeSelectionnee, x1, y1, x2, y2, couleurSelectionnee, false, ""));
						dessinTermine = false;
					}
					g.drawLine(x1, y1, x2, y2);
					break;
				case Dessin.TEXTE:
					// Texte
					g.drawString(texte, x1, y1);
					if (dessinTermine) {
						dessinsClient.add(new Dessin(this.formeSelectionnee, x1, y1, 0, 0, couleurSelectionnee, false, texte));
						dessinTermine = false;
					}
					break;
			}
		}
	}

	public void setFormeSelectionnee(int formeSelectionnee) {
		this.formeSelectionnee = formeSelectionnee;
	}

	public int getSelectionForme() {
		return this.formeSelectionnee;
	}

	public void setCouleurSelectionnee(Color couleurSelectionnee) {
		this.couleurSelectionnee = couleurSelectionnee;
	}

	public void undoDessin() {
		if (!dessinsClient.isEmpty()) {
			dessinsClient.remove(dessinsClient.size() - 1);
			this.revalidate();
			this.repaint();
			frame.majIHM();
		}
	}

	public void setFormePleine() {
		this.formePleine = !formePleine;
	}

	public boolean estPleine() {
		return formePleine;
	}

	public void ajouterDessin(Dessin dessin) {
		this.dessinsClient.add(dessin);
		this.revalidate();
		this.repaint();
	}

	public ArrayList<Dessin> getDessinsClient() {
		return dessinsClient;
	}

}
