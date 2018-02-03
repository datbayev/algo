package leetcode;

// https://leetcode.com/problems/sentence-similarity-ii/description/
// 737. Sentence Similarity II

import java.util.*;

public class SentenceSimilarityII {
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
        if (words1.length != words2.length)
            return false;

        Map<String, Set<String>> graph = buildGraph(pairs);

        for (int i = 0; i < words1.length; i++)
            if (!similar(words1[i], words2[i], graph))
                return false;

        return true;
    }

    private Map<String, Set<String>> buildGraph(String[][] pairs) {
        Map<String, Set<String>> g = new HashMap();

        for (int i = 0; i < pairs.length; i++) {
            String w1 = pairs[i][0];
            String w2 = pairs[i][1];

            if (!g.containsKey(w1))
                g.put(w1, new HashSet());
            g.get(w1).add(w2);

            if (!g.containsKey(w2))
                g.put(w2, new HashSet());
            g.get(w2).add(w1);
        }

        return g;
    }

    private boolean similar(String w1, String w2, Map<String, Set<String>> g) {
        if (w1.equals(w2))
            return true;

        if (g.containsKey(w1) && g.get(w1).contains(w2) || g.containsKey(w2) && g.get(w2).contains(w1))
            return true;

        Set<String> used = new HashSet();
        used.add(w1);

        ArrayDeque<String> q = new ArrayDeque();
        q.add(w1);

        while (!q.isEmpty()) {
            String cur = q.poll();
            if (cur.equals(w2))
                return true;

            if (g.containsKey(cur)) {
                Iterator<String> it = g.get(cur).iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (next.equals(w2)) // match found! Exit true
                        return true;

                    if (!used.contains(next)) {
                        q.add(next); // add to the queue
                        used.add(next); // mark as used
                    }
                }
            }
        }

        return false;
    }
}
