package com.example;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by guyazran on 11/23/15.
 */
public class User {
    private String userName, password;
    protected Queue<Message> messages;

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;

        //the PriorityQueue type must implement th Comparable interface
        messages = new PriorityQueue<>();
    }

    public void addMessage(Message message){
        if(messages.size() < 100)
            messages.add(message);
    }


    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}

