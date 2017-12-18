package leet_code;

// https://leetcode.com/problems/first-unique-character-in-a-string/description/
// 387. First Unique Character in a String

import java.util.*;

class FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        char[] c = s.toCharArray();
        
        Map<Character, Integer> map = new HashMap();
        
        for (int i = 0; i < c.length; i++) {
            int cur = map.containsKey(c[i]) ? map.get(c[i]) : 0;
            map.put(c[i], cur + 1);
        }
        
        int res = -1;
        for (int i = 0; i < c.length; i++)
            if (map.get(c[i]) == 1) {
                res = i;
                break;
            }
        
        return res;
    }
}
