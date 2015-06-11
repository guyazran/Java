package com.company;

public class Main {

    public static void main(String[] args) {
//        //the Ram has two areas: stack and heap
//        //primitive variables: stored int the RAM's stack. Memory requirement is fixed
        int i = 100; //4 bytes -2b to + 2b (256^4=4B)
        byte b = 127; //1 byte - 128 to 127
        boolean bool = true; //1bit
        short s = 100; //2 bytes 256^2=65536
        float myFloat = 28.6f; //4 bytes
        double myDouble = 28.6; //8 bytes
        long myLong = 123456789423156l; //like int but 8 bytes
        char c = 'h'; //1 byte

//        String myString = "hello";
//
//        int[] x = new int[50];
//        for (int j = 0; j < 50; j++) {
//            x[j]=0;
//        }
//    }
        int[] x = new int[5];
        x[0] = 1;
        x[1] = 2;
        x[2] = 300;
        x[3] = 6;
        x[4] = 20;
//        System.out.println(max(x));
//        System.out.println(sum(x));
//        System.out.println(howManyInRange(x, 6, 300));
        int[] y = subArray(x, 6, 300);
//        printArray(y);
        int[] z = reverseArray(x);
//        printArray(z);

        int a = 1;
//        stam(1);
//        System.out.println("the value of a is: " + a );

        int[] myArray = {1};
//        stam2(myArray);
//        System.out.println(myArray[0]);

        int[] arr = {1, 2, 8, 4, 5, 6, 7, 0};
        sort(arr);
        printArray(arr);

        int[][] myArray2 = new int[3][5];

        for (int j = 0; j < myArray2.length; j++) {
            for (int k = 0; k < myArray2[j].length; k++) {
                System.out.print(myArray2[j][k]+",");
            }
            System.out.println();
        }

        boolean[][] canvas = new boolean[10][12];
        canvas[2][5] = true;
        canvas[4][6] = true;
        canvas[1][3] = true;
        for (int j = 0; j < canvas.length; j++) {
            for (int k = 0; k < canvas[j].length; k++) {
                System.out.print(canvas[j][k] ? "*" : " ");
            }
            System.out.println();
        }
    }

    public static void stam(int x){
        x++;
        System.out.println("the value of x is: " + x);
    }

    public static void stam2(int[] numbers){
        numbers[0]++;
        System.out.println(numbers[0]);
    }

    public static int max(int[] numbers){
        int max = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if(numbers[i] > max)
                max = numbers[i];
        }
        return max;
    }

    public static int sum(int[] numbers){
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        return sum;
    }

    public static int howManyInRange(int[] numbers, int min, int max){
        int counter = 0;
        for (int i = 0; i < numbers.length; i++) {
            if(numbers[i] >= min && numbers[i] < max)
                counter++;
        }
        return counter;
    }

    public static int[] subArray(int[] numbers, int min, int max){
        int counter = 0;
        int[] inRange = new int[howManyInRange(numbers, min, max)];
        for (int i = 0; i < numbers.length; i++) {
            if(numbers[i] >= min && numbers[i] < max)
                inRange[counter++] = numbers[i];
        }
        return inRange;
    }

    public static void printArray(int[] numbers){
            System.out.print("[");
        if (numbers.length > 0) {
            for (int i = 0; i < numbers.length - 1; i++) {
                System.out.print(numbers[i] + ",");
            }
        }
        System.out.println(numbers[numbers.length - 1] + "]");
    }

    public static int[] reverseArray(int[] numbers){
        int[] reverse = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            reverse[i] = numbers[numbers.length - 1 - i];
        }
        return reverse;
    }

    public static void reverseArray2(int[] numbers){
        for (int i = 0; i < numbers.length/2; i++) {
            int temp = numbers[i];
            numbers[i] = numbers[numbers.length - 1 - i];
            numbers[numbers.length - 1 - i] = temp;
        }
    }



    public static void sort(int[] numbers) {

    }
}