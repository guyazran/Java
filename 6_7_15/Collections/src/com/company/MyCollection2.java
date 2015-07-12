package com.company;

/**
 * Created by guyazran on 7/2/15.
 */
public class MyCollection2 implements Listable {

    private Link anchor; //placeholder for the first link. ignore member;
    private Link last;
    private int counter;

    public MyCollection2(){
        anchor = new Link(0);
        last = anchor;
        counter = 0;
    }

    @Override
    public void add(int number) {
        last.next = new Link(number);
        last = last.next;
        counter++;
    }

    @Override
    public boolean remove(int number) {
        Link theOneBefore = anchor;
        while (theOneBefore.next != null){
            if (theOneBefore.next.value == number){
                theOneBefore.next = theOneBefore.next.next;
                counter--;
                return true;
            }
            theOneBefore = theOneBefore.next;
        }
        return false;
    }

    @Override
    public void add(int number, int index) {
        if (index>=0 && index<=counter) {
            Link theOneBefore = anchor;
            for (int i = 0; i < index; i++) {
                theOneBefore = theOneBefore.next;
            }
            Link newLink = new Link(number);
            newLink.next = theOneBefore.next;
            theOneBefore.next = newLink;
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
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        Link current = anchor;
            while (current.next != null) {
                current = current.next;
                sb.append(current.value);
                if (current.next != null)
                    sb.append(",");
            }
        sb.append("}");
        return sb.toString();
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
        Link placeHolder = anchor;
        while (placeHolder.next != null){
            if (placeHolder.next.value == number)
                if (placeHolder.next.next != null) {
                    placeHolder.next = placeHolder.next.next;
                }else{
                    placeHolder.next = null;
                }
        }
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

