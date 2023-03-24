package src.IHM;

import src.Controleur;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

// Frame permettant de choisir entre le mode serveur ou client
public class FrameManager extends JFrame implements ActionListener { 
	Controleur ctrl;
	JPanel panelChoixPseudo;
	JTextField txtPseudo;

	JButton btnServeur;
	JButton btnClient;


	public FrameManager(Controleur ctrl) {
		this.ctrl = ctrl;
		this.setTitle("PaintMulti - Choix du mode");
		this.setResizable(false);

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setMinimumSize(new Dimension((int) dim.getWidth() - 450, (int) dim.getHeight() - 350));
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2 - 50);

		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints layoutCons = new GridBagConstraints();
		layoutCons.fill = GridBagConstraints.HORIZONTAL;
		layoutCons.insets = new Insets(0, 100, 0, 100);
		layout.setConstraints(this, layoutCons);

		// Contenu de la Frame
		this.btnServeur = new JButton("Serveur");
		this.btnClient = new JButton("Client");
		this.btnServeur.setPreferredSize(new Dimension(240, 80));
		this.btnClient.setPreferredSize(new Dimension(240, 80));

		// Ajout des composants
		layout.addLayoutComponent(btnServeur, layoutCons);
		layout.addLayoutComponent(btnClient, layoutCons);

		// Ajout des listeners
		btnServeur.addActionListener(this);
		btnClient.addActionListener(this);

		this.add(btnServeur);
		this.add(btnClient);

		// Options pour la fermeture/apparence de la Frame
		this.setLayout(layout);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.btnServeur) {
			this.dispose();
			new FramePseudo(ctrl, true); // true pour le mode serveur
		} else if (e.getSource() == this.btnClient) {
			this.dispose();
			new FramePseudo(ctrl, false); // false pour le mode client
		}
	}

	
}