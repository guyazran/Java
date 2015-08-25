package com.company;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by guyazran on 8/24/15.
 */
public class ClientThread extends Thread {

    public static final int SIGN_UP = 10;
    public static final int LOG_IN = 20;
    public static final int SEND_MESSAGE = 30;
    public static final int CHECK_FOR_MESSAGES = 40;
    public static final int FAILURE = 50;
    public static final int SUCCESS = 60;
    private Socket clientSocket;
    private InputStream inputStream;
    private OutputStream outputStream;
    private HashMap<String, User> users;

    public ClientThread(Socket clientSocket, HashMap<String, User> users){
        this.clientSocket = clientSocket;
        this.users = users;
        inputStream = null;
        outputStream = null;
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
                case LOG_IN:
                    logIn();
                    break;
                case SEND_MESSAGE:
                    sendMessage();
                    break;
                case CHECK_FOR_MESSAGES:
                    checkForMessages();
                    break;
            }
        } catch (IOException e) {
            System.out.println("Houston we have a problem:");
            System.out.println(e.getMessage());
        } finally {
            if (inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (outputStream != null){
                    try {
                        outputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    void signUp() throws IOException{
        User user = getUser();
        user.initializeMessagesList();
        boolean alreadyExists = false;
        synchronized (users) {
            if (users.containsKey(user.getUserName())) {
                alreadyExists = true;
            } else {
                users.put(user.getUserName(), user);
            }
        }
        outputStream.write(alreadyExists ? FAILURE : SUCCESS);
    }

    void logIn() throws IOException{
        User user = getUser();
        outputStream.write(validUser(user) ? SUCCESS : FAILURE);
    }

    boolean validUser(User user){
        User existingUser = users.get(user.getUserName());
        return existingUser != null && existingUser.validPassword(user.getPassword());
    }

    void sendMessage() throws IOException{
        User user = getUser();
        if (!validUser(user)){
            outputStream.write(FAILURE);
            return;
        }
        int messageLength = inputStream.read();
        if (messageLength == -1)
            throw new IOException("Expected message length that wasn't received");
        byte[] messageBytes = new byte[messageLength];
        int actuallyRead = inputStream.read(messageBytes);
        if (actuallyRead != messageLength)
            throw new IOException("Message is broken");
        String message = new String(messageBytes);

        int recipientLength = inputStream.read();
        if (recipientLength == -1)
            throw new IOException("Expected recipient length that wasn't received");
        byte[] recipientBytes = new byte[recipientLength];
        actuallyRead = inputStream.read(recipientBytes);
        if (actuallyRead != recipientLength)
            throw new IOException("Recipient is broken");
        String recipientUserName = new String(recipientBytes);

        Message msg = new Message(message, user.getUserName());
        User recipient = users.get(recipientUserName);
        if (recipient != null){
            recipient.addMessage(msg);
            outputStream.write(SUCCESS);
        } else {
            outputStream.write(FAILURE);
        }
    }

    void checkForMessages() throws IOException{
        User user = getUser();
        if (!validUser(user)){
            outputStream.write(FAILURE);
            return;
        }
        user = users.get(user.getUserName());
        ArrayList<Message> messages = user.getPendingMessages();
        outputStream.write(messages.size());
        for (Message msg : messages){
            outputStream.write(msg.getContent().length());
            outputStream.write(msg.getContent().getBytes());
            outputStream.write(msg.getSender().length());
            outputStream.write(msg.getSender().getBytes());
        }
        user.donePullingMessages();
    }

    User getUser() throws IOException {
        //get username:
        int userNameLength = inputStream.read();
        if (userNameLength == -1)
            throw new IOException("Didn't receive length of userName");
        byte[] userNameBytes = new byte[userNameLength];
        int actuallyRead;
        actuallyRead = inputStream.read(userNameBytes);
        if (actuallyRead != userNameLength)
            throw new IOException("userNameLength is not equal to actually read");
        String userName = new String(userNameBytes);

        //get password:
        int passwordLength = inputStream.read();
        if (passwordLength == -1)
            throw new IOException("Didn't receive length of password");
        byte[] passwordBytes = new byte[passwordLength];
        actuallyRead = inputStream.read(passwordBytes);
        if (actuallyRead != passwordLength)
            throw new IOException("passwordLength is not equal to actually read");
        String password = new String(passwordBytes);

        User user = new User(userName, password);
        return user;
    }
}
