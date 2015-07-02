package com.company;

public class Main {

    public static void main(String[] args) {
//        Drawable d = new Point();
//        Drawable d2 = new Segment();
//
//        Drawable[] drawables = new Drawable[2];
//        drawables[0] = new Point();
//        drawables[1] = new Segment();
//        boolean[][] canvas = new boolean[10][10];
//        for (Drawable drawable : drawables){
//            drawable.draw(canvas);
//    }

        Dog d1 = new Dog();
        d1.name = "a";
        Dog d2 = new Dog();
        d2.name = "b";
        d1.father = d2;
        Dog d3 = new Dog();
        d3.name = "c";
        d2.father = d3;

        System.out.println(d1.father.father.name);

    }
    public static double paycheck(Agent agent, double percent){
        if (agent == null)
            return 0;
        double paycheck = agent.sales*percent;
        paycheck += paycheck(agent.left,percent/2) + paycheck(agent.Right, percent/2);
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