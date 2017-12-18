package leetcode;

// https://leetcode.com/problems/isomorphic-strings/description/
// 205. Isomorphic Strings

import java.util.*;

class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        char[] c1 = s.toCharArray();
        char[] c2 = t.toCharArray();
        
        Map<Character, Character> map = new HashMap();
        Set<Character> set = new HashSet();
        
        for (int i = 0; i < c1.length; i++) {
            if (!map.containsKey(c1[i])) {
                if (set.contains(c2[i]))
                    return false;
                
                map.put(c1[i], c2[i]);
                set.add(c2[i]);
            } else {
                if (map.get(c1[i]) != c2[i])
                    return false;
            }
        }
        
        return true;
    }
}
