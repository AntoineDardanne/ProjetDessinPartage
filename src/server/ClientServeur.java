package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import metier.Dessin;

public class ClientServeur extends Thread{
	private ObjectOutputStream out;
	private ObjectInputStream in;
	private Socket socket;
	private ArrayList<Dessin> dessins;
	private String pseudo;

	public ClientServeur(Socket socket, ArrayList<Dessin> dessins) throws IOException {
		this.socket = socket;
		this.dessins = dessins;
	}
	
	public void run() {
		// Quand un client se connecte, on lui envoie tous les dessins
		// qu'il a déjà reçu
		// Puis on attend qu'il nous envoie un dessin
		// Quand on reçoit un dessin, on l'ajoute à la liste des dessins
		// et on l'envoie à tous les autres clients
		// On recommence jusqu'à ce que le client se déconnecte


		/*try {
			out = new ObjectOutputStream(socket.getOutputStream());
			in = new ObjectInputStream(socket.getInputStream());
			out.writeObject(dessins);
			out.flush();

			

		}
		catch (Exception e) {
			e.printStackTrace();
		}*/


		/*try {
			out = new ObjectOutputStream(socket.getOutputStream());
			in = new ObjectInputStream(socket.getInputStream());
			out.writeObject(dessins);
			out.flush();
			
			while (true) {
				Dessin dessin = (Dessin) in.readObject();
				dessins.add(dessin);
				for (ClientServeur client : Serveur.clients) {
					if (client != this) {
						client.out.writeObject(dessin);
						client.out.flush();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}*/
	}
}
