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

    public static final byte SIGN_UP = 10;
    public static final byte LOGIN = 20;
    public static final byte SEND_MESSAGE = 30;
    public static final byte CHECK_FOR_MESSAGES = 40;
    public static final byte SUCCESS = 127;
    public static final byte FAILURE = 126;

    Socket clientSocket;
    InputStream inputStream;
    OutputStream outputStream;
    MainServlet mainServlet;
    private String userName, password;

    public ClientThread(MainServlet mainServlet, Socket clientSocket){
        this.clientSocket = clientSocket;
        this.mainServlet = mainServlet;
    }


    @Override
    public void run() {
        inputStream = null;
        outputStream = null;
        try {
            inputStream = clientSocket.getInputStream();
            outputStream = clientSocket.getOutputStream();
            int action = inputStream.read();
            switch (action){
                case SIGN_UP:
                    signUp();
                    break;
                case LOGIN:
                    login();
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
        }finally {
            if(inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(outputStream != null){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(clientSocket != null){
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }


    private boolean readUserNameAndPasswordFromStream() throws IOException {
        int userNameLength = inputStream.read();
        if(userNameLength == -1)
            return false;
        byte[] userNameBytes = new byte[userNameLength];
        int actuallyRead;
        actuallyRead = inputStream.read(userNameBytes);
        if(actuallyRead != userNameLength)
            return false;
        userName = new String(userNameBytes);

        int passwordLength = inputStream.read();
        if(passwordLength == -1)
            return false;
        byte[] passwordBytes = new byte[passwordLength];
        actuallyRead = inputStream.read(passwordBytes);
        if(actuallyRead != passwordLength)
            return false;
        password = new String(passwordBytes);
        return true;
    }

    private void signUp() throws IOException {
        if(!readUserNameAndPasswordFromStream())
            return;
        boolean success = mainServlet.signUp(userName, password);
        outputStream.write(success ? SUCCESS : FAILURE);
    }

    private void login() throws IOException {
        if(!readUserNameAndPasswordFromStream())
            return;
        boolean success = mainServlet.login(userName, password);
        outputStream.write(success ? SUCCESS : FAILURE);
    }

    private void sendMessage() throws IOException {
        if(!readUserNameAndPasswordFromStream())
            return;
        String content, recipient;
        int contentLength = inputStream.read();
        if(contentLength == -1)
            return;
        byte[] contentBytes = new byte[contentLength];
        int actuallyRead = inputStream.read(contentBytes);
        if(actuallyRead != contentLength)
            return;
        content = new String(contentBytes, 0, actuallyRead);
        int recipientLength = inputStream.read();
        if(recipientLength == -1)
            return;
        byte[] recipientBytes = new byte[recipientLength];
        actuallyRead = inputStream.read(recipientBytes);
        if(actuallyRead != recipientLength)
            return;
        recipient = new String(recipientBytes, 0, actuallyRead);
        boolean success = mainServlet.sendMessage(userName, password,
                content, recipient);
        outputStream.write(success ? SUCCESS : FAILURE);


    }

    private void checkForMessages() throws IOException {
        if(!readUserNameAndPasswordFromStream())
            return;
        if(!mainServlet.login(userName, password))
            return;
        User existingUser = mainServlet.users.get(userName);
        Message msg;
        while((msg = existingUser.messages.poll()) != null) {
            byte[] contentBytes = msg.getContent().getBytes();
            byte[] senderBytes = msg.getSender().getBytes();
            outputStream.write(contentBytes.length);
            outputStream.write(contentBytes);
            outputStream.write(senderBytes.length);
            outputStream.write(senderBytes);
        }

    }
}
