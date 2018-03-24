package leetcode;

// https://leetcode.com/problems/add-binary/description/
// 67. Add Binary

class AddBinary {
    public String addBinary(String a, String b) {
        // let a be longer
        if (a.length() < b.length()) {
            String temp = a;
            a = b;
            b = temp;
        }

        StringBuilder res = new StringBuilder();
        int carry = 0;
        for (int i = b.length() - 1, j = a.length() - 1; i >= 0 && j >= 0; i--, j--) {
            int c1 = b.charAt(i) - '0';
            int c2 = a.charAt(j) - '0';
            int total = c1 + c2 + carry;
            res.append(total % 2);
            carry = total / 2;
        }

        for (int i = a.length() - b.length() - 1; i >= 0; i--) {
            int c1 = a.charAt(i) - '0';
            int total = c1 + carry;
            res.append(total % 2);
            carry = total / 2;
        }

        if (carry > 0)
            res.append(1);

        res.reverse();

        return res.toString();
    }
}
