package com.company;

/**
 * Created by guyazran on 7/6/15.
 */
public interface GenericListable <T>{
    //TODO: change variable names
    //TODO: rewrite MyCollection 2 to implement this interface
    /**
     * adds a number to the list at the end of the list
     * @param number the number to be added
     */
    public void add(T number);

    /**
     * removes the first instance of a number from the list if it exists
     * @param number the number to be removed
     * @return returns true if there was at least one instance
     */
    public boolean remove(T number);

    /**
     * adds a number to the list in a given position
     * @param number the number to be added
     * @param index the position in the list, zero based
     */
    public void add(T number, int index);

    /**
     * reset the list, empties the list
     */
    public void clear();

    /**
     * checks if a number exists in the list
     * @param number the number being checked
     * @return true if and only if the number exists in the list
     */
    public boolean contains(T number);

    /**
     * returns the value in a given position
     * @param index zero based position
     * @return Integer.MIN_VALUE if index is illegal, otherwise the value at index
     */
    public T get(int index);

    /**
     * finds a number in the list
     * @param number the number to find
     * @return the position of the number in the list, -1 if it doesn't exist
     */
    public int indexOf(T number);

    public int lastIndexOf(T number);

    public void removeAll(T number);


    /**
     * sets the number i a given position to a new number, overriding the existing number.
     *
     * @param number the new number
     * @param index the position zero based. must be of an existing number
     */
    public void set(T number, int index);

    public Object[] toArray();

    public int size();
}
