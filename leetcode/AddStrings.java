package leetcode;

// https://leetcode.com/problems/add-strings/description/
// 415. Add Strings

public class AddStrings {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder(num1);
        num1 = sb.reverse().toString();

        sb = new StringBuilder(num2);
        num2 = sb.reverse().toString();

        int carry = 0;

        sb = new StringBuilder("");

        for (int i = 0; i < Math.max(num1.length(), num2.length()); i++) {
            int n1 = i < num1.length() ? num1.charAt(i) - '0' : 0;
            int n2 = i < num2.length() ? num2.charAt(i) - '0' : 0;
            int sum = n1 + n2 + carry;

            carry = sum / 10;
            sb.append(sum % 10);
        }

        if (carry != 0)
            sb.append('1');

        return sb.reverse().toString();
    }
}
