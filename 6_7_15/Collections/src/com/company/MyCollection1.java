package com.company;

/**
 * Created by guyazran on 7/2/15.
 */
public class MyCollection1 implements Listable{

    private int[] arr;
    private int counter;

    public MyCollection1(int initialCapacity){
        arr = new int[initialCapacity];
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
        int index = this.indexOf(number);
        if (index == -1)
            return false;
        for (int i = index; i < counter - 1; i++) {
            arr[i] = arr[i+1];
        }
        counter--;
        return true;
    }

    public void add(int number, int index){
        makeRoomIfNecessary();
        if (index>=0 && index<=counter) {
            for (int i = counter; i > index; i--) {
                arr[i] = arr[i - 1];
            }
            arr[index] = number;
            counter++;
        }
    }

    public void clear(){
        counter = 0;
    }

    public boolean contains(int number){
        return indexOf(number) != -1;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (obj == this)
            return true;
        if (obj instanceof MyCollection1) {
            MyCollection1 other = (MyCollection1)obj;
            if (this.counter == other.counter) {
                for (int i = 0; i < counter; i++) {
                    if (arr[i] != other.arr[i])
                        return false;
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 0; i < counter-1; i++) {
            sb.append(arr[i] + ",");
        }
        if (counter!= 0)
            sb.append(arr[counter -1]);
        sb.append("}");
        return sb.toString();
    }

    public int get(int index){
        if (index>=0 && index<counter)
            return arr[index];
        return Integer.MIN_VALUE;
    }

    public int indexOf(int number){
        if (counter == 0)
            return -1;
        for (int i = 0; i < counter; i++) {
            if (arr[i] == number) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(int number){
        for (int i = counter - 1; i >= 0; i--) {
            if (arr[i] == number) {
                return i;
            }
        }
        return -1;
    }

    public void removeAll(int number){
        //while (remove(number)); //not optimal. checks the entire array for every time number exists in it
        int counter = 0;
        for (int i = 0;  i+counter < this.counter; i++){
            if (counter != 0)
                    arr[i] = arr[i + counter];
            if (arr[i + counter] == number) {
                counter++;
                i--;
            }
        }
        this.counter -= counter;
        //this solution is more optimal
    }

    public void set(int number, int index){
        if (index>=0 && index<counter)
            arr[index] = number;
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
