package leetcode;

// https://leetcode.com/problems/letter-case-permutation/description/
// 784. Letter Case Permutation

import java.util.*;

public class LetterCasePermutation {
    public List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder(S);
        List<Integer> pos = new ArrayList<>(); // positions of letters in word

        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z')
                pos.add(i);
        }

        int n = pos.size();

        for (int mask = 0; mask < 1 << n; mask++) {
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    sb.setCharAt(pos.get(i), Character.toUpperCase(sb.charAt(pos.get(i))));
                } else {
                    sb.setCharAt(pos.get(i), Character.toLowerCase(sb.charAt(pos.get(i))));
                }
            }
            res.add(new String(sb.toString()));
        }

        return res;
    }
}
