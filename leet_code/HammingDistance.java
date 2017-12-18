package leet_code;

// https://leetcode.com/problems/hamming-distance
// 461. Hamming Distance

public class HammingDistance {
    public int hammingDistance(int x, int y) {
        int result = 0;
        
        while (Math.max(x, y) > 0) {
            result += Math.abs(x % 2 - y % 2);
            
            x = x >> 1;
            y = y >> 1;
        }
        
        return result;
    }
}
