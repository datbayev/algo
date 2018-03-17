package leetcode;

// https://leetcode.com/problems/remove-duplicate-letters/description/
// 316. Remove Duplicate Letters

public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        int[] count = new int[26];
        int min = 0;

        for (char c : s.toCharArray())
            count[c - 'a']++;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < s.charAt(min))
                min = i;

            count[s.charAt(i) - 'a']--;

            if (count[s.charAt(i) - 'a'] == 0)
                break;
        }

        if (s.length() == 0)
            return "";

        return s.charAt(min) + removeDuplicateLetters(s.substring(min + 1).replaceAll("" + s.charAt(min), ""));
    }
}
