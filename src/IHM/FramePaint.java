package src.IHM;

import src.Controleur;

import javax.swing.*;
import java.awt.*;

public class FramePaint extends JFrame {

	Controleur ctrl;
	panelPaletteForme panelFormes;
    panelPaletteCouleur panelCouleur;


	public FramePaint(Controleur ctrl, String titre, boolean estServeur) {
		this.ctrl = ctrl;
		this.setTitle("PaintMulti - " + titre + " - " + (estServeur ? "Serveur" : "Client"));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setLayout(new BorderLayout());

		//acceuil avec popup pour choisir le serveur si on est client
		if(!estServeur)
		{
			do
			{
				String ip = JOptionPane.showInputDialog("Entrez l'adresse IP du serveur");
				if(ip == null)
				{
					System.exit(0);
				}
				else
				{
					ctrl.setIpServeur(ip);
				}
			}
			while(!ctrl.connecterServeur());
		}

		this.panelFormes = new PanelFormes(this);
		this.panelDessin = new PanelDessin(this);
		this.panelCouleur = new PanelCouleur(this);


		this.add(panelFormes, BorderLayout.NORTH);
		this.add(panelDessin, BorderLayout.CENTER);
		this.add(panelCouleur, BorderLayout.SOUTH);


		this.setVisible(true);
	}

	public void setFormeSelectionnee(int formeSelectionnee) {
		this.panelDessin.setFormeSelectionnee(formeSelectionnee);
	}

	public void setCouleurSelectionnee(Color couleurSelectionnee) {
		this.panelDessin.setCouleurSelectionnee(couleurSelectionnee);
	}
	public void undoDessin() {this.panelDessin.undoDessin();}

	public void setFormePleine() {
		this.panelDessin.setFormePleine();
	}

	public boolean estPlein()
	{
		return this.panelDessin.estPlein();
	}

	public void majIHM()
	{
		this.revalidate();
		this.repaint();
	}

}
