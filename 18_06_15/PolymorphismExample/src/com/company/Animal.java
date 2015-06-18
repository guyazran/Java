package com.company;

/**
 * Created by guyazran on 6/18/15.
 */
public class Animal {
    String name;
    int color;

    public Animal(){
        name = "animal name";
        color = 0x000;
    }

    public void eat(){
        System.out.println("omnomnomnomnom");
    }

    public void sleep(){
        System.out.println("zzzzzzzzzzz");
    }
}
