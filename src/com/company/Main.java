package com.company;
import edu.princeton.cs.algs4.TrieST;
public class Main {

    public static void main(String[] args) {
	TrieST<Integer> a = new TrieST();
	a.put("alpha",1);
        System.out.println(a.longestPrefixOf("alpha"));
    }
}
