package IHM;

import main.Controleur;
import metier.Dessin;

import javax.swing.*;
import java.awt.*;

/**
 * Frame qui contient les panels de la palette de formes, de la palette de couleurs et du panel de dessin
 *
 * @author Antoine Dardanne, Noemie Claccin
 * @version 1.0
 */
public class FramePaint extends JFrame {

	Controleur ctrl;
	PanelPaletteForme panelFormes;
	PanelDessin panelDessin;
	PanelPaletteCouleur panelCouleur;


	/**
	 * Constructeur de la FramePaint
	 *
	 * @param ctrl
	 *            Le controleur
	 * @param pseudo
	 *            Le pseudo de l'utilisateur
	 * @param estServeur
	 *            Si l'utilisateur est serveur ou non
	 */
	public FramePaint(Controleur ctrl, String pseudo, boolean estServeur) {
		this.ctrl = ctrl;
		this.setTitle("PaintMulti - " + pseudo + " - " + (estServeur ? "(Serveur)" : "(Client)"));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setLayout(new BorderLayout());

		panelFormes = new PanelPaletteForme(this);
		panelDessin = new PanelDessin(this, ctrl);
		panelCouleur = new PanelPaletteCouleur(this);

		this.add(panelFormes, BorderLayout.NORTH);
		this.add(panelDessin, BorderLayout.CENTER);
		this.add(panelCouleur, BorderLayout.SOUTH);

		this.setBackground(Color.magenta);


		this.setVisible(true);
	}

	/**
	 * Permet de changer la forme selectionnee
	 *
	 * @param formeSelectionnee
	 *            La forme selectionnee
	 */
	public void setFormeSelectionnee(int formeSelectionnee) {
		this.panelDessin.setFormeSelectionnee(formeSelectionnee);
	}

	/**
	 * Permet de changer la couleur selectionnee
	 *
	 * @param couleurSelectionnee
	 *            La couleur selectionnee
	 */
	public void setCouleurSelectionnee(Color couleurSelectionnee) {
		this.panelDessin.setCouleurSelectionnee(couleurSelectionnee);
	}

	public void undoDessin() {this.panelDessin.undoDessin();}

	public void setFormePleine() {
		this.panelDessin.setFormePleine();
	}
	public boolean estPleine()
	{return this.panelDessin.estPleine();}

	/**
	 * Permet de mettre a jour l'IHM
	 */
	public void majIHM()
	{
		this.revalidate();
		this.repaint();
	}

	/**
	 * Permet d'ajouter un dessin au panel de dessin
	 *
	 * @param dessin
	 *            Le dessin a ajouter
	 */
	public void ajouterDessin(Dessin dessin) {
		this.panelDessin.ajouterDessin(dessin);
	}

	public PanelDessin getPanelDessin() {
		return panelDessin;
	}

}
