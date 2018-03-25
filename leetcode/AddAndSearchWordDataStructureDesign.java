package leetcode;

// https://leetcode.com/problems/add-and-search-word-data-structure-design/description/
// 211. Add and Search Word - Data structure design

public class AddAndSearchWordDataStructureDesign {
    Node root;

    class Node {
        Character ch;
        boolean end;
        Node[] children;

        Node(Character ch) {
            this.ch = ch;
            end = false;
            children = new Node[26];
        }
    }

    /** Initialize your data structure here. */
    public AddAndSearchWordDataStructureDesign() {
        root = new Node('_'); // dumb initializer
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        Node cur = root;
        for (char c : word.toCharArray()) {
            if (cur.children[c - 'a'] == null)
                cur.children[c - 'a'] = new Node(c);

            cur = cur.children[c - 'a'];
        }

        cur.end = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return rec(root, word, 0);
    }

    private boolean rec(Node node, String word, int index) {
        if (index == word.length())
            return node.end;

        char c = word.charAt(index);

        if (c != '.') {
            return node.children[c - 'a'] != null && rec(node.children[c - 'a'], word, index + 1);
        } else {
            for (int i = 0; i < 26; i++)
                if (node.children[i] != null && rec(node.children[i], word, index + 1))
                    return true;
        }

        return false;
    }
}
