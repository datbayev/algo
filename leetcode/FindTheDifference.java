package leetcode;

// https://leetcode.com/problems/find-the-difference/description/
// 389. Find the Difference

public class FindTheDifference {
    public char findTheDifference(String s, String t) {
        int[] count = new int[128];
        char res = 'a'; // dummy init

        for (char c : s.toCharArray())
            count[c]++;

        for (char c : t.toCharArray()) {
            count[c]--;
            if (count[c] < 0) {
                res = c;
                break;
            }
        }

        return res;
    }
}
