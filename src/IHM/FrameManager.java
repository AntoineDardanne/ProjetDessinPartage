package IHM;

import main.Controleur;
import server.ClientDessin;
import server.ServeurDessin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;

/**
 * Frame qui permet de choisir entre le mode serveur et le mode client
 *
 * @author Antoine Dardanne, Noemie Claccin
 * @version 1.0
 */

public class FrameManager extends JFrame implements ActionListener {
	Controleur ctrl;
	JPanel panelChoixPseudo;
	JTextField txtPseudo;

	JButton btnServeur;
	JButton btnClient;

	/**
	 * Constructeur de la FrameManager
	 *
	 * @param ctrl
	 *            Le controleur
	 */
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

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.btnServeur) {
			this.dispose();
			String pseudo = recupPseudo();
			ctrl.setEstServeur(true);

			// Création du serveur sur un nouveau thread
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						new ServeurDessin(ctrl);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}).start();

			this.ctrl.setFramePaint(new FramePaint(ctrl, pseudo, true));

			// TODO Auto-generated catch block
		} else if (e.getSource() == this.btnClient) {
			this.dispose();
			ctrl.setEstServeur(false);
			ClientDessin c = new ClientDessin(ctrl);
			ctrl.setClient(c);
			if (c.connecter()) { // Si la connexion a réussi on ouvre la FramePaint
				this.ctrl.setFramePaint(new FramePaint(ctrl, recupPseudo(), false));
			}
		}
	}

	/**
	 * Méthode qui permet de récupérer le pseudo entré par l'utilisateur
	 *
	 * @return Le pseudo entré par l'utilisateur
	 */
	public String recupPseudo() {
		do
		{
			String pseudo = JOptionPane.showInputDialog(null, "Entrez votre pseudo", "Pseudo", JOptionPane.QUESTION_MESSAGE);
			if (pseudo != null ) {
				if (!pseudo.equals("")) {
					return pseudo;
				}
				JOptionPane.showMessageDialog(null, "Le pseudo ne peut pas être vide", "Erreur", JOptionPane.ERROR_MESSAGE);
			}
		} while (true);
	}
}
