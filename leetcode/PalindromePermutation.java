package leetcode;

// https://leetcode.com/problems/palindrome-permutation/description/
// 266. Palindrome Permutation

public class PalindromePermutation {
    public boolean canPermutePalindrome(String s) {
        // palindrome is when all characters appears twice
        // and at most one character appears once
        int[] ch = new int[128];
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            int num = s.charAt(i);
            ch[num]++;
            if (ch[num] % 2 == 0) count--;
            else count++;
        }

        return count <= 1;
    }
}
