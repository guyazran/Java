package com.example;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by guyazran on 11/26/15.
 */
public class TCPListenerThread extends Thread {

    private boolean go = true;
    ServerSocket socket;

    MainServlet mainServlet;

    public TCPListenerThread(MainServlet mainServlet){
        this.mainServlet = mainServlet;
    }

    @Override
    public void run() {
        socket = null;
        try {
            socket = new ServerSocket(3000);
            while (go){
                System.out.println("waiting for client");
                Socket clientSocket = socket.accept();
               // clientSocket.setSoTimeout(15000); //will timeout after 15 seconds of being stuck on a read()/write() method
                ClientThread clientThread = new ClientThread(mainServlet, clientSocket);
                clientThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void stopListening(){
        go = false;
        interrupt();
    }
}
