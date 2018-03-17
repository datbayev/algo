package leetcode;

// https://leetcode.com/problems/palindrome-pairs/description/
// 336. Palindrome Pairs

import java.util.*;

public class PalindromePairs {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        Trie trie = new Trie();
        for (int i = 0; i < words.length; i++)
            trie.addWord(words[i], i);

        Set<String> used = new HashSet<>();

        for (int i = 0; i < words.length; i++) {
            String cur = words[i];
            StringBuilder sb = new StringBuilder(cur);
            sb.reverse();

            // appending cur
            List<Integer> list = trie.beginsWith(sb.toString());
            for (int x : list) {
                if (x == i)
                    continue;

                if (words[x].length() == sb.length()) { // two symmetric words
                    addToRes(x, i, used, res);
                    continue;
                }

                String temp = words[x].substring(sb.length());

                if (isPalindrome(temp))
                    addToRes(x, i, used, res);
            }

            Node node = trie.root;
            int j = 0;

            while (j < sb.length()) {
                node = node.children.get(sb.charAt(j));
                if (node == null)
                    break;

                if (node.ind != i && node.end && isPalindrome(sb.substring(j + 1)))
                    addToRes(node.ind, i, used, res);

                j++;
            }

            if (trie.root.end && isPalindrome(sb.toString())) {
                addToRes(i, trie.root.ind, used, res);
                addToRes(trie.root.ind, i, used, res);
            }
        }

        return res;
    }

    private void addToRes(int x, int y, Set<String> used, List<List<Integer>> res) {
        if (x == y)
            return;

        if (used.contains(hash(x, y)))
            return;

        used.add(hash(x, y));
        res.add(new ArrayList<>(Arrays.asList(x, y)));
    }

    private String hash(int x, int y) {
        return String.format("%d-%d", x, y);
    }

    private boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++)
            if (s.charAt(i) != s.charAt(s.length() - i - 1))
                return false;

        return true;
    }

    class Trie {
        Node root;

        Trie() {
            Node root = new Node('.');
            root.isRoot = true;
            this.root = root;
        }

        void addWord(String word, int ind) {
            Node cur = root;

            if (word.length() == 0) {
                root.end = true;
                root.ind = ind;
                return;
            }

            for (char c : word.toCharArray()) {
                if (cur.children.containsKey(c))
                    cur = cur.children.get(c);
                else {
                    Node newChild = new Node(c);
                    cur.children.put(c, newChild);
                    cur = newChild;
                }
            }

            cur.end = true;
            cur.ind = ind;
        }

        List<Integer> beginsWith(String word) { // get all words that starts with given string
            Node cur = root;
            List<Integer> res = new ArrayList<>();

            for (char c : word.toCharArray()) {
                if (cur == null)
                    break;

                cur = cur.children.get(c);
            }

            rec(cur, res);

            return res;
        }

        private void rec(Node node, List<Integer> res) {
            if (node == null)
                return;

            if (node.end)
                res.add(node.ind);

            for (Map.Entry<Character, Node> pair : node.children.entrySet()) {
                Node next = pair.getValue();
                rec(next, res);
            }
        }
    }

    class Node {
        char c;
        int ind = -1;
        boolean end = false;
        boolean isRoot = false;
        Map<Character, Node> children = new HashMap<>();

        Node(char c) {
            this.c = c;
        }
    }
}
