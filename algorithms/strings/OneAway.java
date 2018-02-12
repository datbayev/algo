package algorithms.strings;

/*
Algorithm to check if two strings are one edit (or zero edits) away.
*/

public class OneAway {
    public static boolean isOneAway(String str1, String str2) {
        if (Math.abs(str1.length() - str2.length()) > 1)
            return false;

        if (str1.length() > str2.length()) {
            String temp = str1;
            str1 = str2;
            str2 = temp;
        }

        boolean different = false;
        int i = 0, j = 0;

        while (i < str1.length() && j < str2.length()) {
            if (str1.charAt(i) != str2.charAt(j)) {

                if (different)
                    return false;

                different = true;

                if (str2.length() > str1.length()) {
                    j++;
                    continue;
                }
            }

            i++;
            j++;
        }

        return different || str1.length() != str2.length();
    }

    public static boolean isOneAwayRecursive(String str1, String str2) {
        if (Math.abs(str1.length() - str2.length()) > 1)
            return false;

        return compare(str1, str2, 0, 0, 1, 0);
    }

    private static boolean compare(String s1, String s2, int ind1, int ind2, int max, int cur) {
        // base cases first

        // max amount of edits is exceeded
        if (cur > max)
            return false;

        // nothing to compare and there's still a limit possible, then true
        if (ind1 > s1.length() - 1 || ind2 > s2.length())
            return true;

        while (ind1 < s1.length() && ind2 < s2.length()) {
            if (s1.charAt(ind1) != s2.charAt(ind2))
                return compare(s1, s2, ind1 + 1, ind2, max, cur + 1)
                    || compare(s1, s2, ind1 + 1, ind2 + 1, max, cur + 1);

            ind1++;
            ind2++;
        }

        return true;
    }
}
