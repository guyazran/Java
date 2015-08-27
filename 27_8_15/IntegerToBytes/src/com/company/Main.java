package com.company;

public class Main {

    public static void main(String[] args) {
//        int x = 9537;
//        byte[] bytes = new byte[Integer.SIZE/8];
//        ByteBuffer.wrap(bytes).putInt(x);
//        for (int i = 0; i < bytes.length; i++) {
//            System.out.println(bytes[i]);
//        }
//
//        int y = ByteBuffer.wrap(bytes).getInt();
//        System.out.println(y);

        Circle circle1 = new Circle(14.5f, 12, 3, "my circle");
        System.out.println(circle1);

        Circle circle2 = new Circle(circle1.getBytes());
        System.out.println(circle2);
    }
}
