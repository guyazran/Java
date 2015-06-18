package com.company;

public class Main {

    public static void main(String[] args) {
        Dog d1 = new Dog();
        Animal d2 = new Dog();

        Cat c1 = new Cat();
        Animal c2 = new Cat();

        Poodle p1 = new Poodle();
        Animal p2 = new Poodle();

        d1.bark();
        //d2.bark();
        if (d2 instanceof Dog)
            ((Dog) d2).bark();

        c1.prr();
        //c2.prr();
        if (c2 instanceof Cat)
            ((Cat) c2).prr();

        p1.actLikeAPrincess();
        //p2.actLikeAPrincess();
        if (p2 instanceof Poodle)
            ((Poodle) p2).actLikeAPrincess();
    }
}
