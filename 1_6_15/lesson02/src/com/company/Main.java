package com.company;

public class Main {

    public static void main(String[] args) {
        printX(7);
    }

    public static int sumOfDigits(int x){
        int result = 0;
        while(x>0) {
            result+=x%10;
            x/=10;
        }
        return result;
    }

    public static int largestDigit(int x){
        int result = 0;
        while(x>0) {
            int lastDigit =x%10;
            if(lastDigit>result){
                result = lastDigit;
            }
            x/=10;
        }
        return result;
    }

    public static int reverseDigits(int x){
        int result = 0;
        while(x>0){
            int lastDigit = x%10;
            result*=10;
            result+=lastDigit;
            x /= 10;
        }
        return result;
    }

    public static int power(int x, int y){
        if(x==0){
            if(y==0)
                return -1;
            return 0;
        }
        if(y == 0 || x == 1)
            return 1;
        int result = x;
        for (int i = 1; i < y; i++) {
            result = result * x;
        }
        return result;
    }

    public static void drawRectangle(int x, int y, int width, int height){
        for (int i = 0; i < y; i++) {
            System.out.println();
        }
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < x; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < width; j++) {
                System.out.print((i==0 || i==height-1 || j==0 || j==width-1) ? "*" : " ");
            }
            System.out.println();
        }
    }

    public static void printX(int size) {
        int heightCounter = size;
        int widthCounter = 0;
        while (heightCounter>0) {
            for (int j = 0; j < widthCounter; j++) {
                System.out.print(" ");
            }
            System.out.print("*");
            for (int j = 0; j < heightCounter; j++) {
                System.out.print(" ");
            }
            heightCounter -= 2;
            widthCounter++;
            System.out.println("*");
        }
        while (heightCounter<size+1){
            for (int j = widthCounter; j > 0; j--) {
                System.out.print(" ");
            }
            System.out.print("*");
            for (int j = 0; j < heightCounter; j++) {
                System.out.print(" ");
            }
            if (heightCounter == 0 && size%2==0)
                System.out.print("*");
            if (heightCounter > 0) {
                System.out.println("*");
            }
            else
                System.out.println(" ");
            heightCounter += 2;
            widthCounter--;
        }
    }

}


