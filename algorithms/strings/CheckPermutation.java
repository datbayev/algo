package algorithms.strings;

import java.util.Arrays;

/*
Given two strings, write a method to decide if one is a permutation of the other.
 */

public class CheckPermutation {
    public static boolean check(String str1, String str2) {
        if (str1.length() != str2.length())
            return false;

        char[] c1 = str1.toCharArray();
        char[] c2 = str2.toCharArray();

        Arrays.sort(c1);
        Arrays.sort(c2);

        for (int i = 0; i < c1.length; i++)
            if (c1[i] != c2[i])
                return false;

        return true;
    }

    public static boolean check1(String str1, String str2) {
        if (str1.length() != str2.length())
            return false;

        int[] count = new int[128];
        for (int i = 0; i < str1.length(); i++)
            count[str1.charAt(i)]++;

        for (int i = 0; i < str1.length(); i++) {
            count[str2.charAt(i)]--;
            if (count[str2.charAt(i)] < 0)
                return false;
        }

        return true;
    }
}
