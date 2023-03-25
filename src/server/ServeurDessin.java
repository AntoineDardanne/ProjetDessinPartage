package server;
/* 
import java.net.ServerSocket;
import java.net.Socket;

public class ServeurDessin
{
    private static final int PORT = 2524;
    private ServerSocket serverSocket;

    public ServeurDessin() {

       
		

		try {

			serverSocket = new ServerSocket(1234);
			System.out.println("Serveur démarré sur le port " + PORT );
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

*/


/* 
import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class ServeurDessin {

    // Numéro de port pour la connexion socket
    private static final int PORT = 9001;

    // ArrayList pour stocker les dessins envoyés par les clients
    private static ArrayList<String> dessins = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        
        // Création d'un objet ServerSocket pour accepter les connexions des clients
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Le serveur de dessin est en cours d'exécution sur le port " + PORT);

        // Boucle infinie pour attendre les connexions des clients
        while (true) {
            // Attente de la connexion d'un client
            Socket clientSocket = serverSocket.accept();
            System.out.println("Nouvelle connexion de : " + clientSocket);

            // Création d'un objet ThreadClient pour gérer les demandes du client
            ThreadClient client = new ThreadClient(clientSocket);
            client.start();
        }
    }

    // Classe interne pour gérer les demandes des clients
    private static class ThreadClient extends Thread {
        private Socket clientSocket;

        ThreadClient(Socket socket) {
            this.clientSocket = socket;
        }

        public void run() {
            try {
                // Création d'un BufferedReader pour lire les données envoyées par le client
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                // Boucle infinie pour attendre les données envoyées par le client
                while (true) {
                    String line = in.readLine();

                    // Si les données sont vides, cela signifie que le client a fermé la connexion
                    if (line == null) {
                        System.out.println("Fermeture de la connexion de : " + clientSocket);
                        clientSocket.close();
                        break;
                    }

                    // Ajout du dessin dans la liste
                    dessins.add(line);

                    // Envoi du dessin à tous les clients connectés
                    for (String dessin : dessins) {
                        // Création d'un PrintWriter pour envoyer les données au client
                        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                        out.println(dessin);
                    }
                }
            } catch (IOException e) {
                System.out.println("Erreur : " + e.getMessage());
            }
        }
    }
}
*/

 /* 
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServeurDessin {
    private static final int PORT = 1234;
    private static List<Socket> clients = new ArrayList<Socket>();

    int nbClients = 0;

    public ServeurDessin()
    {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server started on port " + PORT);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket);
                clients.add(clientSocket);

                //new Thread(new ClientHandler(clientSocket)).start();

                clientSocket.close();
                nbClients++;
            }
           //serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        
    }

    public static void broadcast(String message) {
        for (Socket client : clients) {
            try {
                client.getOutputStream().write(message.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket clientSocket;

        public ClientHandler(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    byte[] buffer = new byte[1024];
                    int bytesRead = clientSocket.getInputStream().read(buffer);
                    if (bytesRead == -1) {
                        System.out.println("Client disconnected: " + clientSocket);
                        clients.remove(clientSocket);
                        break;
                    }
                    String message = new String(buffer, 0, bytesRead);
                    System.out.println("Received from client " + clientSocket + ": " + message);
                    broadcast(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

*/














import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import metier.Dessin;
import metier.StockDessin;

public class ServeurDessin {
	private ServerSocket serverSocket;
    public static final int PORT = 2524;
	public static ArrayList<ClientDessin> clients;
	private ArrayList<Dessin> dessins;

	public ServeurDessin() {
		dessins = new ArrayList<Dessin>(); 
		clients = new ArrayList<ClientDessin>();

		try {
			serverSocket = new ServerSocket(1234);
			System.out.println("Serveur démarré sur le port " + PORT);
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