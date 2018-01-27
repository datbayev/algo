package leetcode;

// https://leetcode.com/problems/implement-trie-prefix-tree/description/
// 208. Implement Trie (Prefix Tree)

import java.util.*;

class Trie {

    Node root;

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
        }

        public void setAsEnd() {
            this.isEnd = true;
        }
    }

    /** Initialize your data structure here. */
    public Trie() {
        root = new Node();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node cur = root;

        for (int i = 0; i < word.length(); i++) {
            char x = word.charAt(i);
            if (cur.children.containsKey(x)) {
                cur = cur.children.get(x);
            } else {
                Node newLetter = new Node(x);
                cur.children.put(x, newLetter);

                cur = newLetter;
            }
        }

        cur.setAsEnd();
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
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
        Node cur = root;

        for (int i = 0; i < prefix.length(); i++) {
            char x = prefix.charAt(i);

            if (!cur.children.containsKey(x))
                return false;

            cur = cur.children.get(x);
        }

        return true;
    }
}