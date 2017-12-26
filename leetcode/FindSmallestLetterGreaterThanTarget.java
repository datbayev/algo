package leetcode;

// https://leetcode.com/problems/find-smallest-letter-greater-than-target/description/
// 744. Find Smallest Letter Greater Than Target

public class FindSmallestLetterGreaterThanTarget {
    public char nextGreatestLetter(char[] letters, char target) {
        int l = 0, r = letters.length - 1, res = letters.length - 1;

        while (l < r) {
            int m = l + (r - l) / 2;
            if (letters[m] <= target)
                l = m + 1;
            else {
                r = m;
                res = Math.min(res, m);
            }
        }

        return letters[res] <= target ? letters[0] : letters[res];
    }
}
