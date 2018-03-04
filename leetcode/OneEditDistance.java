package leetcode;

// https://leetcode.com/problems/one-edit-distance/description/
// 161. One Edit Distance

public class OneEditDistance {
    public boolean isOneEditDistance(String str1, String str2) {
        if (Math.abs(str1.length() - str2.length()) > 1)
            return false;

        // let str2 be longer than str1
        if (str1.length() > str2.length()) {
            String temp = str1;
            str1 = str2;
            str2 = temp;
        }

        int i = 0, j = 0;
        boolean used = false;
        int diff = Math.abs(str1.length() - str2.length());

        while (i < str1.length() && j < str2.length()) {
            if (str1.charAt(i) == str2.charAt(j)) {
                i++;
                j++;
            } else {
                if (used)
                    return false;

                used = true;
                if (diff == 0)
                    i++;
                j++;
            }
        }

        return used || diff > 0;
    }
}
