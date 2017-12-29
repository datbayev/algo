package leetcode;

// https://leetcode.com/problems/shortest-completing-word/description/
// 749. Shortest Completing Word

public class ShortestCompletingWord {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        String res = "";
        int total = 0;
        int minLen = 16;
        int[] count = new int[26];
        int[] countCopy = new int[26];

        for (char c : licensePlate.toLowerCase().toCharArray())
            if (c >= 'a' && c <= 'z') {
                countCopy[c - 'a']++;
                total++;
            }

        for (String cur : words) {
            int curCount = 0;
            count = countCopy.clone();

            for (char c : cur.toLowerCase().toCharArray()) {
                if (count[c - 'a'] > 0) {
                    count[c - 'a']--;
                    curCount++;
                }
            }

            if (curCount == total && minLen > cur.length()) {
                minLen = cur.length();
                res = cur;
            }
        }

        return res;
    }
}
