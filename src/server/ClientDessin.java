package server;

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

public class ClientDessin {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 1234;

    private Socket serverSocket;
    private Controleur ctrl;

    public ClientDessin() {
        this.ctrl = new Controleur();
        try {
            serverSocket = new Socket(SERVER_ADDRESS, SERVER_PORT);
            System.out.println("Connected to server " + SERVER_ADDRESS + ":" + SERVER_PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }

        FrameManager fm = new FrameManager(ctrl);
        
    }

    public static void main(String[] args) {
        new ClientDessin();
    }

}   