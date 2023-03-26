package server;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.NetworkInterface;
import java.net.SocketAddress;
import java.util.ArrayList;

import metier.Dessin;

class Recepteur extends Thread {
	InetAddress groupeIP;
	int port;
	String nom;
	MulticastSocket socketReception;

	Recepteur(InetAddress groupeIP, int port, String nom) throws Exception {
		this.groupeIP = groupeIP;
		this.port = port;
		this.nom = nom;
		socketReception = new MulticastSocket(port);
		NetworkInterface netIf = NetworkInterface.getByInetAddress(InetAddress.getLocalHost());
		socketReception.joinGroup(new InetSocketAddress(groupeIP, port), netIf);
		start();
	}

	public void run() {
		try {
			while (true) {
				byte[] buffer = new byte[1000];
				DatagramPacket paquet = new DatagramPacket(buffer, buffer.length);
				socketReception.receive(paquet);
				ByteArrayInputStream bais = new ByteArrayInputStream(buffer);
				DataInputStream dis = new DataInputStream(bais);
				String nom = dis.readUTF();
				if (!nom.equals(this.nom)) {
					int type = dis.readInt();
					int x1 = dis.readInt();
					int y1 = dis.readInt();
					int x2 = dis.readInt();
					int y2 = dis.readInt();
					int r = dis.readInt();
					int g = dis.readInt();
					int b = dis.readInt();
					boolean plein = dis.readBoolean();
					String texte = dis.readUTF();
					Dessin dessin = new Dessin(type, x1, y1, x2, y2, new Color(r, g, b), plein, texte);
					System.out.println("Reçu de " + nom + " : " + dessin);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class Emetteur extends Thread {
	InetAddress groupeIP;
	int port;
	MulticastSocket socketEmission;
	String nom;
	ArrayList<Dessin> dessins;

	Emetteur(InetAddress groupeIP, int port, String nom, ArrayList<Dessin> dessins) throws Exception {
		this.groupeIP = groupeIP;
		this.port = port;
		this.nom = nom;
		this.dessins = dessins;
		socketEmission = new MulticastSocket();
		socketEmission.setTimeToLive(15); // pour un site
		start();
	}

public void run() {
	try {
		while (true) {
			/*sleep(1000);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(dessins);
			oos.flush();
			byte[] data = baos.toByteArray();
			DatagramPacket message = new DatagramPacket(data, data.length, groupeIP, port);*/

			// Envoie le nom + l'arraylist de dessins
			sleep (1000);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			DataOutputStream dos = new DataOutputStream(baos);
			dos.writeUTF(nom);
			for (Dessin dessin : dessins) {
				dos.writeInt(dessin.getType());
				dos.writeInt(dessin.getX());
				dos.writeInt(dessin.getY());
				dos.writeInt(dessin.getLargeur());
				dos.writeInt(dessin.getHauteur());
				dos.writeInt(dessin.getCouleur().getRed());
				dos.writeInt(dessin.getCouleur().getGreen());
				dos.writeInt(dessin.getCouleur().getBlue());
				dos.writeBoolean(dessin.estPleine());
				dos.writeUTF(dessin.getTexte());
			}
			dos.flush();
			byte[] data = baos.toByteArray();
			DatagramPacket message = new DatagramPacket(data, data.length, groupeIP, port);
			socketEmission.send(message);
			System.out.println("Envoi de " + nom + " : ");
			for (Dessin dessin : dessins) {
				System.out.println(dessin);
			}
		}
	}
	catch (Exception exc) {
		System.out.println(exc);
	}
}
}

public class Multicast {

	ArrayList<Dessin> dessinsClient;

	public Multicast(String ip, int port, String nom, ArrayList<Dessin> dessinClient ) throws Exception {
		this.dessinsClient = dessinClient;
		InetAddress groupeIP = InetAddress.getByName(ip);
		new Recepteur(groupeIP, port, nom);
		new Emetteur(groupeIP, port, nom, dessinClient);
	}

	public static void main(String[] arg) throws Exception {
		//ArrayList<Dessin> en dur pour tester
		ArrayList<Dessin> dessins = new ArrayList<Dessin>();
		dessins.add(new Dessin(Dessin.RECTANGLE, 10, 10, 10, 10, Color.BLACK, false, ""));
		dessins.add(new Dessin(Dessin.OVALE, 50, 50, 10, 10, Color.RED, true, ""));
		dessins.add(new Dessin(Dessin.LIGNE, 100, 100, 10, 10, Color.BLUE, false, ""));
		dessins.add(new Dessin(Dessin.TEXTE, 150, 150, 10, 10, Color.GREEN, false, "Bonjour"));
		new Multicast("239.255.100.45", 1234, "Client 1", dessins);
	}

	//
	public void envoyerMessage(String string) {
		
	}

	public void recevoirMessage() {
	}
}