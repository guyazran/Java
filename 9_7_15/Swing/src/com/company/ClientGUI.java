package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by guyazran on 7/9/15.
 */
public class ClientGUI extends JFrame{

    private JLabel label;
    private JTextField textField;
    private JButton button1;
    private JButton button2;

    public ClientGUI(){
        setTitle("Client GUI");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        label = new JLabel();
        label.setText("Hello World!");
        add(label);
        textField = new JTextField(20);
        add(textField);
        button1 = new JButton("click me!");
        add(button1);
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton buttonThatWasJustClicked = (JButton)e.getSource();
                Object valueOfId = buttonThatWasJustClicked.getClientProperty("id");
                String s = "";
                if (valueOfId != null && valueOfId instanceof Integer){
                    Integer id = (Integer)valueOfId;
                    s = id.toString();
                }
                //label.setText("button1 was clicked");
                String input = textField.getText();
                System.out.println("button" + s + " was clicked..." + input);
            }
        };
        button1.putClientProperty("id", 1);
        button1.addActionListener(actionListener);
        button2 = new JButton("click me too");
        add(button2);
        button2.addActionListener(actionListener);
        button2.putClientProperty("id", 2);

        JButton myButton = new JButton("click this");
        myButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
