package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;

import main.Controleur;
import metier.Dessin;

/**
 * Classe qui gère le serveur
 *
 * @author Antoine Dardanne, Noemie Claccin
 * @version 1.0
 */
public class ServeurDessin {
	private ArrayList<ClientDessin> clients = new ArrayList<>();
	private Controleur ctrl;

	/**
	 * Constructeur de la classe ServeurDessin
	 *
	 * @param ctrl
	 *            Le controleur
	 * @throws IOException
	 */
	public ServeurDessin(Controleur ctrl) throws IOException {
		this.ctrl = ctrl;
		ctrl.setServeur(this);
		// Créer un socket serveur pour écouter les connexions des clients
		ServerSocket serverSocket = new ServerSocket(5678);


		while (true) {
			// Accepter une connexion entrante
			Socket clientSocket = serverSocket.accept();
			ClientDessin client = new ClientDessin(ctrl, clientSocket);
			clients.add(client);

			//Envoi de la liste des dessins au nouveau client
			ArrayList<Dessin> dessins = ctrl.getDessins();
			synchronized (dessins) {
				for (Dessin d : dessins) {
					//Converti le dessin en chaine de caractère
					PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
					out.println(d.toSend());
				}
			}

			// Créer un thread pour gérer chaque client
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						// Créer un flux d'entrée pour lire les données envoyées par le client
						BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
						System.out.println("3: Connexion de " + clientSocket.getInetAddress());

						while (true) {
							// Lire les données envoyées par le client
							String dessinString = in.readLine();
							System.out.println("4: Reçu de " + clientSocket.getInetAddress() + " : " + dessinString);

							// Envoyer le dessin à tous les clients
							synchronized (clients) {
								for (ClientDessin c : clients) {
									if (c != client) {
										PrintWriter out = new PrintWriter(c.getSocket().getOutputStream(), true);
										out.println(dessinString);
									}
								}
							}

							// Convertir la chaîne de caractères en un objet Dessin
							Dessin dessin = Dessin.fromString(dessinString);

							// Ajouter le dessin à la liste
							synchronized (dessins) {
								dessins.add(dessin);
								envoiDessinIHM(dessin);
							}
						}
					} catch (SocketException e) {
						System.out.println("Client déconnecté");
						// Supprimer le client de la liste
						clients.remove(client);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}).start();
		}
	}

	/**
	 * Envoi le dessin à tous les clients
	 *
	 * @param dessinString
	 *            Le dessin sous forme de chaine de caractères
	 */
	public void envoiDessinAll(String dessinString) {
		System.out.println("Envoi du dessin à tous les clients {" + dessinString + "}");
		synchronized (clients) {
			for (ClientDessin c : clients) {
				try {
					PrintWriter out = new PrintWriter(c.getSocket().getOutputStream(), true);
					out.println(dessinString);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * Envoi le dessin à l'IHM
	 *
	 * @param dessin
	 *            Le dessin
	 */
	public void envoiDessinIHM(Dessin dessin) {
		System.out.println("7: Envoi du dessin à l'IHM en tant que serveur");
		ctrl.ajouterDessinIHM(dessin);
	}
}
