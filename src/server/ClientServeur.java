package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import metier.Dessin;

/**
 * Classe qui gère la connexion d'un client
 *
 * @author Antoine Dardanne, Noemie Claccin
 * @version 1.0
 */
public class ClientServeur extends Thread{
	private ObjectOutputStream out;
	private ObjectInputStream in;
	private Socket socket;
	private ArrayList<Dessin> dessins;
	private String pseudo;

	/**
	 * Constructeur de la classe ClientServeur
	 *
	 * @param socket
	 *            Le socket du client
	 * @param dessins
	 *            La liste des dessins
	 * @throws IOException
	 */
	public ClientServeur(Socket socket, ArrayList<Dessin> dessins) throws IOException {
		this.socket = socket;
		this.dessins = dessins;
	}

	public void run() {}
}
