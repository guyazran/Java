package com.company;

public class Main {

    public static void main(String[] args) {
	Person p = new Person();
        //p.gender = Person.FEMALE;
        p.gender = Gender.FEMALE;

        Printer printer = new Printer();
        printer.printerType = PrinterType.DOTMATRIX;

        checkPrinter(printer);
    }

    public static void checkPrinter(Printer printer){
        switch (printer.printerType){
            case DOTMATRIX:
                System.out.println("you have a dotmatrix printer");
                break;
            case INKJET:
                System.out.println("you have a inkjet printer");
                break;
            case LASER:
                System.out.println("you have a laser printer");
                break;
        }
    }
}


//class Person{
////there is no real way to specify gender with the variable types available
////we used final static int variables to stand as a representation of gender
//    public static final int MALE = 1;
//    public static final int FEMALE = 2;
//    public static final int OTHER = 3;
//
//    int gender;
//
//    @Override
//    public String toString() {
//        String genderString = "Male";
//        if (gender == FEMALE)
//            genderString = "Female";
//        if (gender == OTHER)
//            genderString = "Other";
//        return "gender is " + genderString;
//    }

//an enum is a sort of class that is a list of static variables that can be used in different classes
enum Gender {
    MALE, FEMALE, OTHER
}
class Person {
    Gender gender;
}

enum PrinterType{
    DOTMATRIX, INKJET, LASER
}
class Printer{
    PrinterType printerType;
}

