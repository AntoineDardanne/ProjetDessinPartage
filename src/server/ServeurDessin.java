package server;





import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServeurDessin {
    private static final int PORT = 1234;
    private static List<Socket> clients = new ArrayList<Socket>();

    public ServeurDessin(String ip)
    {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server started on port " + PORT);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket);
                clients.add(clientSocket);
                new Thread(new ClientHandler(clientSocket)).start();
            }
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














/*

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
*/