package leetcode;

// https://leetcode.com/problems/string-to-integer-atoi/description/
// 8. String to Integer (atoi)

public class StringToIntegerAtoi {
    public int myAtoi(String str) {
        if (str.length() == 0)
            return 0;

        char[] c = str.toCharArray();
        long res = 0;

        int i = 0;
        while (i < c.length && c[i] == ' ')
            i++;

        boolean isNegative = false;
        if (c[i] < '0' || c[i] > '9') {
            int j = i;
            while (j < c.length && (c[j] < '0' || c[j] > '9'))
                j++;

            if (j - i > 1)
                return 0;

            if (c[i] == '-')
                isNegative = true;
            else if (c[i] != '+')
                return 0;

            i = j;
        }

        while (i < c.length) {
            if (c[i] >= '0' && c[i] <= '9')
                res = res * 10 + (c[i] - '0');
            else
                break;

            if (res > Integer.MAX_VALUE)
                break;

            i++;
        }

        if (isNegative)
            res *= -1;

        if (res > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        else if (res < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;

        return (int)res;
    }
}
