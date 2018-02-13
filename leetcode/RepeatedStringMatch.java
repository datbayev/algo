package leetcode;

// https://leetcode.com/problems/repeated-string-match/description/
// 686. Repeated String Match

public class RepeatedStringMatch {
    public int repeatedStringMatch(String A, String B) {
        int[] count = new int[128];

        if (A.contains(B))
            return 1;

        for (char c : A.toCharArray())
            count[c] = 1;

        for (char c : B.toCharArray())
            if (count[c] == 0)
                return -1;

        if (A.length() >= B.length()) {
            StringBuilder sb = new StringBuilder(A);
            if (sb.indexOf(B) >= 0)
                return 0;

            sb.append(A);
            return sb.indexOf(B) >= 0 ? 2 : -1;
        } else {
            int c = 1;
            StringBuilder sb = new StringBuilder(A);
            while (sb.indexOf(B) < 0 && sb.length() <= 2 * B.length()) {
                sb.append(A);
                c++;
            }

            return sb.indexOf(B) >= 0 ? c : -1;
        }
    }
}
