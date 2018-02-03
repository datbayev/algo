package leetcode;

// https://leetcode.com/problems/sentence-similarity/description/
// 734. Sentence Similarity

import java.util.*;

public class SentenceSimilarity {
    public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
        if (words1.length != words2.length)
            return false;

        Map<String, Set<String>> map = new HashMap();
        for (int i = 0; i < pairs.length; i++) {
            String w1 = pairs[i][0];
            String w2 = pairs[i][1];

            if (!map.containsKey(w1))
                map.put(w1, new HashSet());

            map.get(w1).add(w2);

            if (!map.containsKey(w2))
                map.put(w2, new HashSet());

            map.get(w2).add(w1);
        }

        for (int i = 0; i < words1.length; i++) {
            String w1 = words1[i], w2 = words2[i];

            if (w1.equals(w2)) // both words are equal, continue comparing other words
                continue;

            if (map.containsKey(w1) && map.get(w1).contains(w2) || map.containsKey(w2) && map.get(w2).contains(w1))
                continue;

            return false;
        }

        return true;
    }
}
