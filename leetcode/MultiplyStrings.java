package leetcode;

// https://leetcode.com/problems/multiply-strings/description/
// 43. Multiply Strings

import java.util.*;

public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0"))
            return "0";

        StringBuilder sb = new StringBuilder(num1);
        num1 = sb.reverse().toString();

        sb = new StringBuilder(num2);
        num2 = sb.reverse().toString();

        List<String> res = new ArrayList<>();
        int carry = 0;

        for (int i = 0; i < num1.length(); i++) {
            int n1 = num1.charAt(i) - '0';
            sb = new StringBuilder();
            carry = 0;

            for (int j = 0; j < num2.length(); j++) {
                int n2 = num2.charAt(j) - '0';
                int total = n1 * n2 + carry;

                carry = total / 10;
                sb.append(total % 10);
            }

            if (carry > 0)
                sb.append(carry);

            res.add(sb.toString());
        }

        sb = new StringBuilder();
        int size = res.get(0).length();
        carry = 0;

        for (int i = 0; i < num1.length() + num2.length(); i++) {
            int sum = carry;

            for (int j = 0; j < res.size(); j++) {
                String cur = res.get(j);
                int index = i - j;

                if (index >= 0 && index < cur.length())
                    sum += cur.charAt(index) - '0';
            }

            carry = sum / 10;
            sb.append(sum % 10);
        }

        if (carry > 0)
            sb.append(carry);

        while (sb.charAt(sb.length() - 1) == '0')
            sb.deleteCharAt(sb.length() - 1);

        return sb.reverse().toString();
    }
}
