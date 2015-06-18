package com.company;

/**
 * Created by guyazran on 6/18/15.
 */
public class Cat extends Animal {
    boolean isGoodCat;

    public Cat(){
        isGoodCat = false;
    }

    public void prr(){
        System.out.println("prrrrr");
    }

    @Override
    public void sleep() {
        System.out.println("Cats do not sleep");
    }
}
