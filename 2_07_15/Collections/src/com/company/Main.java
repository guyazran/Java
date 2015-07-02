package com.company;

public class Main {

    public static void main(String[] args) {
        Drawable d = new Point();
        Drawable d2 = new Segment();

        Drawable[] drawables = new Drawable[2];
        drawables[0] = new Point();
        drawables[1] = new Segment();
        boolean[][] canvas = new boolean[10][10];
        for (Drawable drawable : drawables){
            drawable.draw(canvas);
        }
    }
}
