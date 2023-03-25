package IHM;

import main.Controleur;
import metier.Dessin;
import server.ClientDessin;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class FramePaint extends JFrame {

	Controleur ctrl;
	PanelPaletteForme panelFormes;
    PanelPaletteCouleur panelCouleur;
	PanelDessin panelDessin;
	ArrayList<Dessin> dessinsDuDessins;


	public FramePaint(Controleur ctrl, String titre, boolean estServeur) {
		this.ctrl = ctrl;
		this.setTitle("PaintMulti - " + titre + " - " + (estServeur ? "Serveur" : "Client"));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setLayout(new BorderLayout());

		this.dessinsDuDessins = PanelDessin.dessinsDuDessins;

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
					if(ClientDessin.getIp() == ip)
					{
						 break;
					}
					break;
				}
				

			}
			while(!ctrl.connecterServeur());
		}

		this.panelFormes = new PanelPaletteForme(this);
		this.panelDessin = new PanelDessin(this,dessinsDuDessins);
		this.panelCouleur = new PanelPaletteCouleur(this);


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

	public boolean estPleine()
	{
		return this.panelDessin.estPleine();
	}

	public void majIHM()
	{
		this.revalidate();
		this.repaint();
	}

}
