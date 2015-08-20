package com.company;

public class Main {

    public static void main(String[] args) {
        //int result = sum(5,6, 19);

//        int[] numbers = new int[3];
//        numbers[0] = 19;
//        numbers[1] = 80;
//        numbers[2] = -90;
//        int result = sum(numbers);

        int result = sum(19, 80, -90);

        System.out.println("result: " + result);
    }

//    public static int sum(int x, int y){
//        return x + y;
//    }
//
//    public static int sum(int x, int y, int z){
//        return sum(sum(x, y), z);
//    }
//
//    public static int sum(int x, int y, int z, int m){
//        return sum(sum(sum(x, y), z), m);
//    }



//    public static int sum(int[] numbers){
//        int sum = 0;
//        for (int num : numbers){
//            sum += num;
//        }
//        return sum;
//    }

    public static int sum(int... numbers){
        int sum = 0;
        for (int num : numbers){
            sum += num;
        }
        return sum;
    }
}
