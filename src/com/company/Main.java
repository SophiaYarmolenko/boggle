package com.company;
import edu.princeton.cs.algs4.In;
public class Main {

    public static void main(String[] args) {
	In in = new In("dictionary-yawl.txt");
	BoggleBoard b = new BoggleBoard();
	BoggleSolver a = new BoggleSolver(in.readAllLines());
	System.out.println(b.toString());
//	for(String each : a.getAllValidWords(b)) {
//		System.out.println(each);
//	}
    }
}
