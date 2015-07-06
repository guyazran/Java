package com.company;

import java.util.*;
import java.util.concurrent.ExecutionException;

public class Main {

    public static void main(String[] args) {
//        Kayak<Dog, Cat> myKayak = new Kayak<Dog, Cat>();
//        Dog d1 = new Dog();
//        Dog d2 = new Dog();
//        Cat c1 = new Cat();
//        myKayak.setFirst(d1);
//        myKayak.setSecond(c1);


//        //Interfaces
//
//        //Iterable
//        Iterable<String> iterable = null;
//        //Iterator<String> iterator = iterable.iterator();
//
//        //Collection
//        Collection<String> collection = null;
//
//        //List
//        List<String> list = null;
//
//        //Set: similar to list, but no two can be the same. this will be true only if we implement the methods in the right way
//        Set<String> set = null;
//        SortedSet<String> sortedSet = null;
//        NavigableSet<String> navigableSet = null;
//        Queue<String> queue = null;
//        Deque<String> deque = null;
//
//        //a map has two values, Key and Value. There cannot be more than one of each key
//        Map<String, Dog> map = null;
//        SortedMap<String, Dog> sortedMap;
//        NavigableMap<String, Dog> navigableMap;
//
//        //concrete classes
//        ArrayList<String> arrayList = null; //the same as MyCollection 1
//        LinkedList<String> linkedList = null; //the same as MyCollection 2
//
//        HashSet<String> hashSet = null; // implements set
//
//        TreeSet<String> treeSet = null; // a hashset with sorted members
//
//        HashMap<String, Dog> hashMap = null;
//
//        TreeMap<String, Dog> treeMap = null;
//
//        PriorityQueue<String> priorityQueue = null;
//
//
//
//        //bitwise operators
//        //these are the only true operators that the computer can interpret and execute. all other operators are based on them
//        int x = 3;
//        int y = 1;
//        int z = x | y;
//
//        //x: 0011
//        //y: 0001
//        //   ----
//        //z: 0011
//
//        System.out.println(z);
//
//        int a = 3;
//        int b = 1;
//        int c = x & y;
//
//        //x: 0011
//        //y: 0001
//        //   ----
//        //z: 0001
//
//        System.out.println(c);
//
//        int j = 3;
//        int k = 1;
//        int l = x ^ y;
//
//        //x: 0011
//        //y: 0001
//        //   ----
//        //z: 0010
//
//        System.out.println(l);

//        char[] hello = {'h', 'e', 'l', 'l', 'o'};
//        MyString myString = new MyString(hello);

        try{ //in "try" write the code that maybe can crash (method that throws Exception)
            int result =  quotient(6, 0);
            System.out.println(result*19);
        }catch (Exception ex){ //write in "catch" what you want to happen if a method from "try" throws Exception
            System.out.println(ex);
        }
        System.out.println("end"); //try and catch allows the program to reach an exception without crashing


        int[] numbers = new int[5];
        try {
            numbers[12] = 100;
        }catch(Exception ex){
            System.out.println("bassa: " + ex);
        }
        System.out.println("end...");
    }

    public static int quotient(int x, int y) throws Exception{
        if (y==0)
            throw new MyException("division by zero!!!!");
        int counter = 0;
        for(int i = y; i<=x; i+=y)
            counter++;
        return counter;
    }

    public static double paycheck(Agent agent, double percent) {
        if (agent == null)
            return 0;
        double paycheck = agent.sales * percent;
        paycheck += paycheck(agent.left, percent / 2) + paycheck(agent.Right, percent / 2);
        return paycheck;
    }
}


class Dog {
    String name;
    Dog father;
}

class Cat{

}

class Agent{
    double sales;
    Agent left;
    Agent Right;
}