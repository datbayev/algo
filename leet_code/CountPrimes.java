package leet_code;

// https://leetcode.com/problems/count-primes/
// 204. Count Primes

class CountPrimes {
    public int countPrimes(int n) {
        int count = 0;
        
        int[] p = new int[n + 1];
        int cur = 2;
        while (cur < n) {
            int i = cur;
            if (p[i] == 0) {
                count++;
                while (i < n) {
                    p[i] = 1;
                    i+= cur;
                }
            }
            
            cur++;
        }
        
        return count;
    }
}
