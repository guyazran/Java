package com.company;

/**
 * Created by guyazran on 7/2/15.
 */
public class MyCollection2 implements Listable {

    private Link anchor;
    private int counter;

    public MyCollection2(){
        anchor = new Link(0);
        counter = 0;
    }

    @Override
    public void add(int number) {
        if (counter == 0){
            anchor.value=number;
        }else {
            Link last = anchor;
            while (last.next != null)
                last = last.next;
            last.next = new Link(number);
        }
        counter++;
    }

    @Override
    public boolean remove(int number) {
        int index = indexOf(number);
        if (index==-1)
            return false;
        Link placeHolder = anchor;
        for (int i = 0; i < counter; i++) {
            if (i >= index && placeHolder.next!=null)
                placeHolder.value = placeHolder.next.value;
            placeHolder = placeHolder.next;
        }
        counter--;
        return true;
    }

    @Override
    public void add(int number, int index) {
        if (index>=0 && index<counter) {
            int numHolder = 0;
            Link placeHolder = anchor;
            for (int i = 0; i < counter; i++) {
                if (i>=index) {
                    numHolder = placeHolder.value;
                    placeHolder.value = number;
                    number = numHolder;
                }
                if (placeHolder.next == null)
                    placeHolder.next = new Link(number);
                placeHolder = placeHolder.next;
            }
            counter++;
        }
    }

    @Override
    public void clear() {
        counter = 0;
    }

    @Override
    public boolean contains(int number) {
        if (indexOf(number) == -1)
            return false;
        return true;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (obj == this)
            return true;
        if (obj instanceof MyCollection2) {
            MyCollection2 other = (MyCollection2)obj;
            if (this.counter == other.counter) {
                for (int i = 0; i < counter; i++) {
                    if (this.get(i) != other.get(i))
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
        Link placeHolder = anchor;
        for (int i = 0; i < counter-1; i++) {
            s += placeHolder.value + ",";
            placeHolder = placeHolder.next;
        }
        if (counter != 0)
            s += placeHolder.value;
        s += "}";
        return s;
    }

    @Override
    public int get(int index) {
        if (index>=0 && index<counter){
            Link placeHolder = anchor;
            for (int i = 0; i < index; i++) {
                placeHolder = placeHolder.next;
            }
            return placeHolder.value;
        }
        return Integer.MIN_VALUE;
    }

    @Override
    public int indexOf(int number) {
        MyCollection2 placeHolder = this;
        for (int i = 0; i < counter; i++) {
            if (get(i) == number)
                return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(int number) {
        MyCollection2 placeHolder = this;
        for (int i = counter; i > -1; i--) {
            if (get(i) == number)
                return i;
        }
        return -1;
    }

    @Override
    public void removeAll(int number) {
        while (contains(number))
            remove(number);
    }

    @Override
    public void set(int number, int index) {
        Link placeHolder = anchor;
        if (index>=0 && index<counter){
            for (int i = 0; i < index; i++) {
                placeHolder = placeHolder.next;
            }
            placeHolder.value = number;
        }
    }

    @Override
    public int[] toArray() {
        int[] arr = new int[counter];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = this.get(i);
        }
        return arr;
    }

    @Override
    public int size() {
        return counter;
    }

    static class Link{
        int value;
        Link next;

        public Link(int value){
            this.value = value;
        }
    }
}

