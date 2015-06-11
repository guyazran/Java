package com.company;

public class Main {

    public static void main(String[] args) {
	    int x;
        x = 8;
        int y = x;
        long l = 19l;

        Dog d;
        d = new Dog();

        Dog d2 = new Dog();
        d = new Dog();

        Person guy = new Person();
        guy.firstName = "Guy";
        guy.lastName ="Azran";

        Person john = new Person();
        john.firstName = "John";
        john.lastName = "Doe";

        System.out.println("first name: " + john.firstName + ", last name: " + john.lastName);
        System.out.println(john);

        Date johnsBirthday = new Date();
        johnsBirthday.year = 1993;
        johnsBirthday.month = 4;
        johnsBirthday.day = 10;
        john.dateOfBirth = johnsBirthday;

        Person alice = new Person();
        alice.dateOfBirth = new Date();
        alice.dateOfBirth.year = 1995;
        alice.dateOfBirth.month = 6;
        alice.dateOfBirth.day = 10;
        alice.dateOfBirth.hour = 3;
    }
}

/*
what does the word 'new' in java do?
-------------------
1. find a free space in the heap.
2. mark the free space as taken.
3. create and initialize an object in that space.
4. return the location/address in memory of the object created.
 */