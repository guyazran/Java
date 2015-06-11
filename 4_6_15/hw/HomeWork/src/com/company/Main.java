package com.company;

public class Main {

    public static void main(String[] args) {
//        int[] myArray = {15, 6, 7, 9, 4, 13, 9, 8, 800, 2};
//        sort(myArray);
//        printArray(myArray);

        boolean[][] canvas = new boolean[15][150];
        boolean[][] rect1 = createRectangle(15, 3, 50, 6);
        boolean[][] rect2 = createRectangle(25, 5, 50, 6);
        boolean[][] tri = createTriangle(16, 9, 5);
        addToCanvas(canvas, rect1);
        addToCanvas(canvas, rect2);
        addToCanvas(canvas, tri);
        render(canvas);
    }


    public static void sort(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            int indexOfMin = numbers.length - 1;
            for (int j = i; j < numbers.length; j++) {
                if (numbers[j] < numbers[indexOfMin])
                    indexOfMin = j;
            }
            int temp = numbers[i];
            numbers[i] = numbers[indexOfMin];
            numbers[indexOfMin] = temp;
        }
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

    public static boolean[][] createTriangle(int x, int y, int height){
        int width = height * 2 - 1;
        int counter = 0;
        boolean[][] draw;
        draw = new boolean[y+height][x + width + 1];
        for (int i = 0; i < y + height; i++) {
            for (int j = 0; j < x + width + 1; j++) {
                boolean lastRound = i == y + height - 1;
                if (!lastRound)
                    draw[i][j] = (i>=y && j>=x) && (j == height + x - counter || j == height + x + counter);
                else
                    draw[i][j] = j>=x + 1;
            }
            if (i>=y)
                counter++;
        }
        return draw;
    }

    public static void addToCanvas(boolean[][] canvas, boolean[][] img){
        for (int i = 0; i < img.length; i++) {
            for (int j = 0; j < img[i].length; j++) {
                if (img[i][j])
                    canvas[i][j] = true;
            }
        }
    }

    public static void render(boolean[][] canvas){
        for (int j = 0; j < canvas.length; j++) {
            for (int k = 0; k < canvas[j].length; k++) {
                System.out.print(canvas[j][k] ? "*" : " ");
            }
            System.out.println();
        }
    }
}
