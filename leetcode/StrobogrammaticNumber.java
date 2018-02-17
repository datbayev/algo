package leetcode;

// https://leetcode.com/problems/strobogrammatic-number/description/
// 246. Strobogrammatic Number

public class StrobogrammaticNumber {
    public boolean isStrobogrammatic(String num) {
        int i = 0, j = num.length() - 1;

        while (i <= j) {
            char left = num.charAt(i);
            char right = num.charAt(num.length() - 1 - i);

            boolean ok = false;

            if (left == right && (left == '0' || left == '8' || left == '1'))
                ok = true;
            else if (left != right && (left == '6' && right == '9' || left == '9' && right == '6'))
                ok = true;

            if (!ok)
                return false;

            i++;
            j--;
        }

        return true;
    }
}
