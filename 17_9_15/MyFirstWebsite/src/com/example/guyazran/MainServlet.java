package com.example.guyazran;

import javax.servlet.ServletException;
import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by guyazran on 9/17/15.
 */
public class MainServlet extends javax.servlet.http.HttpServlet {

    int x = 0;

    ServerThread serverThread;

    @Override
    //this method will be called in the creation of the servlet object. this occurs upon the first request to the server
    public void init() throws ServletException {
        serverThread = new ServerThread();
        serverThread.start();
    }

    @Override
    public void destroy() {
        serverThread.stopListening();
    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        if (request.getParameterMap().containsKey("admin")){
            if (request.getParameter("admin").equals("log")){
                try {
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("usercount", serverThread.getUserCount());
                    response.getWriter().write(jsonObject.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }else {
            response.getWriter().write("<h1>welcome to my servlet " + x++ + "</h1>");
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        System.out.println("in doGet " + request.getQueryString());
//        String queryString = request.getQueryString();
//        if (queryString != null) {
//            String[] keyValues = queryString.split("&");
//            for (String keyValue : keyValues) {
//                String[] keyAndValue = keyValue.split("=");
//                if (keyAndValue.length == 2) {
//
//                    if (keyAndValue[0].equals("admin") && keyAndValue[1].equals("log")) {
//                        response.getWriter().write("user count: " + serverThread.getUserCount());
//                    }
//                }
//            }
        //this is the easiest way to parse the query string
        if (request.getParameterMap().containsKey("admin")){
            if (request.getParameter("admin").equals("log")){
                try {
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("usercount", serverThread.getUserCount());
                    response.getWriter().write(jsonObject.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }else {
            response.getWriter().write("<h1>welcome to my servlet " + x++ + "</h1>");
        }
    }
}
