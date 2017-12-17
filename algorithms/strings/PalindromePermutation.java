package algorithms.strings;

/*
Algorithm to check if given string is a permutation of a palindrome.
 */

public class PalindromePermutation {
    public static boolean check(String str) {
        byte[] count = new byte[128];
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if ((c >= 65 && c <= 90) || (c >= 97 && c <= 122)) {
                if (c <= 90)
                    c += 32;
                count[c]++;
            }
        }

        boolean foundOdd = false;
        for (int i = 0; i < 128; i++) {
            if (count[i] % 2 == 1) {
                if (!foundOdd)
                    foundOdd = true;
                else
                    return false;
            }
        }

        return true;
    }

    public static boolean check1(String str) {
        int bitVector = getBitVector(str);
        return bitVector == 0 || hasOnlyOneBit(bitVector);
    }

    public static int getBitVector(String str) {
        int bitVector = 0;

        for (char c : str.toCharArray()) {
            int pos = getCharNum(c);
            bitVector = toggleBit(bitVector, pos);
        }

        return bitVector;
    }

    public static int toggleBit(int bitVector, int pos) {
        if (pos < 0)
            return bitVector;

        int mask = 1 << pos;
        if ((bitVector & mask) == 0) {
            bitVector |= mask;
        } else {
            bitVector &= ~mask;
        }

        return bitVector;
    }

    public static int getCharNum(char c) {
        if (c >= 65 && c <= 90)
            return c - 'A';
        else if (c >= 97 && c <= 122)
            return c - 'a';

        return -1;
    }

    public static boolean hasOnlyOneBit(int bitVector) {
        return (bitVector & (bitVector - 1)) == 0;
    }
}
