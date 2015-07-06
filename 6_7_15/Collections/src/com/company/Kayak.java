package com.company;

/**
 * Created by guyazran on 7/6/15.
 */
public class Kayak <T, M>{
    private T first;
    private M second;

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public M getSecond() {
        return second;
    }

    public void setSecond(M second) {
        this.second = second;
    }
}
