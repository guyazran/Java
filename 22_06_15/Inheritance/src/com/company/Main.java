package com.company;

public class Main {

    public static void main(String[] args) {
        // Number n = new Integer(8); // Integer extends Number. Number cannot directly be a Number type object

        Number[] nums = new Number[5];
        nums[0] = new Byte((byte)10); // casting is used to enter a byte to Byte's consturctor
        nums[1] = new Integer(10);
        nums[2] = new Float(10.0f);
        nums[3] = new Double(10.0);
        nums[4] = new Fraction(1, 2);
        System.out.println(sum(nums));

    }

    public static double sum(Number[] nums){
        double sum = 0;
        /*
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i].doubleValue();
        }
        */
        //"for each" loop
        for (Number n : nums){
            sum += n.doubleValue();
        }
        return sum;
    }
}
