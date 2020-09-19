package com.company;

import java.util.ArrayList;
public class BoggleSolver
{
    private class Tile{
        public int n;
        public int m;
        public char a;
        public Tile(int b,int c, char d){
            n = b;
            m = c;
            a = d;
        }
    }
    private Trie dict;
    // Initializes the data structure using the given array of strings as the dictionary.
    // (You can assume each word in the dictionary contains only the uppercase letters A through Z.)
    public BoggleSolver(String[] dictionary){
        dict = new Trie();
        for(String each : dictionary){dict.put(each,each.length());}
    }

    // Returns the set of all valid words in the given Boggle board, as an Iterable.
    public Iterable<String> getAllValidWords(BoggleBoard board){
       ArrayList<String> result = new ArrayList<>();
       return null;
    }

    private Iterable<Tile> neighbours(BoggleBoard board, Tile tile){
        ArrayList<Tile> result = new ArrayList<>();
        int n = tile.n;
        int m = tile.m;
        if(m>0){result.add(new Tile(n,m-1,board.getLetter(n,m-1)));}
        if(m<4){result.add(new Tile(n,m+1,board.getLetter(n,m+1)));}
        if(n>0){result.add(new Tile(n-1,m,board.getLetter(n-1,m)));}
        if(n<4){result.add(new Tile(n+1,m,board.getLetter(n+1,m)));}
        if(m>0&&n>0){result.add(new Tile(n-1,m-1,board.getLetter(n-1,m-1)));}
        if(m>0&&n<4){result.add(new Tile(n+1,m-1,board.getLetter(n+1,m-1)));}
        if(m<4&&n>0){result.add(new Tile(n-1,m+1,board.getLetter(n-1,m+1)));}
        if(m<4&&n<4){result.add(new Tile(n+1,m+1,board.getLetter(n+1,m+1)));}
        return result;
    }

    private void words(Tile tile, ArrayList res, BoggleBoard board, Node node){
        if(node.val!=0){}
        for(Tile each : neighbours(board,tile)){
            if(node.contains(each.a)){

            }
        }
    }
    // Returns the score of the given word if it is in the dictionary, zero otherwise.
    // (You can assume the word contains only the uppercase letters A through Z.)
    public int scoreOf(String word){return 0;}
}
