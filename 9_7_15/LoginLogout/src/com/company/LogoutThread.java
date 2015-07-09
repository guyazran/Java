package com.company;

/**
 * Created by guyazran on 7/9/15.
 */
public class LogoutThread extends Thread{

    private String username, password;
    private LogoutListener listener;
    public LogoutThread(String username, String password, LogoutListener listener){
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
        listener.onLogout();
    }

    public static interface LogoutListener{
        void onLogout();
    }
}
