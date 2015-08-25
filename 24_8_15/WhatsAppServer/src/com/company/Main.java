package com.company;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class Main {

    public static final int PORT = 3000;
    static boolean go = true;

    public static void main(String[] args) {

        HashMap<String, User> users = new HashMap<String, User>();
        User guy = new User("guy", "123");
        guy.initializeMessagesList();
        users.put("guy", guy);

        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);
            while (go){
                System.out.println("waiting for incoming communication...");
                Socket clientSocket = serverSocket.accept();
                System.out.println("client connected...");
                ClientThread clientThread = new ClientThread(clientSocket, users);
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
