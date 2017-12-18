package leetcode;

// https://leetcode.com/problems/reverse-vowels-of-a-string/description/
// 345. Reverse Vowels of a String

import java.util.*;

class ReverseVowelsOfAString {
    public String reverseVowels(String s) {
        Set<Character> set = new HashSet();
        set.add('A'); set.add('a');
        set.add('E'); set.add('e');
        set.add('U'); set.add('u');
        set.add('I'); set.add('i');
        set.add('O'); set.add('o');

        int left = 0, right = s.length() - 1;
        char[] c = s.toCharArray();
        
        while (left < right) {
            while (left < right && !set.contains(c[left])) left++;
            while (right > left && !set.contains(c[right])) right--;
            
            char temp = c[left];
            c[left] = c[right];
            c[right] = temp;
            
            left++;
            right--;
        }
        
        return String.valueOf(c);
    }
}
