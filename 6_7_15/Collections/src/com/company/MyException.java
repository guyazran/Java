package com.company;

/**
 * Created by guyazran on 7/6/15.
 */
public class MyException extends Exception {

    long timeOfException;

    public MyException(String message){
        super(message);
        timeOfException = System.currentTimeMillis();
    }

    @Override
    public String toString() {
        return super.toString() + timeOfException;
    }
}
