package com.company;

/**
 * Created by guyazran on 6/18/15.
 */
public class Animal {
    String name;
    int color;
    int yearOfBirth;

    public Animal(){
        name = "animal name";
        color = 0x000;
        yearOfBirth = 2000;
    }

    public void eat(){
        System.out.println("omnomnomnomnom");
    }

    public void sleep(){
        System.out.println("zzzzzzzzzzz");
    }

    public int getAge(){
        return 2015 - yearOfBirth;
    }
}
