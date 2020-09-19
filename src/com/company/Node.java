package com.company;

public class Node {
    public int val=0;
    public Node[] next = new Node[26];
    public boolean contains(char a){
        int k = a-'A';
        return next[k]!=null;
    }
    public boolean isWord(char a){
        if(contains(a)){int k = a-'A'; return next[k].val!=0;}
        else{return false;}
    }
}
