package com.company;

public class Trie {
    private static final int R = 26;
    private Node root;
    private int n;

    public Trie(){}

    public int get(String key) {
        if (key == null) throw new IllegalArgumentException("argument to get() is null");
        Node x = get(root, key, 0);
        if (x == null) return 0;
        return (int) x.val;
    }
    private Node get(Node x, String key, int d) {
        if (x == null) return null;
        if (d == key.length()) return x;
        char c = key.charAt(d);
        return get(x.next[c], key, d+1);
    }
    public boolean contains(String key) {
        if (key == null) throw new IllegalArgumentException("argument to contains() is null");
        return get(key) != 0;
    }
    public void put(String key, int val) {
        if (key == null) throw new IllegalArgumentException("first argument to put() is null");
        if (val == 0) delete(key);
        else root = put(root, key, val, 0);
    }
    private Node put(Node x, String key, int val, int d) {
        if (x == null) x = new Node();
        if (d == key.length()) {
            if (x.val == 0) n++;
            x.val = val;
            return x;
        }
        char c = key.charAt(d);
        x.next[c] = put(x.next[c], key, val, d+1);
        return x;
    }
    public void delete(String key) {
        if (key == null) throw new IllegalArgumentException("argument to delete() is null");
        root = delete(root, key, 0);
    }
    private Node delete(Node x, String key, int d) {
        if (x == null) return null;
        if (d == key.length()) {
            if (x.val != 0) n--;
            x.val = 0;
        }
        else {
            char c = key.charAt(d);
            x.next[c] = delete(x.next[c], key, d+1);
        }
        if (x.val != 0) return x;
        for (int c = 0; c < R; c++)
            if (x.next[c] != null)
                return x;
        return null;
    }

    }
