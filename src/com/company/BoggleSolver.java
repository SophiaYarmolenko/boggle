package com.company;

import edu.princeton.cs.algs4.TrieST;
import java.util.ArrayList;

public class BoggleSolver
{
    private TrieST<Integer> dict;
    // Initializes the data structure using the given array of strings as the dictionary.
    // (You can assume each word in the dictionary contains only the uppercase letters A through Z.)
    public BoggleSolver(String[] dictionary){
        dict = new TrieST<>();
        for(String each : dictionary){dict.put(each,each.length());}
    }

    // Returns the set of all valid words in the given Boggle board, as an Iterable.
    public Iterable<String> getAllValidWords(BoggleBoard board){
       ArrayList<String> result = new ArrayList<>();
       return null;
    }

    private Iterable<Character> neighbours(BoggleBoard board, int n, int m){
        ArrayList<Character> result = new ArrayList<>();
        if(m>0&&n>0){
            result.add(board.getLetter(n-1,m-1));
            result.add(board.getLetter(n,m-1));
            result.add(board.getLetter(n-1,m));
        }
        if(m>0){}
        if(m<4){result.add(board.getLetter(n,m+1));}
        if(n>0){}
        if(n<4){result.add(board.getLetter(n+1,m));}

    }

    // Returns the score of the given word if it is in the dictionary, zero otherwise.
    // (You can assume the word contains only the uppercase letters A through Z.)
    public int scoreOf(String word){return 0;}
}
