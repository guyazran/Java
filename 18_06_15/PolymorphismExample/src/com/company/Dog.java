package com.company;

/**
 * Created by guyazran on 6/18/15.
 */
public class Dog extends Animal{
    boolean isGoodDog;

    public Dog(){
        isGoodDog = true;
    }

    public void bark(){
        System.out.println("woof woof");
    }

    @Override
    public void sleep() {
        System.out.println("Dream of running in a field");
    }

    @Override
    public int getAge() {
        return super.getAge()*7;
    }
}
