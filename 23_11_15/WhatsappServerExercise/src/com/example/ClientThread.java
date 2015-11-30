package com.example;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.ByteBuffer;

/**
 * Created by guyazran on 11/26/15.
 */
public class ClientThread extends Thread {

    public static final int FAILURE = 254;
    public static final int SUCCESS = 255;


    public static final int SIGN_UP = 10;
    public static final int LOG_IN = 20;
    public static final int SEND_MESSAGE = 30;
    public static final int CHECK_FOR_MESSAGES = 40;

    MainServlet mainServlet;

    Socket clientSocket;
    InputStream inputStream;
    OutputStream outputStream;

    public ClientThread(MainServlet mainServlet, Socket clientSocket){
        this.mainServlet = mainServlet;
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        inputStream = null;
        outputStream = null;
        try {
            inputStream = clientSocket.getInputStream();
            outputStream = clientSocket.getOutputStream();
            int action = inputStream.read();
            switch(action){
                case SIGN_UP:
                    signUp();
                    break;
                case LOG_IN:
                    logIn();
                    break;
                case SEND_MESSAGE:
                    sendMessage();
                    break;
                case CHECK_FOR_MESSAGES:
                    checkForMessages();
                    break;
                case -1:
                    //end of stream
                    break;
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null){
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

    private void signUp() throws IOException {
        String username, password;

        //get username
        int usernameLength = inputStream.read();
        if (usernameLength == -1)
            return;
        byte[] usernameBytes = new byte[usernameLength];
        int actuallyRead = inputStream.read(usernameBytes);
        if (actuallyRead != usernameLength)
            return;
        username = new String(usernameBytes);

        //get password
        int passwordLength = inputStream.read();
        if (passwordLength == -1)
            return;
        byte[] passwordBytes = new byte[passwordLength];
        actuallyRead = inputStream.read(passwordBytes);
        if (actuallyRead != passwordLength)
            return;
        password = new String(passwordBytes);

        boolean success = mainServlet.signUp(username, password);

        outputStream.write(success ? SUCCESS : FAILURE);
    }

    private void logIn(){

    }

    private void sendMessage(){

    }

    private void checkForMessages(){

    }
}
