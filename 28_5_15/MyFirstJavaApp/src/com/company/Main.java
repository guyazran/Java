package com.company;

public class Main {

    public static void main(String[] args) {
//        //System.out.println("hello world"); abreviation "sout"
//        //int x;
//        //x=5;
//        int x = 5;
//        x = 7;
//        x++;
//        ++x;
//        x += 8;
//        x -= 3;
//        x = 3 + x * 2;
//        x = 3;
//        int y = ++x;
//        String s = "3";
//        //System.out.println(s + x + 1);
//        //boolean f = 5<6 || x==1;
//        //System.out.println(f);
//        boolean f1 = 5 < 6, f2 = false;
//        boolean f3 = !f1 || !f2;
//        if (x < 10) {
//            System.out.println("x is less than 100");
//        } else if (x < 20) {
//            System.out.println("x is greater than 20");
//        }
//
//        for (int i = 0; i < 8; i++) {
//            if (i % 3 == 0) {
//                //break;
//                continue;
//            }
//            System.out.println(i);
//        }
//
//        int i = 0;
//        while (i < 8) {
//            i++;
//        }
//
//        do {
//            x++;
//        } while (x < 8);

//        stam();
//        int result = sum(5, 2);
//        System.out.println(result);
//        System.out.println(product(0,21));

//        System.out.println(distance(29,30));
        System.out.println(quotient(8, 2));
    }
//    public static void stam(){
//        System.out.println("in stam()...");
//    }
//
//    public static int sum(int x, int y) {
//        return x + y;
//    }
//    public static int product(int x, int y){
//        int small = x;
//        int large = y;
//        if(x>y){
//            small = y;
//            large = x;
//        }
//        int result = 0;
//        for (int i = 0; i < y; i++) {
//            result += x;
//        }
//        return result;
//    }
//    public static int distance(int x, int y){
//        int small = x;
//        int large = y;
//        if(x>y){
//            small = y;
//            large = x;
//        }
//        int result = 0;
//        while(small+result<larg)
//            result++;
//        return result;
//    }
    public static int quotient(int x, int y) {
        int result = 0;
        if(y==0)
            return -1;
        for(int i = y; i <= x; i+=y){
            result++;
        }
        return result;
    }
}
