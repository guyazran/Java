package com.company;

import java.util.Stack;

/**
 * Created by guyazran on 7/9/15.
 */
public class LoginThread extends Thread{

    private String username, password;
    private LoginListener listener;
    public LoginThread(String username, String password, LoginListener listener){
        this.username = username;
        this.password = password;
        this.listener = listener;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        if (username.equals("guy") && password.equals("12345")) {
            listener.onLogin(true);
        } else {
            listener.onLogin(false);
        }
    }

    public static interface LoginListener{
        void onLogin(boolean success);
    }
}
