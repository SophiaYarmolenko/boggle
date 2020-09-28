package com.company;

import java.util.ArrayList;
import java.util.HashSet;

public class BoggleSolver {
    private class Tile {
        public int n;
        public int m;
        public char a;
        public boolean marked = false;

        public Tile(int b, int c, char d) {
            n = b;
            m = c;
            a = d;
        }
    }

    private Tile[][] tiles;
    private ArrayList<Tile>[][] neighbour;
    private final Trie dict;

    public BoggleSolver(String[] dictionary) {
        dict = new Trie();
        for (String each : dictionary) {
            dict.put(each, each.length());
        }
    }

//    public boolean contains(String key) {
//        return dict.contains(key);
//    }

    // Returns the set of all valid words in the given Boggle board, as an Iterable.
    public Iterable<String> getAllValidWords(BoggleBoard board) {
        int n = board.rows();
        int m = board.cols();
        tiles = new Tile[n][m];
        neighbour = new ArrayList[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                tiles[i][j] = new Tile(i, j, board.getLetter(i, j));
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                neighbour[i][j] = neighbours(board,tiles[i][j]);
            }
        }
        HashSet<String> result = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                StringBuilder str = new StringBuilder();
                words(str, tiles[i][j], result, board, dict.root());
            }
        }
        return result;
    }

    private ArrayList<Tile> neighbours(BoggleBoard board, Tile tile) {
        ArrayList<Tile> result = new ArrayList<>();
        int n = tile.n;
        int m = tile.m;
        if (m > 0) {
            result.add(tiles[n][m - 1]);
        }
        if (m < tiles[0].length-1) {
            result.add(tiles[n][m + 1]);
        }
        if (n > 0) {
            result.add(tiles[n - 1][m]);
        }
        if (n < tiles.length-1) {
            result.add(tiles[n + 1][m]);
        }
        if (m > 0 && n > 0) {
            result.add(tiles[n - 1][m - 1]);
        }
        if (m > 0 && n < tiles.length-1) {
            result.add(tiles[n + 1][m - 1]);
        }
        if (m < tiles[0].length-1 && n > 0) {
            result.add(tiles[n - 1][m + 1]);
        }
        if (m < tiles[0].length-1 && n < tiles.length-1) {
            result.add(tiles[n + 1][m + 1]);
        }
        return result;
    }

    private void words(StringBuilder str, Tile tile, HashSet<String> res, BoggleBoard board, Node node) {
        if (node.val != 0) {
            if (str.length() >= 3) res.add(str.toString());
        }
        for (Tile each : neighbour[tile.n][tile.m]) {
            if (node.contains(each.a) && !each.marked) {
                each.marked = true;
                if(each.a=='Q'){
                    if(node.next[16].next[20]!=null){
                    str.append('Q');
                    str.append('U');
                    words(str,each,res,board,node.next[16].next[20]);
                    str.deleteCharAt(str.length() - 1);
                    str.deleteCharAt(str.length() - 1);}
                }
                else{int k = each.a - 'A';
                    str.append(each.a);
                    words(str, each, res, board, node.next[k]);
                    str.deleteCharAt(str.length() - 1);}
                each.marked = false;
            }
        }
    }

    // Returns the score of the given word if it is in the dictionary, zero otherwise.
    // (You can assume the word contains only the uppercase letters A through Z.)
    public int scoreOf(String word) {
        if(!dict.contains(word)){return 0;}
        int l = 0;
        for (int i = 0; i < word.length(); i++) {
            l++;
        }
        if (l < 3) return 0;
        if (l < 5) return 1;
        if (l < 6) return 2;
        if (l < 7) return 3;
        if (l < 8) return 5;
        if (l > 7) return 11;
        return 0;
    }
}
