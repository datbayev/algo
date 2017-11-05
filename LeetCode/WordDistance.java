// https://leetcode.com/problems/shortest-word-distance-ii/description/
// 244. Shortest Word Distance II

class WordDistance {
    Map<String, List<Integer>> map;
    
    public WordDistance(String[] words) {
        map = new HashMap();
        for (int i = 0; i < words.length; i++) {
            if (!map.containsKey(words[i]))
                map.put(words[i], new ArrayList());
            
            map.get(words[i]).add(i);
        }
    }
    
    public int shortest(String word1, String word2) {
        int min = Integer.MAX_VALUE;
        for (Integer x1 : map.get(word1)) 
            for (Integer x2 : map.get(word2))
                min = Math.min(min, Math.abs(x1 - x2));
        
        return min;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */
