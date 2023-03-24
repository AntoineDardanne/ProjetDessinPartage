package server;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import metier.Dessin;
import metier.StockDessin;

public class ServeurDessin {
	private ServerSocket serverSocket;
	static ArrayList<ClientDessin> clients;
	private ArrayList<Dessin> dessins;

	public ServeurDessin() {
		dessins = new ArrayList<Dessin>(); 
		clients = new ArrayList<ClientDessin>();

		try {
			serverSocket = new ServerSocket(1234);
			System.out.println("Serveur démarré sur le port ?");
			while (true) {
				Socket socket = serverSocket.accept();
				System.out.println("Nouveau client connecté");
				ClientDessin client = new ClientDessin(socket, dessins);
				clients.add(client);
				client.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}