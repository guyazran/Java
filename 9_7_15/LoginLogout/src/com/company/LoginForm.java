package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by guyazran on 7/9/15.
 */
public class LoginForm extends JFrame implements LoginThread.LoginListener, LogoutThread.LogoutListener{

    public static final String STR_LOGIN = "Login";
    public static final String STR_LOGOUT = "Logout";
    public static final String STR_PLEASE_WAIT = "please wait...";
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JTextField txtUsername;
    private JTextField txtPassword;
    private JButton btnLogin;
    private boolean isLoggedIn;

//    private static final String USERNAME = "guy";
//    private static final String PASSWORD = "123";

    public LoginForm() {
        setTitle("LoginForm");
        setSize(400, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        usernameLabel = new JLabel("username: ");
        passwordLabel = new JLabel("password: ");
        txtUsername = new JTextField(20);
        txtPassword = new JTextField(20);
        btnLogin = new JButton(STR_LOGIN);
        add(usernameLabel);
        add(txtUsername);
        add(passwordLabel);
        add(txtPassword);
        add(btnLogin);

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String username = txtUsername.getText();
                String password = txtPassword.getText();
                btnLogin.setEnabled(false);
                btnLogin.setText(STR_PLEASE_WAIT);
                if (!isLoggedIn) {
                    txtUsername.setEnabled(false);
                    txtPassword.setEnabled(false);

                    LoginThread loginThread = new LoginThread(username, password, LoginForm.this);
                    loginThread.start();

                } else {
                    LogoutThread logoutThread = new LogoutThread(username, password, LoginForm.this);
                    logoutThread.start();
                }
            }
        });
    }

    @Override
    public void onLogin(boolean success) {
        btnLogin.setEnabled(true);
        if (success) {
            btnLogin.setText(STR_LOGOUT);
            isLoggedIn = true;
        } else {
            btnLogin.setText(STR_LOGIN);
            txtUsername.setEnabled(true);
            txtPassword.setEnabled(true);
        }
    }

    @Override
    public void onLogout() {
        btnLogin.setEnabled(true);
        txtUsername.setEnabled(true);
        txtPassword.setEnabled(true);
        btnLogin.setText(STR_LOGIN);
        isLoggedIn = false;
    }
}
