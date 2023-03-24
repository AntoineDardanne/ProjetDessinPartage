package server;

import java.net.Socket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import IHM.PanelDessin;

import metier.Dessin;


public class ClientDessin extends Thread
{
    private ObjectOutputStream out;
    private ObjectInputStream in;
    private Socket socket;
    private ArrayList<Dessin> dessins;

    public ClientDessin(Socket socket, ArrayList<Dessin> dessins) throws IOException {
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
        
       

        try {
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());
            out.writeObject(dessins);
            out.flush();
            
            while (true) {
                Dessin dessin = (Dessin) in.readObject();
                dessins.add(dessin);
                PanelDessin.dessinsDuDessins.add(dessin);
                for (ClientDessin client : ServeurDessin.clients) {
                    if (client != this) {
                        client.out.writeObject(PanelDessin.dessinsDuDessins);
                        client.out.flush();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /*
    String id;
	Socket socKonnexion; 
	BufferedReader reader;
	
	public ClientDessin(String id) {
		this.id = id;
		connexion();
	}

	
	public void connexion() {
		try {
			socKonnexion = new Socket(InetAddress.getLocalHost(),ServeurDessin.PORT);
			reader = new BufferedReader(new InputStreamReader(socKonnexion.getInputStream()));
			//StockDessin recupeStockDessin;
            //ArrayList<Dessin> recupDessins = recupeStockDessin.getDessins();

			//System.out.println(id+": reÃ§u depuis serveur : "+messageDepuisServeur);
			Thread.sleep(2000);
			socKonnexion.close();
		} catch(UnknownHostException uhe) { 
		} catch(IOException ioe) {
		} catch (InterruptedException e) {}
		
	}

    public static void main(String[] args) {
		if(args.length > 0)	
			new ClientDessin(args[0]);
		else 
			new ClientDessin("toto");
	}
*/


}
