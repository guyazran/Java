package com.company;

public class Main {

    public static void main(String[] args) {
//        boolean[][] rect1;
//        boolean[][] rect2;
//        int x1 = 15;
//        int y1 = 3;
//        int height1 = 6;
//        int width1 = 50;
//        int x2 = 25;
//        int y2 = 5;
//        int height2 = 6;
//        int width2 = 50;
//        rect1 = createRectangle(x1, y1, width1, height1);
//        rect2 = createRectangle(x2, y2, width2, height2);
//        for (int i = 0; i < y1 + height1; i++) {
//            for (int j = 0; j < x1 + width1; j++) {
//                if(rect1[i][j])
//                    System.out.print("*");
//                else
//                    System.out.print(" ");
//            }
//            System.out.println();
//        }
//        for (int i = 0; i < y2 + height2; i++) {
//            for (int j = 0; j < x2 + width2; j++) {
//                if(rect2[i][j])
//                    System.out.print("*");
//                else
//                    System.out.print(" ");
//            }
//            System.out.println();
//        }
        drawX(4);
    }

    public static void drawRectangle(int x, int y, int width, int height) {
        for (int i = 0; i < y; i++) {
            System.out.println();
        }
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < x; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < width; j++) {
                System.out.print((i == 0 || i == height - 1 || j == 0 || j == width - 1) ? "*" : " ");
            }
            System.out.println();
        }
    }

    public static void printX(int size) {
        int heightCounter = size;
        int widthCounter = 0;
        while (heightCounter > 0) {
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
        while (heightCounter < size + 1) {
            for (int j = widthCounter; j > 0; j--) {
                System.out.print(" ");
            }
            System.out.print("*");
            for (int j = 0; j < heightCounter; j++) {
                System.out.print(" ");
            }
            if (heightCounter == 0 && size % 2 == 0)
                System.out.print("*");
            if (heightCounter > 0) {
                System.out.println("*");
            } else
                System.out.println(" ");
            heightCounter += 2;
            widthCounter--;
        }
    }

    public static void drawX(int size) {
        for (int i = 0; i <= size; i++) {
            if (size%2!=0 && i==size/2)
                continue;
            for (int j = 0; j <= size; j++) {
                System.out.print(i == j || j == size - i ? "*" : " ");
            }
            System.out.println();
        }
    }

    public static boolean[][] createRectangle(int x, int y, int width, int height){
        boolean[][] draw;
        draw = new boolean[y+height][x+width];
        for (int i = 0; i < y + height; i++) {
            for (int j = 0; j < x+width; j++) {
                    draw[i][j] = (i>=y && j>= x) && (i==y || i==y+height-1 || j==x || j==x+width-1);
            }
        }
        return draw;
    }

}
