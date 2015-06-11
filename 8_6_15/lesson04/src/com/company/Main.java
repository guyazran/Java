package com.company;

public class Main {

    public static void main(String[] args) {
//        int[] numbers = {3, 2, 5, 1};
//        sortArray(numbers);
//        printArray(numbers);

//        boolean[][] canvas = new boolean[50][100];
//        drawRectangle(canvas, 10, 5, 20, 10);
//        printCanvas(canvas);

//        int[] myArr = {4, 19, 39, 19};
//        System.out.println(indexOf(myArr, 500));

    }

    public static void drawRectangle(boolean[][] canvas, int x, int y, int width, int height){
        for (int i = 0; i < width; i++) {
            canvas[y][x + i] = true; // top side
            canvas[y + height - 1][x + i] = true; // bottom side
        }
        for (int i = 0; i < height; i++) {
            canvas[y + i][x] = true; // left side
            canvas[y + i][x + width - 1] = true; // right side
        }
    }

    public static void printCanvas(boolean[][] canvas){
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[i].length; j++) {
                System.out.print(canvas[i][j] ? "* " : "  ");

            }
            System.out.println();
        }
    }

    public static void sortArray(int[] numbers){
        int counter = numbers.length - 1;
        boolean isSorted = false;
        while (!isSorted){
            isSorted = true;
            for (int i = 0; i < counter; i++) {
                if (numbers[i] > numbers [i + 1]){
                    int temp = numbers [i];
                    numbers[i] = numbers[i + 1];
                    numbers[i + 1] = temp;
                    isSorted = false;
                }
            }
            counter--;
        }
    }

    public static void printArray(int[] numbers){
        System.out.print("[");
        if(numbers.length>0){
            for (int i = 0; i < numbers.length - 1; i++) {
                System.out.print(numbers[i] + ",");
            }
            System.out.print(numbers[numbers.length-1]);
        }
        System.out.println("]");
    }

    public static int indexOf(int[] numbers, int number){
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == number)
                return i;
        }
        return -1;
    }

}
