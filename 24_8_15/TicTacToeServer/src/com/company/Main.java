package com.company;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Main {

    public static final int PORT = 3000;

    public static boolean go = true;



    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        ArrayList<Game> games = new ArrayList<Game>();
        games.add(new Game());
        try {
            serverSocket = new ServerSocket(PORT);
            while (go){
                System.out.println("waiting for incoming communication...");
                Socket clientSocket = serverSocket.accept();
                System.out.println("client connected...");
                ClientThread clientThread = new ClientThread(clientSocket, games);
                clientThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
