package com.company;

public class Main {

    public static void main(String[] args) {
	    String[] words = {"Apple", "Tomato", "Banana", "Orange"};
        String sentence = "The boy is eating a t";
        //result: "The boy is eating an Apple"
        int lastIndexOfSpace = sentence.lastIndexOf(' ');
        String lastWord = sentence.substring(lastIndexOfSpace + 1);
        String  completeWord = null;
        for (String word : words){
            if (word.toUpperCase().indexOf(lastWord.toUpperCase()) == 0){
                completeWord = word;
                break;
            }
        }
        if (completeWord != null)
            sentence = sentence.substring(0, lastIndexOfSpace + 1) + completeWord;
        System.out.println(sentence);
    }
}
