package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by guyazran on 7/9/15.
 */
public class Calculator extends JFrame{

    private JLabel instructions;
    private JTextField number1;
    private JTextField number2;
    private JButton add;
    private JButton subtract;
    private JButton multiply;
    private JButton divide;
    private JLabel result;

    public Calculator(){
        setTitle("Calculator");
        setSize(400, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        instructions = new JLabel();
        instructions.setText("input 2 numbers and choose an operation");
        add(instructions);
        number1 = new JTextField(5);
        number2 = new JTextField(5);
        add(number1);
        add(number2);
        add = new JButton("+");
        subtract = new JButton("-");
        multiply = new JButton("X");
        divide = new JButton("/");
        add(add);
        add(subtract);
        add(multiply);
        add(divide);
        result = new JLabel("");
        add(result);

        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton chosenOperation = (JButton)e.getSource();
                Object operationID = chosenOperation.getClientProperty("operationID");
                if (operationID != null && operationID instanceof Integer){
                    Integer id = (Integer)operationID;
                    int num1 = Integer.valueOf(number1.getText());
                    int num2 = Integer.valueOf(number2.getText());
                    if (id == 1)
                        result.setText("the result is " + (num1+num2));
                    if (id == 2)
                        result.setText("the result is " + (num1-num2));
                    if (id == 3)
                        result.setText("the result is " + (num1*num2));
                    if (id == 4)
                        result.setText("the result is " + (num1/num2));
                }
            }
        };

        add.putClientProperty("operationID", 1);
        add.addActionListener(actionListener);
        subtract.putClientProperty("operationID", 2);
        subtract.addActionListener(actionListener);
        multiply.putClientProperty("operationID", 3);
        multiply.addActionListener(actionListener);
        divide.putClientProperty("operationID", 4);
        divide.addActionListener(actionListener);
    }

}
