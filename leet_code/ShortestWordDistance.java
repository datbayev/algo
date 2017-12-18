package leet_code;

// https://leetcode.com/problems/shortest-word-distance/description/
// 243. Shortest Word Distance

import java.util.*;

class ShortestWordDistance {
    public int shortestDistance(String[] words, String word1, String word2) {
        List<Integer> list1 = new ArrayList();
        List<Integer> list2 = new ArrayList();
        
        for (int i = 0; i < words.length; i++)
            if (words[i].equals(word1))
                list1.add(i);
            else if (words[i].equals(word2))
                list2.add(i);
        
        int min = Integer.MAX_VALUE;
        for (Integer x1 : list1)
            for (Integer x2 : list2)
                min = Math.min(min, Math.abs(x1 - x2));
        
        return min;
    }
}
