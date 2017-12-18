package leet_code;

// https://leetcode.com/problems/count-binary-substrings/description/
// 696. Count Binary Substrings

import java.util.*;

class CountBinarySubstrings {
    public int countBinarySubstrings(String s) {
        if (s.length() < 2)
            return 0;
        
        char[] str = s.toCharArray();
        List<Integer> list = new ArrayList();
        
        int i = 0;
        while (i < str.length - 1) {
            char cur = str[i];
            
            int j = i;
            while (i < str.length - 1 && cur == str[i + 1])
                i++;
            
            int curConsec = i - j + 1;
            list.add(curConsec);
            
            if (cur == str[i])
                i++;
        }
        
        if (str[str.length - 1] != str[str.length - 2])
            list.add(1);
        
        int total = list.size() - 1; // number of switches
        
        i = 0;
        while (i < list.size() - 1) {
            int min = Math.min(list.get(i), list.get(i + 1));
            if (min > 1)
                total += min - 1;
            i++;
        }
        
        return total;
    }
}
