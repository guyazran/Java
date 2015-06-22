package com.company;

public class Main {

    public static void main(String[] args) {
        /*
        //example 1
        byte b = 9;
        aMethod(b); //will activate short because byte is closer related to short than int (if byte does not exist)
        aMethod(9); //will activate "int" because any number without a variable is considered as int
        Integer i = 9; //Integer is a special object with properties similar to String
        aMethod(i); //will activate "object" because i is a pointer for an integer type object
        */

        /*
        //example 2
        //aMethod(9);
        // a compilation error when byte and short are active because both of them can be used to hold the value "9"
        // if we remove one of the methods, there will be a compilation error because short and byte are smaller than int and therefor there will be a loss of data
        // this is called "implicit" data loss, because it the compiler is not certain that this has been done on purpose

        aMethod((short)9); // "explicit" data loss. i have shown the compiler that i am sure that i want to refer to 9 as a short. this is called "primitive casting"

        byte b = (byte)128; // here we use casting to use a number out of range for the variable byte. the variable overflows and will start from the negative end (-128)
        System.out.println(b);
        */

        /*
        //example 3
        //aMethod(9, 10); // the compiler does not know which value to refer to as long
        aMethod(9l, 10); //i have chosen the long value for the compiler
        */
    }

    //public static void aMethod(int val){System.out.println("int");}
    //public static void aMethod(short val){System.out.println("short");}
    //public static void aMethod(byte val){System.out.println("byte");}
    //public static void aMethod(Object val){System.out.println("Object");}
    //public static void aMethod(String val){System.out.println("String");}


    //metods for example 3
    public static void aMethod(long val1, int val2){System.out.println("long, int");}
    public static void aMethod(int val1, long val2){System.out.println("int, long");}
}
