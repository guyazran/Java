package com.example.guyazran;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Created by guyazran on 9/17/15.
 */
public class ServerThread extends Thread{

    public static final int PORT = 3000;
    private boolean go;

    ArrayList<String> users;

    ServerSocket serverSocket;

    @Override
    public void run() {
        go = true;
        try {
            users = new ArrayList<String>();
            serverSocket = new ServerSocket(PORT);
            while (go){
                Socket clientSocket = serverSocket.accept();
                ClientThread clientThread = new ClientThread(clientSocket, users);
                clientThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stopListening(){
        go = false;
        if (serverSocket != null) {
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public int getUserCount(){
        return users.size();
    }

    static class ClientThread extends Thread{

        public static final int SIGN_UP = 1;
        public static final int LOGIN = 2;
        public static final int LOGOUT = 3;

        Socket clientSocket;
        InputStream inputStream;
        OutputStream outputStream;

        ArrayList<String> users;

        public ClientThread(Socket clientSocket, ArrayList<String> users){
            this.clientSocket = clientSocket;
            this.users = users;
        }

        @Override
        public void run() {
            try {
                inputStream = clientSocket.getInputStream();
                outputStream = clientSocket.getOutputStream();
                int action = inputStream.read();
                switch (action){
                    case SIGN_UP:
                        signUp();
                        break;
                    case LOGIN:
                        logIn();
                        break;
                    case LOGOUT:
                        logOut();
                        break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (outputStream != null){
                    try {
                        outputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (clientSocket != null){
                    try {
                        clientSocket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        void signUp() throws IOException {
            int usernameLength = inputStream.read();
            if (usernameLength == -1)
                return;
            byte[] usernameBytes = new byte[usernameLength];
            int actuallyRead = inputStream.read(usernameBytes);
            if (actuallyRead == -1)
                return;
            String username = new String(usernameBytes, 0, actuallyRead);
            users.add(username);
            String response = "welcome " + username;
            byte[] responseBytes = response.getBytes();
            outputStream.write(responseBytes.length);
            outputStream.write(responseBytes);
        }

        void logIn() throws IOException{
            int usernameLength = inputStream.read();
            if (usernameLength == -1)
                return;
            byte[] usernameBytes = new byte[usernameLength];
            int actuallyRead = inputStream.read(usernameBytes);
            if (actuallyRead == -1)
                return;
            String username = new String(usernameBytes, 0, actuallyRead);
            String response;
            if (users.contains(username)){
                response = "Login Successful";
            }else {
                response = "Login Failed";
            }
            byte[] responseBytes = response.getBytes();
            outputStream.write(responseBytes.length);
            outputStream.write(responseBytes);
        }

        void logOut() throws IOException{
            int usernameLength = inputStream.read();
            if (usernameLength == -1)
                return;
            byte[] usernameBytes = new byte[usernameLength];
            int actuallyRead = inputStream.read(usernameBytes);
            if (actuallyRead == -1)
                return;
            String username = new String(usernameBytes, 0, actuallyRead);
            String response = "Logout Successful";
            byte[] responseBytes = response.getBytes();
            outputStream.write(responseBytes.length);
            outputStream.write(responseBytes);
        }
    }
}
