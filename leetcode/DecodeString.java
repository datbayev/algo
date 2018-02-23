package leetcode;

// https://leetcode.com/problems/decode-string/description/
// 394. Decode String

public class DecodeString {
    public String decodeString(String s) {
        if (!s.contains("]"))
            return s;

        StringBuilder sb = new StringBuilder(s);

        while (sb.indexOf("]") >= 0) {
            int j = sb.indexOf("]");
            int i = j - 1;
            while (i >= 0 && sb.charAt(i) != '[')
                i--;

            String repeat = sb.substring(i + 1, j); // string inside square brackets

            int k = i - 1;
            while (k >= 0 && sb.charAt(k) >= '0' && sb.charAt(k) <= '9')
                k--;

            int num = Integer.parseInt(sb.substring(k + 1, i)); // how many times to repeat

            StringBuilder replace = new StringBuilder("");
            while (num > 0) {
                replace.append(repeat);
                num--;
            }

            sb.replace(k + 1, j + 1, replace.toString());
        }

        return sb.toString();
    }
}
