package leetcode;

// https://leetcode.com/problems/word-squares/description/
// 425. Word Squares

import java.util.*;

public class WordSquares {

    class TrieNode {
        List<String> startWith;
        TrieNode[] children;

        TrieNode() {
            startWith = new ArrayList<>(); // list of words that matches beginning in current node
            children = new TrieNode[26]; // lowercase english letters
        }
    }

    class Trie {
        TrieNode root;

        Trie(String[] words) {
            root = new TrieNode();

            for (String w : words) {
                TrieNode cur = root;

                for (char ch : w.toCharArray()) {
                    int idx = ch - 'a';
                    if (cur.children[idx] == null)
                        cur.children[idx] = new TrieNode();

                    cur.children[idx].startWith.add(w);
                    cur = cur.children[idx];
                }
            }
        }

        List<String> findByPrefix(String prefix) {
            List<String> ans = new ArrayList<>();
            TrieNode cur = root;
            for (char ch : prefix.toCharArray()) {
                int idx = ch - 'a';
                if (cur.children[idx] == null)
                    return ans;

                cur = cur.children[idx];
            }

            ans.addAll(cur.startWith);
            return ans;
        }
    }

    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> res = new ArrayList<>();
        if (words == null || words.length == 0)
            return res;

        int len = words[0].length(); // square size
        Trie trie = new Trie(words); // build trie from words dictionary
        List<String> cur = new ArrayList<>();

        for (String w : words) { // start from any word
            cur.add(w);
            rec(len, trie, res, cur);
            cur.remove(cur.size() - 1);
        }

        return res;
    }

    private void rec(int len, Trie trie, List<List<String>> res, List<String> cur) {
        if (cur.size() == len) { // reached max size of square
            res.add(new ArrayList<>(cur)); // add current answer to result
            return;
        }

        int pos = cur.size(); // build prefix from previously used words with letters at index "pos"
        StringBuilder prefix = new StringBuilder();

        for (String s : cur)
            prefix.append(s.charAt(pos));

        List<String> matchingStartsWith = trie.findByPrefix(prefix.toString());

        for (String nextWord : matchingStartsWith) {
            cur.add(nextWord); // add matching word to current list of answers
            rec(len, trie, res, cur); // and go recursively
            cur.remove(cur.size() - 1); // remove from current list and try other options
        }
    }
}
