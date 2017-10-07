// https://leetcode.com/problems/add-binary/description/
// 67. Add Binary

class AddBinary {
    public String addBinary(String a, String b) {
        if (a.length() > b.length()) { // let "a" be shorter than "b"
            String temp = a;
            a = b;
            b = temp;
        }
        
        String temp = "";
        for (int i = 0; i < b.length() - a.length(); i++)
            temp += "0";
        
        a = temp + a; // fill forward zeroes to match length of "b"
        
        int extra = 0;
        String res = "";
        
        for (int i = a.length() - 1; i >= 0; i--) {
            char c1 = a.charAt(i);
            char c2 = b.charAt(i);
            
            int cur = (c1 - '0') + (c2 - '0') + extra;
            
            extra = cur / 2;
            res = (cur % 2) + res;
        }
        
        if (extra > 0)
            res = "1" + res;
        
        return res;
    }
}
