package leetcode;

// https://leetcode.com/problems/implement-trie-prefix-tree/description/
// 208. Implement Trie (Prefix Tree)

import java.util.*;

public class Trie {
    Node root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new Node();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node cur = root;
        Node last = root;

        for (int i = 0; i < word.length(); i++) {
            char x = word.charAt(i);
            if (cur.children.containsKey(x)) {
                cur = cur.children.get(x);
            } else {
                Node newLetter = new Node(x);
                cur.children.put(x, newLetter);
                // System.out.println(String.format(" >> creating new child! inner cur=%c, ", cur.c));
                cur = newLetter;
            }

            last = cur;
        }

        last.setAsEnd();
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        // System.out.println("search: " + word);

        Node cur = root;

        for (int i = 0; i < word.length(); i++) {
            char x = word.charAt(i);

            if (!cur.children.containsKey(x))
                return false;

            cur = cur.children.get(x);
        }

        return cur.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        // System.out.println("startsWith: " + prefix);
        Node cur = root;

        for (int i = 0; i < prefix.length(); i++) {
            char x = prefix.charAt(i);
            // System.out.println(String.format(" > x=%c, cur=%c", x, cur.c));

            if (!cur.children.containsKey(x))
                return false;

            cur = cur.children.get(x);
        }

        return true;
    }

    class Node {
        char c;
        boolean isEnd = false;
        boolean isRoot = false;
        Map<Character, Node> children = new HashMap();

        public Node(char c) {
            this.c = c;
        }

        public Node() {
            this.isRoot = true;
            this.c = 'X';
        }

        public void setAsEnd() {
            this.isEnd = true;
        }
    }
}
