package com.company;

public class Main {

    public static void main(String[] args) {

        System.out.println(power2(2,30));
    }

    public static int sum(int x, int y) {
        return x + y;
    }

    // returns the product of x and y, for example: product(7,5) is 35
    public static int product(int x, int y){
        int small = x;
        int large = y;
        if(x>y){
            small = y;
            large = x;
        }
        int result = 0;
        for (int i = 0; i < y; i++) {
            result += x;
        }
        return result;
    }

    // returns the distance between x and y, for example: distance(7,5) is 2
    public static int distance(int x, int y){
        int small = x;
        int large = y;
        if(x>y){
            small = y;
            large = x;
        }
        int result = 0;
        while(small+result<large)
            result++;
        return result;
    }

    public static int quotient(int x, int y) {
        int result = 0;
        if(y==0)
            return -1;
        for(int i = y; i <= x; i+=y){
            result++;
        }
        return result;
    }

    public static int remainder(int x, int y){
        //return distance(x, product(quotient(x, y), y)); // simple solution containing functions at the cost of performance
        int result = 0;
        if(y==0)
            return -1;
        if(y>x) // (optimization) not needed, but it is shorter than checking the "distance" between 0 and x
            return x;
        for(int i = y; i <= x; i+=y){
            result = i;
        }
        result = distance(result,x);
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
            result = product(result,x);
        }
        return result;
    }

    public static int power2(int x, int y){
        if(x==0){
            if(y==0)
                return -1;
            return 0;
        }
        if(y==0 || x == 1)
            return 1;
        return product(x, power2(x, distance(y, 1)));
    }

}
