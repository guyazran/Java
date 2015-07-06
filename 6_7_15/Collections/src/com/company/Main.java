package com.company;

public class Main {

    public static void main(String[] args) {
        Kayak<Dog, Cat> myKayak = new Kayak<Dog, Cat>();
        Dog d1 = new Dog();
        Dog d2 = new Dog();
        Cat c1 = new Cat();
        myKayak.setFirst(d1);
        myKayak.setSecond(c1);
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