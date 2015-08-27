package com.company;

import java.nio.ByteBuffer;
import java.util.ArrayList;

/**
 * Created by guyazran on 8/27/15.
 */
public class Circle {

    private float radius;
    private int xPos, yPos;
    private String name;

    public Circle(float radius, int xPos, int yPos, String name) {
        this.radius = radius;
        this.xPos = xPos;
        this.yPos = yPos;
        this.name = name;
    }

    public Circle(byte[] bytes){

        int position = 0;
        this.radius = ByteBuffer.wrap(bytes, position, 4).getFloat();
        position += 4;
        this.xPos = ByteBuffer.wrap(bytes, position, 4).getInt();
        position += 4;
        this.yPos = ByteBuffer.wrap(bytes, position, 4).getInt();
        position += 4;
        int nameLength = bytes[position++];
        this.name = new String(bytes, position, nameLength);

//        byte[] radiusBytes = new byte[Float.SIZE/8];
//        byte[] xPosBytes = new byte[Integer.SIZE/8];
//        byte[] yPosBytes = new byte[Integer.SIZE/8];
//        byte[] nameBytes = new byte[bytes.length - 12];
//
//        int position = 0;
//        for (int i = 0; i < 4; i++)
//            radiusBytes[i] = bytes[position + i];
//
//        position += 4;
//        for (int i = 0; i < 4; i++)
//            xPosBytes[i] = bytes[position + i];
//
//        position += 4;
//        for (int i = 0; i < 4; i++)
//            yPosBytes[i] = bytes[position + i];
//
//        position += 4;
//        for (int i = 0; i < nameBytes.length; i++)
//            nameBytes[i] = bytes[position + i];
//
//        this.radius = ByteBuffer.wrap(radiusBytes).getFloat();
//        this.xPos = ByteBuffer.wrap(xPosBytes).getInt();
//        this.yPos = ByteBuffer.wrap(yPosBytes).getInt();
//        this.name = new String(nameBytes);
    }

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public int getxPos() {
        return xPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getBytes(){
        byte[] nameBytes = name.getBytes();
        byte[] bytes = new byte[4 * 3 + nameBytes.length + 1];
        int position = 0;
        ByteBuffer.wrap(bytes, position, 4).putFloat(radius);
        position += 4;
        ByteBuffer.wrap(bytes, position, 4).putInt(xPos);
        position += 4;
        ByteBuffer.wrap(bytes, position, 4).putInt(yPos);
        position += 4;
        bytes[position++] = (byte)nameBytes.length;
        ByteBuffer.wrap(bytes, position, nameBytes.length).put(nameBytes);

//        byte[] radiusBytes = new byte[Float.SIZE / 8];
//        ByteBuffer.wrap(radiusBytes).putFloat(radius);
//        byte[] xPosBytes = new byte[Integer.SIZE/8];
//        ByteBuffer.wrap(xPosBytes).putInt(xPos);
//        byte[] yPosBytes = new byte[Integer.SIZE/8];
//        ByteBuffer.wrap(yPosBytes).putInt(yPos);
//
//        for (int i = 0; i < 4; i++)
//            bytes[i + position] = radiusBytes[i];
//
//        position += 4;
//        for (int i = 0; i < 4; i++)
//            bytes[i + position] = xPosBytes[i];
//
//        position += 4;
//        for (int i = 0; i < 4; i++)
//            bytes[i + position] = yPosBytes[i];
//
//        position += 4;
//        for (int i = 0; i < nameBytes.length; i++)
//            bytes[i + position] = nameBytes[i];

        return bytes;
    }

    @Override
    public String toString() {
        return "radius = " + radius + " xPos = " + xPos + " yPos = " + yPos + " name = " + name;
    }
}
