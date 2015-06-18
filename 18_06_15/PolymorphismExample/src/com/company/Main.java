package com.company;

public class Main {

    public static void main(String[] args) {
//        Dog d1 = new Dog();
//        Animal d2 = new Dog();
//
//        Cat c1 = new Cat();
//        Animal c2 = new Cat();
//
//        Poodle p1 = new Poodle();
//        Animal p2 = new Poodle();
//
//        d1.bark();
//        //d2.bark();
//        if (d2 instanceof Dog)
//            ((Dog) d2).bark();
//
//        c1.prr();
//        //c2.prr();
//        if (c2 instanceof Cat)
//            ((Cat) c2).prr();
//
//        p1.actLikeAPrincess();
//        //p2.actLikeAPrincess();
//        if (p2 instanceof Poodle)
//            ((Poodle) p2).actLikeAPrincess();

        Dog d3 = new Dog();
        goToSleep(d3);


        Animal[] animals = new Animal[4];

        animals[0] = new Animal();
        animals[0].yearOfBirth = 20013;

        animals[1] = new Cat();
        animals[1].yearOfBirth = 2006;

        animals[2] = new Poodle();
        animals[2].yearOfBirth = 2014;

        animals[3] = new Dog();
        animals[3].yearOfBirth = 2014;

        Animal old = findOldestAnimal(animals);
        if (old instanceof Dog){
            if (old instanceof Poodle){
                System.out.println("Poodle");
            }else {
                System.out.println("Dog");
            }
        }
        else if (old instanceof Cat)
            System.out.println("Cat");
        else
            System.out.println("Animal");
    }

    public static void goToSleep(Animal a){
        a.sleep();
    }

    public static Animal findOldestAnimal(Animal[] animals){
        Animal oldest = animals[0];
        for (int i = 1; i < animals.length; i++) {
            if (oldest.getAge()<animals[i].getAge())
                oldest = animals[i];
        }
        return oldest;
    }
}
