package com.example;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.servlet.ServletException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by guyazran on 11/23/15.
 */
public class MainServlet extends javax.servlet.http.HttpServlet {

    private HashMap<String, User> users;
    private HashSet<String> blacklist;

    private TCPListenerThread tcpListenerThread;

    @Override
    public void init() throws ServletException {
        super.init();
        tcpListenerThread  = new TCPListenerThread();
        tcpListenerThread.start();

        users = new HashMap<>();
        blacklist = new HashSet<String>();
    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        if (blacklist.contains(request.getRemoteUser()))
            return;

        InputStream inputStream = request.getInputStream();
        int actuallyRead;
        byte[] buffer = new byte[1024];
        StringBuilder stringBuilder = new StringBuilder();
        while((actuallyRead = inputStream.read(buffer)) != -1){
            String s = new String(buffer, 0, actuallyRead);
            stringBuilder.append(s);
        }
        inputStream.close();
        try {
            JSONObject jsonObject = new JSONObject(stringBuilder.toString());
            String action = jsonObject.getString("action");
            JSONObject jsonResponse = new JSONObject();
            String userName, password;
            boolean success = false;
            userName = jsonObject.getString("userName");
            password = jsonObject.getString("password");
            switch (action) {
                case "signup":
                    success = signUp(userName, password);
                    break;
                case "login":
                    userName = jsonObject.getString("userName");
                    password = jsonObject.getString("password");
                    success = login(userName, password);
                    break;
                case "sendmessage":
                    userName = jsonObject.getString("userName");
                    password = jsonObject.getString("password");

                    String recipient = jsonObject.getString("recipient");
                    String content = jsonObject.getString("content");
                    success = sendMessage(userName, password, content, recipient);

                    break;
                case "checkformessages":
                    userName = jsonObject.getString("userName");
                    password = jsonObject.getString("password");
                    JSONArray messagesToClient = checkMessages(userName, password);
                    if(messagesToClient != null) {
                        jsonResponse.put("messages", messagesToClient);
                        success = true;
                    }
                    break;
            }
            jsonResponse.put("success", success);
            response.getWriter().write(jsonResponse.toString());
        } catch (JSONException e) {
            response.getWriter().write("error: " + e.getMessage());
        }

        //String responseToClient = "echo " + stringBuilder.toString();

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    boolean signUp(String userName, String password){
        boolean success = true;
        User user = new User(userName, password);
        synchronized (users) {
            if (users.containsKey(userName)) {
                success = false;
            }
            if (success) {
                users.put(userName, user);
            }
        }
        return success;
    }

    boolean login(String userName, String password){
        User existingUser = users.get(userName);
        if(existingUser == null){
            return false;
        }else{
            return existingUser.getPassword().equals(password);
        }

    }

    boolean sendMessage(String sender, String password, String content, String recipient){
        if(!login(sender, password))
            return false;
        User recipientUser = users.get(recipient);
        if(recipientUser == null)
            return false;
        recipientUser.addMessage(new Message(content, sender, recipient));
        return true;
    }

    JSONArray checkMessages(String userName, String password) throws JSONException {
        if(!login(userName, password))
            return null;
        User existingUser = users.get(userName);
        return existingUser.getMessages();
    }

    @Override
    public void destroy() {
        super.destroy();
        tcpListenerThread.stopListening();
        tcpListenerThread = null;
    }
}
