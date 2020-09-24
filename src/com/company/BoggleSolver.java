package com.company;

import java.util.ArrayList;
public class BoggleSolver
{
    private class Tile{
        public int n;
        public int m;
        public char a;
        public boolean marked=false;
        public Tile(int b,int c, char d){
            n = b;
            m = c;
            a = d;
        }
    }
    private final Trie dict;
    // Initializes the data structure using the given array of strings as the dictionary.
    // (You can assume each word in the dictionary contains only the uppercase letters A through Z.)
    public BoggleSolver(String[] dictionary){
        dict = new Trie();
        for(String each : dictionary){dict.put(each,each.length());}
    }
    public boolean contains(String key){return dict.contains(key);}

    // Returns the set of all valid words in the given Boggle board, as an Iterable.
    public Iterable<String> getAllValidWords(BoggleBoard board){
       ArrayList<String> result = new ArrayList<>();
       for(int i=0;i<4;i++){
           for(int j=0;j<4;j++){
               Tile tile = new Tile(i,j,board.getLetter(i,j));
               StringBuilder str = new StringBuilder();
               words(str,tile,result,board,dict.root());
           }
       }
       return result;
    }

    private Iterable<Tile> neighbours(BoggleBoard board, Tile tile){
        ArrayList<Tile> result = new ArrayList<>();
        int n = tile.n;
        int m = tile.m;
        if(m>0){result.add(new Tile(n,m-1,board.getLetter(n,m-1)));}
        if(m<3){result.add(new Tile(n,m+1,board.getLetter(n,m+1)));}
        if(n>0){result.add(new Tile(n-1,m,board.getLetter(n-1,m)));}
        if(n<3){result.add(new Tile(n+1,m,board.getLetter(n+1,m)));}
        if(m>0&&n>0){result.add(new Tile(n-1,m-1,board.getLetter(n-1,m-1)));}
        if(m>0&&n<3){result.add(new Tile(n+1,m-1,board.getLetter(n+1,m-1)));}
        if(m<3&&n>0){result.add(new Tile(n-1,m+1,board.getLetter(n-1,m+1)));}
        if(m<3&&n<3){result.add(new Tile(n+1,m+1,board.getLetter(n+1,m+1)));}
        return result;
    }

    private void words(StringBuilder str, Tile tile, ArrayList<String> res, BoggleBoard board, Node node){
        if(node.val!=0){if(str.length()>3)res.add(str.toString());}
        for(Tile each : neighbours(board,tile)){
            if(each.marked) System.out.println("This tile is marked");
            if(node.contains(each.a)&&!each.marked){
                //System.out.println(str.toString());
                each.marked=true;
                int k = each.a-'A';
                str.append(tile.a);
                words(str,each,res,board,node.next[k]);
                str.deleteCharAt(str.length()-1);
                each.marked=false;
            }
        }
    }
    // Returns the score of the given word if it is in the dictionary, zero otherwise.
    // (You can assume the word contains only the uppercase letters A through Z.)
    public int scoreOf(String word){
        int l=0;
        for(int i=0;i<word.length();i++){
            if(word.charAt(i)=='Q'){l+=2;}
            else{l++;}
        }
        if(l<3) return 0;
        if(l<5) return 1;
        if(l<6) return 2;
        if(l<7) return 3;
        if(l<8) return 5;
        if(l>7) return 11;
        return 0;
    }
}
