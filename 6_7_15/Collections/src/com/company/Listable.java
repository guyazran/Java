package com.company;

/**
 * Created by guyazran on 7/2/15.
 */
public interface Listable {

    /**
     * adds a number to the list at the end of the list
     * @param number the number to be added
     */
    public void add(int number);

    /**
     * removes the first instance of a number from the list if it exists
     * @param number the number to be removed
     * @return returns true if there was at least one instance
     */
    public boolean remove(int number);

    /**
     * adds a number to the list in a given position
     * @param number the number to be added
     * @param index the position in the list, zero based
     */
    public void add(int number, int index);

    /**
     * reset the list, empties the list
     */
    public void clear();

    /**
     * checks if a number exists in the list
     * @param number the number being checked
     * @return true if and only if the number exists in the list
     */
    public boolean contains(int number);

    /**
     * returns the value in a given position
     * @param index zero based position
     * @return Integer.MIN_VALUE if index is illegal, otherwise the value at index
     */
    public int get(int index);

    /**
     * finds a number in the list
     * @param number the number to find
     * @return the position of the number in the list, -1 if it doesn't exist
     */
    public int indexOf(int number);

    public int lastIndexOf(int number);

    public void removeAll(int number);


    /**
     * sets the number i a given position to a new number, overriding the existing number.
     *
     * @param number the new number
     * @param index the position zero based. must be of an existing number
     */
    public void set(int number, int index);

    public int[] toArray();

    public int size();
}
