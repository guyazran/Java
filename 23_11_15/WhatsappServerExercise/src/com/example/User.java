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
    private Queue<Message> messages;

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
        messages = new PriorityQueue<>();
    }

    public void addMessage(Message message){
        messages.add(message);
    }

    public JSONArray getMessages() throws JSONException {
        JSONArray jsonMessages = new JSONArray();
        Message msg;
        while((msg = messages.poll()) != null){
            JSONObject jsonMessage = new JSONObject();
            jsonMessage.put("sender", msg.getSender());
            jsonMessage.put("content", msg.getContent());
            jsonMessage.put("receiveTime", msg.getReceiveTime());
            jsonMessages.put(jsonMessage);
        }
        messages.clear(); //VERY RISKY!!!
        return jsonMessages;
    }


    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
