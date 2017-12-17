package algorithms.strings;

/*
Algorithm to check if two strings are one edit (or zero edits) away.
*/

public class OneAway {
    public static boolean isOneAway(String str1, String str2) {
        int[] count = new int[128];

        if (Math.abs(str1.length() - str2.length()) > 1)
            return false;

        if (str1.length() > str2.length()) {
            String temp = str1;
            str1 = str2;
            str2 = temp;
        }

        for (char c : str1.toCharArray()) {
            count[c]++;
        }

        boolean hasNegative = false;
        for (char c : str2.toCharArray()) {
            count[c]--;
            if (count[c] < 0) {
                if (!hasNegative)
                    hasNegative = true;
                else
                    return false;
            }
        }

        return true;
    }
}
