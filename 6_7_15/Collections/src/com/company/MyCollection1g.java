package com.company;

/**
 * Created by guyazran on 7/2/15.
 */
public class MyCollection1g<T> implements GenericListable <T>{

    private Object[] arr;
    private int counter;

    public MyCollection1g(int initialCapacity){
        arr = new Object[initialCapacity];
        counter = 0;
    }

    public void add(T number){
        makeRoomIfNecessary();
        arr[counter++] = number;
    }

    private void makeRoomIfNecessary() {
        if (counter == arr.length) {
            //no room for the new number.
            Object[] newArray = new Object [arr.length * 2];
            for (int i = 0; i < counter; i++) {
                newArray[i] = arr[i];
            }
            arr = newArray;
        }
    }

    public boolean remove(T number){
        int index = this.indexOf(number);
        if (index == -1)
            return false;
        for (int i = index; i < counter - 1; i++) {
            arr[i] = arr[i+1];
        }
        counter--;
        return true;
    }

    public void add(T number, int index){
        makeRoomIfNecessary();
        if (index>=0 && index<counter) {
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

    public boolean contains(T number){
        return indexOf(number) != -1;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (obj == this)
            return true;
        if (obj instanceof MyCollection1g) {
            MyCollection1g other = (MyCollection1g)obj;
            if (this.counter == other.counter) {
                for (int i = 0; i < counter; i++) {
                    if (!arr[i].equals(other.arr[i]))
                        return false;
                }
                return true;
            }
        }
        return false;
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

    public T get(int index) {
        if (index >= 0 && index < counter)
            return (T) arr[index];
        return null;
    }

    public int indexOf(T number){
        if (counter == 0)
            return -1;
        for (int i = 0; i < counter; i++) {
            if (arr[i].equals(number)) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(T number){
        for (int i = counter - 1; i >= 0; i--) {
            if (arr[i].equals(number)) {
                return i;
            }
        }
        return -1;
    }

    //TODO: finish without loop in loop
    public void removeAll(T number){
        //while (remove(number)); //not optimal. checks the entire array for every time number exists in it
        int counter = 0;
        for (int i = 0; i < this.counter; i++){
            if (counter != 0)
                    arr[i] = arr[i + counter];
            while (arr[i] == number){
                arr[i] = arr[i + counter];
                counter++;
            }
        }
        this.counter -= counter;
        //this solution is more optimal
    }

    public void set(T number, int index){
        if (index>=0 && index<counter)
            arr[index] = number;
    }

    public Object[] toArray(){
        Object[] arr = new Object[counter];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = this.arr[i];
        }
        return arr;
    }

    public int size(){
        return counter;
    }
}
