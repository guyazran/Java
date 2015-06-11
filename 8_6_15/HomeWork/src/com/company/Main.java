package com.company;

public class Main {

    public static void main(String[] args) {
        int[] numbers = {4, 19, 39, 19, 50, 500, 32, 14};
        int[] subArray = {50, 500, 32};
        System.out.println(indexOf(numbers, subArray));;

        boolean[][] canvas = new boolean[50][100];
        drawStarOfDavid(canvas, 5, 2, 6);
        render(canvas);
    }

    public static int indexOf(int[] numbers, int[] subArray){
        for (int i = 0; i < numbers.length - subArray.length + 1; i++) {
            for (int j = 0; j < subArray.length; j++) {
                if (numbers[i + j] == subArray[j])
                    if(j == subArray.length - 1)
                        return i;
                    else
                        continue;
                else
                    break;
            }
        }
        return -1;
    }

    public static void createRectangle(boolean[][] canvas, int x, int y, int width, int height){
        for (int i = 0; i < y + height; i++) {
            for (int j = 0; j < x+width; j++) {
                if ((i>=y && j>= x) && (i==y || i==y+height-1 || j==x || j==x+width-1))
                    canvas[i][j] = true;
            }
        }
    }

    public static void drawTriangle(boolean[][] canvas, int x, int y, int height){
        int width = height * 2 - 1;
        int counter = 0;
        for (int i = 0; i < y + height; i++) {
            for (int j = 0; j < x + width + 1; j++) {
                boolean lastRound = i == y + height - 1;
                if (!lastRound){
                    if ((i>=y && j>=x) && (j == height + x - counter || j == height + x + counter))
                        canvas[i][j] = true;
                } else {
                    if (j >= x + 1)
                        canvas[i][j] = true;
                }
            }
            if (i>=y)
                counter++;
        }
    }

    public static void drawReverseTriangle(boolean[][] canvas, int x, int y, int height){
        int width = height * 2 - 1;
        int counter = height - 1;
        for (int i = 0; i < y + height ; i++) {
            for (int j = 0; j < x + width + 1; j++) {
                boolean firstRound = i == y;
                if (!firstRound){
                    if ((i>=y && j>=x) && (j == height + x - counter || j == height + x + counter))
                        canvas[i][j] = true;
                } else {
                    if (j >= x + 1)
                        canvas[i][j] = true;
                }
            }
            if (i>=y)
                counter--;
        }
    }

    public static void drawStarOfDavid(boolean[][] canvas, int x, int y, int height){
        drawTriangle(canvas, x, y, height);
        drawReverseTriangle(canvas, x, y + 1, height);
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
