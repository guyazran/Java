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
        Link last = anchor;
        while(last.next != null)
            last = last.next;
        last.next = new Link(number);
    }

    @Override
    public boolean remove(int number) {
        return false;
    }

    @Override
    public void add(int number, int index) {

    }

    @Override
    public void clear() {

    }

    @Override
    public boolean contains(int number) {
        return false;
    }

    @Override
    public int get(int index) {
        return 0;
    }

    @Override
    public int indexOf(int number) {
        return 0;
    }

    @Override
    public int lastIndexOf(int number) {
        return 0;
    }

    @Override
    public void removeAll(int number) {

    }

    @Override
    public void set(int number, int index) {

    }

    @Override
    public int[] toArray() {
        return new int[0];
    }

    @Override
    public int size() {
        return 0;
    }

    static class Link{
        int value;
        Link next;

        public Link(int value){
            this.value = value;
        }
    }
}

