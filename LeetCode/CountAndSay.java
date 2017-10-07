// https://leetcode.com/problems/count-and-say
// 38. Count and Say

class CountAndSay {
    public String countAndSay(int n) {
        if (n == 1)
            return "1";
        
        String prev = countAndSay(n - 1);
        
        int i = 0;
        String res = "";
        while (i < prev.length()) {
            int count = 1;
            int num = prev.charAt(i) - '0';
            while (i < prev.length() - 1 && prev.charAt(i) == prev.charAt(i + 1)) {
                count++;
                i++;
            }
            
            i++;
            res = String.format("%s%d%d", res, count, num);
        }
        
        return res;
    }
}
