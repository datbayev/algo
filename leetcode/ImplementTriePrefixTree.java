package leetcode;

// https://leetcode.com/problems/implement-trie-prefix-tree/description/
// 208. Implement Trie (Prefix Tree)

public class ImplementTriePrefixTree {
    Node root;

    /** Initialize your data structure here. */
    public ImplementTriePrefixTree() {
        root = new Node('.');
    }

    class Node {
        boolean end;
        Character ch;
        Node[] children;

        Node(Character ch) {
            end = false;
            this.ch = ch;
            children = new Node[30];
        }
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node cur = root;

        for (char c : word.toCharArray()) {
            if (cur.children[c - 'a'] == null)
                cur.children[c - 'a'] = new Node(c);

            cur = cur.children[c - 'a'];
        }

        cur.end = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node cur = root;
        for (char c : word.toCharArray()) {
            if (cur.children[c - 'a'] == null)
                return false;

            cur = cur.children[c - 'a'];
        }

        return cur.end;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node cur = root;
        for (char c : prefix.toCharArray()) {
            if (cur.children[c - 'a'] == null)
                return false;

            cur = cur.children[c - 'a'];
        }

        return true;
    }
}

/*
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */