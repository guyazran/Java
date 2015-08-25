package com.company;

import java.util.ArrayList;

/**
 * Created by guyazran on 8/24/15.
 */
public class User {

    private String userName;
    private String password;
    private ArrayList<Message> pendingMessages;
    private boolean isPullingMessages;
    private ArrayList<Message> pendingMessagesTemp;

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
        isPullingMessages = false;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Message> getPendingMessages() {
        isPullingMessages = true;
        if (pendingMessagesTemp.size()>0){
            pendingMessages.addAll(pendingMessagesTemp);
            pendingMessagesTemp.clear();
        }
        return pendingMessages;
    }

    public void donePullingMessages(){
        pendingMessages.clear();
        isPullingMessages = false;
    }

    public void initializeMessagesList(){
        pendingMessages = new ArrayList<Message>();
        pendingMessagesTemp = new ArrayList<Message>();
    }

    public void addMessage(Message message){
        if (!isPullingMessages) {
            pendingMessages.add(message);
        }else {
            pendingMessagesTemp.add(message);
        }
    }

    @Override
    public String toString() {
        return userName + " " + password;
    }

    boolean validPassword(String password){
        return this.password.equals(password);
    }
}
