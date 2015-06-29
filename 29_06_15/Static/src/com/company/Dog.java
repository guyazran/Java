package com.company;

/**
 * Created by guyazran on 6/29/15.
 */
public class Dog {
    static int counter = 0;
    public Dog(){
        counter++;
    }
}

class Cat{ // a class within a class. only one can be public. the rest can only be used in the same package.
    static boolean catCreated = false;

    public Cat() {

    }
}