package server;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import metier.Dessin;

public class ClientDessin extends Thread
{
    // Adresse IP et numéro de port du serveur
    private static final String SERVER_IP = "localhost";
    ArrayList<Dessin> dessins;
    Socket clientSocket; 

    public ClientDessin(Socket socket,ArrayList<Dessin> dessins )
    {
        this.clientSocket = socket;
        this.dessins = dessins;

        connexion();

    }

    public void connexion()
    {
        try
        {
            
            clientSocket = new Socket(InetAddress.getLocalHost(),ServeurDessin.PORT);
        
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
/* 
    private void run()
    {
        setDessins


    }
    */

    public static String getIp()
    {
        return ClientDessin.SERVER_IP;
    }

    public ArrayList<Dessin> getDessinsClient()
    {
        return dessins;
    }



}





/* 
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ClientDessin 
{

    // Adresse IP et numéro de port du serveur
    private static final String SERVER_IP = "localhost";
    private static final int PORT = 9001;

    public static void main(String[] args) throws IOException 
    {

        // Connexion au serveur
        Socket socket = new Socket(SERVER_IP, PORT);
        System.out.println("Connecté au serveur de dessin sur le port " + PORT);

        // Création d'un BufferedReader pour lire les données envoyées par le serveur
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        // Boucle infinie pour attendre les données envoyées par le serveur
        while (true) {
            String dessin = in.readLine();

            // Si les données sont vides, cela signifie que le serveur a fermé la connexion
            if (dessin == null) {
                System.out.println("Le serveur a fermé la connexion");
                break;
                }
        // Affichage du dessin reçu
        System.out.println(dessin);
        }

        // Fermeture de la connexion avec le serveur
        socket.close();
    }
}
*/

/* 
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JPanel;

import IHM.PanelDessin;
import IHM.FramePaint;
import IHM.FrameManager;
import main.Controleur;

public class ClientDessin implements Runnable 
{
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 1234;

    private Socket serverSocket;
    private Controleur ctrl;

    public ClientDessin(Socket clientSocket) {
        this.ctrl = new Controleur();
        private Socket clientSocket;
        
        this.clientSocket = clientSocket;
        

        @Override
        public void run() {
            try {
                while (true) {
                    byte[] buffer = new byte[1024];
                    int bytesRead = clientSocket.getInputStream().read(buffer);
                    if (bytesRead == -1) {
                        System.out.println("Client disconnected: " + clientSocket);
                        ServeurDessin.getClients().remove(clientSocket);
                        break;
                    }
                    String message = new String(buffer, 0, bytesRead);
                    System.out.println("Received from client " + clientSocket + ": " + message);
                    ServeurDessin.broadcast(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }


        /* 
        try {
            serverSocket = new Socket(SERVER_ADDRESS, SERVER_PORT);
            System.out.println("Connectée aux serveur " + SERVER_ADDRESS + ":" + SERVER_PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }

        FrameManager fm = new FrameManager(ctrl);
        
        
    }

    

}  

public static void main(String[] args) {
    new ClientDessin();
}
*/
