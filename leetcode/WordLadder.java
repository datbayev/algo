package leetcode;

// https://leetcode.com/problems/word-ladder
// 127. Word Ladder

import java.util.*;

class WordLadder {
    Map<String, Integer> wordDepth;
    Map<String, Integer> colors;
    Set<String> words;
    Set<String> used;
    
    int minDepth;
    int dictSize;
    String endWord;
    String beginWord;
    boolean found = false;
    
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord))
            return 0;
        
        this.minDepth = Integer.MAX_VALUE;
        this.dictSize = wordList.size();
        this.beginWord = beginWord;
        this.endWord = endWord;
        
        used = new HashSet();
        words = new HashSet();
        colors = new HashMap();
        wordDepth = new HashMap();
        
        for (int i = 0; i < wordList.size(); i++) 
            if (!wordList.get(i).equals(beginWord))
                words.add(wordList.get(i));
        
        colors.put(beginWord, 0);
        colors.put(endWord, 1);
        
        bfsTwoSide(beginWord, endWord);
        
        return found ? this.minDepth : 0;
    }
    
    public void bfsTwoSide(String beginWord, String endWord) {
        wordDepth.put(beginWord, 1);
        wordDepth.put(endWord, 1);
        
        used.add(beginWord);
        used.add(endWord);
        
        String[] q = new String[dictSize + 1];
        int left = 0;
        int right = 1;
        
        q[left] = beginWord;
        q[right] = endWord;
        
        while (left <= right && !found) {
            char[] curWord = q[left].toCharArray();
            String curWordStr = String.valueOf(curWord);
            
            for (int i = 0; i < curWord.length; i++) {
                char old = curWord[i];
                for (char c = 'a'; c <= 'z'; c++) {
                    curWord[i] = c;
                    String newWord = String.valueOf(curWord);
                    
                    if (words.contains(newWord)) {
                        if (!used.contains(newWord)) {
                            right++;
                            q[right] = newWord;
                            used.add(newWord);
                            colors.put(newWord, colors.get(curWordStr));
                            wordDepth.put(newWord, wordDepth.get(curWordStr) + 1);
                        } else if (colors.get(curWordStr) != colors.get(newWord)) {
                            this.minDepth = wordDepth.get(curWordStr) + wordDepth.get(newWord);
                            found = true;
                            return;
                        }
                    }
                }
                
                curWord[i] = old;
            }
            
            left++;
        }
    }
}
