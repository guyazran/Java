package com.company;

public class Main {

    public static void main(String[] args) {

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

class Agent{
    double sales;
    Agent left;
    Agent Right;
}