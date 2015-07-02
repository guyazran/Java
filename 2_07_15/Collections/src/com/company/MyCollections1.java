package com.company;

/**
 * Created by guyazran on 7/2/15.
 */
public class MyCollections1 implements Listable{

    private int[] arr;
    private int counter;

    public MyCollections1(){
        arr = new int[10];
        counter = 0;
    }

    public void add(int number){
        makeRoomIfNecessary();
        arr[counter++] = number;
    }

    private void makeRoomIfNecessary() {
        if (counter == arr.length) {
            //no room for the new number.
            int[] newArray = new int[arr.length * 2];
            for (int i = 0; i < counter; i++) {
                newArray[i] = arr[i];
            }
            arr = newArray;
        }
    }

    public boolean remove(int number){
        return true;
    }

    public void add(int number, int index){
        makeRoomIfNecessary();
        for (int i = counter - 1; i < index - 1; i++) {

        }
    }

    public void clear(){
        counter = 0;
    }

    public boolean contains(int number){
        if (indexOf(number) == -1)
            return false;
        return true;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        String s = "{";
        for (int i = 0; i < counter - 1; i++) {
            s += arr[i] + ",";
        }
        if (counter != 0)
            s += arr[counter - 1];
        s += "}";
        return s;
    }

    public int get(int index){
        return Integer.MIN_VALUE;
    }

    public int indexOf(int number){
        if (counter == 0)
            return -1;
        int index = 0;
        while(arr[index]!=number){
            index++;
            if (index>=counter)
                return -1;
        }
        return index;
    }

    public int lastIndexOf(int number){
        return -1;
    }

    public void removeAll(int number){

    }

    public void set(int number, int index){

    }

    public int[] toArray(){
        int[] arr = new int[counter];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = this.arr[i];
        }
        return arr;
    }

    public int size(){
        return counter;
    }
}
