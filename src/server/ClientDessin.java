package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import javax.swing.JOptionPane;

import main.Controleur;
import IHM.FrameManager;
import metier.Dessin;

/**
 * Classe qui gère les clients
 *
 * @author Antoine Dardanne, Noemie Claccin
 * @version 1.0
 */
public class ClientDessin {
	private Controleur ctrl;
	private Socket socket;
	private boolean connexion;

	/**
	 * Constructeur du client
	 * @param controleur
	 * @param socket
	 * @throws IOException
	 */
	public ClientDessin(Controleur controleur, Socket socket) throws IOException {
		this.ctrl = controleur;
		this.socket = socket;

		// Créer un thread pour recevoir les dessins envoyés par le serveur
		Thread thread = new Thread(() -> {
			try {
				// Créer un flux d'entrée pour lire les données envoyées par le serveur
				BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				while (true) {
					// Lire les données envoyées par le serveur
					String dessinString = in.readLine();
					System.out.println("6: Reçu de " + socket.getInetAddress() + " : " + dessinString + "je suis " + this.getSocket().getInetAddress());
					// Convertir la chaîne de caractères en objet Dessin
					Dessin dessin = Dessin.fromString(dessinString);
					// Ajouter le dessin à la liste
					envoiDessinIHM(dessin);
				}
			} catch (SocketException e) {
				//if(!controleur.getEstServeur()) // Empèche le message d'erreur si on est serveur
				{
					// Popup d'erreur si le serveur s'est déconnecté
					JOptionPane.showMessageDialog(null, "Le serveur s'est déconnecté", "Erreur", JOptionPane.ERROR_MESSAGE);
					//ferme l'application et relance le menu
					controleur.getFramePaint().dispose();
					controleur.setFrameManager(new FrameManager(controleur));
				}
				// Le if ne devrait pas etre necessaire mais c'est tellement du bidouillage, faudrait reprendre propre mais plus le temps
			} catch (
					Exception e) {
				e.printStackTrace();
			}

		});
		thread.start();
	}

	public ClientDessin(Controleur ctrl) {
		// Se connecter au serveur
		try {
			// Créer un socket pour se connecter au serveur
			this.socket = new Socket("localhost", 5678); // même machine
			//this.socket = new Socket("...", 12345); // autre machine


			new ClientDessin(ctrl, socket);
			connexion = true;
		} catch (Exception e) {
			//Popup d'erreur si le serveur n'est pas lancé
			JOptionPane.showMessageDialog(null, "Le serveur n'est pas lancé", "Erreur", JOptionPane.ERROR_MESSAGE);
			//ferme l'application si le serveur n'est pas lancé et relance le menu
			connexion = false;
			new Controleur();
		}
	}

	/**
	 * Envoi le dessin au serveur
	 * @param dessinString
	 */
	public void envoyerNouveauDessin(String dessinString) {
		try {
			System.out.println("3: Envoi du dessin au serveur (writeUTF)");
			// Créer un flux de sortie pour envoyer le nouveau dessin au serveur
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true); // true pour auto-flush (envoi immédiat), important !
			// Envoyer la chaîne de caractères au serveur
			out.println(dessinString);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Envoi le dessin à l'IHM
	 * @param dessin
	 */
	public void envoiDessinIHM(Dessin dessin) {
		System.out.println("7: Envoi du dessin à l'IHM en tant que client");
		ctrl.ajouterDessinIHM(dessin);
	}

	/**
	 * Récupération du socket
	 */
	public Socket getSocket() {
		return this.socket;
	}

	/**
	 * Récupération de la connexion
	 */
	public boolean connecter() {
		return this.connexion;
	}

}