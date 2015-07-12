package com.company;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by guyazran on 7/6/15.
 */
public class MyString {
    private char[] chars;

    public MyString(char[] chars){
        this.chars = chars;
    }

    //returns the beginning of the beginning of the given string
    public int indexOf(MyString another){
        return indexOf(another, 0);
    }

    //chars = "hello world today", parameter: ' ', return: {"hello", "world", "today"}
    public MyString[] split(char delimiter) {
        char[] delimiterInArray = {delimiter};
        return split(new MyString(delimiterInArray));
    }

    public MyString[] split(MyString delimiter) {
//        LinkedList<MyString> splitString = new LinkedList<MyString>();
//        LinkedList<Character> section = new LinkedList<Character>();
//        for (int i = 0; i < chars.length; i++) {
//            if (indexOf(delimiter, i, delimiter.chars.length) != -1){
//                if (section.size() == 0) {
//                    i += delimiter.chars.length - 1;
//                }else{
//                    i += delimiter.chars.length - 1;
//                    Object[] charsInList = section.toArray();
//                    char[] toBeAdded = new char[section.size()];
//                    for (int j = 0; j < toBeAdded.length; j++) {
//                        toBeAdded[i] = (char)charsInList[i];
//                    }
//                    splitString.add(new MyString(toBeAdded));
//                    section.clear();
//                }
//            }else{
//                section.add(chars[i]);
//            }
//        }
//        Object[] stringsInList = splitString.toArray();
//        MyString[] resultArray = new MyString[splitString.size()];
//        return resultArray;
//        MyString[] splitString = new MyString[1];
//        MyString[] arr;
//        splitString[0] = this;
//        int index = splitString[splitString.length - 1].indexOf(delimiter);
//        if (index != -1){
//            char[] beforeSection = new char[index+1];
//            for (int i = 0; i < beforeSection.length; i++) {
//                beforeSection[i] = splitString[splitString.length - 1].chars[i];
//            }
//            char[] afterSection = new char[splitString[splitString.length - 1].chars.length - index];
//            for (int i = 0; i < afterSection.length; i++) {
//                afterSection[i] = splitString[splitString.length - 1].chars[i + index + delimiter.chars.length];
//            }
//            arr = new MyString[splitString.length +1];
//            for (int i = 0; i < splitString.length - 1; i++) {
//                arr[i] = splitString[i];
//            }
//            arr[splitString.length - 1] = new MyString(beforeSection);
//            arr[splitString.length] = new MyString(afterSection);
//            splitString = arr;
//        }else{
//
//        }
//
//        return splitString;
        MyString[] splitString = new MyString[howManyAppearnaces(delimiter) + 1];
        int previousIndex = -1;
        int index = indexOf(delimiter);
        for (int i = 0; i < splitString.length; i++) {
            if (index == -1){
                index = this.chars.length;
            }
            MyString section = new MyString(new char[index - previousIndex - 1]);
            if (index - previousIndex != 1) {
                for (int j = 0; j < section.chars.length; j++) {
                    section.chars[j] = this.chars[previousIndex + 1 + j];
                }
            }
            splitString[i] = section;
            previousIndex = index + delimiter.chars.length - 1;
            index = indexOf(delimiter, previousIndex + delimiter.chars.length);
        }
        return splitString;
    }

    public int howManyAppearnaces(MyString delimiter){
        int appearances = 0;
        int index = indexOf(delimiter);
        while (index != -1){
            appearances++;
            index = indexOf(delimiter, index + delimiter.chars.length);
        }
        return appearances;
    }

    private int indexOf(MyString another, int from){
        if (from > chars.length)
            return -1;
        for (int i = from; i < chars.length; i++) {
            if (another.chars[0] == this.chars[i]){
                if (another.chars.length == 1)
                    return i;
                int counter = 1;
                while (another.chars[counter] == this.chars[i+counter]){
                    counter++;
                    if (counter == another.chars.length)
                        return i;
                    if (i+counter >= chars.length)
                        return -1;
                }
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        for (int i = 0; i < chars.length; i++) {
            System.out.print(chars[i]);
        }
        return "";
    }
}
