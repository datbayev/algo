package leetcode;

// https://leetcode.com/problems/one-edit-distance/description/
// 161. One Edit Distance

public class OneEditDistance {
    public boolean isOneEditDistance(String str1, String str2) {
        if (str1.equals(str2))
            return false;

        if (Math.abs(str1.length() - str2.length()) > 1)
            return false;

        if (str1.length() == 1 && str1.equals(str2))
            return false;

        if (str1.length() > str2.length()) {
            String temp = str1;
            str1 = str2;
            str2 = temp;
        }

        int ind1 = 0, ind2 = 0;
        boolean diff = false;

        while (ind1 < str1.length() && ind2 < str2.length()) {
            char c1 = str1.charAt(ind1);
            char c2 = str2.charAt(ind2);

            if (c1 == c2) {
                ind1++;
                ind2++;
            } else {
                if (diff)
                    return false;
                diff = true;
                if (str1.length() < str2.length())
                    ind2++;
                else {
                    ind1++;
                    ind2++;
                }
            }
        }

        return true;
    }
}
