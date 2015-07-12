package com.company;

import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
        HashSet<stam> stamHashSet = new HashSet<stam>();

        stamHashSet.add(new stam(3, 4));
        stamHashSet.add(new stam(2, 7));
        stamHashSet.add(new stam(13, 19));
        stamHashSet.add(new stam(-19, 32));
        stamHashSet.add(new stam(10, -11115));
        stamHashSet.add(new stam(555, -99809));
        stamHashSet.add(new stam(12324, 4));
        stamHashSet.add(new stam(898, -4));

        System.out.println(stamHashSet);
    }
}

class stam{
    int num1;
    int num2;

    public stam(int num1, int num2){
        this.num1 = num1;
        this.num2 = num2;
    }

    @Override
    public int hashCode() {
        return (num1 * 13) ^ (num2 * 51) * (num1 * 101);
    }

    @Override
    public String toString() {
        return num1 + "&" + num2;
    }
}
