// https://leetcode.com/problems/counting-bits/description/
// 338. Counting Bits

class CountingBits {
    public int[] countBits(int num) {
        if (num == 0)
            return new int[]{0};
        
        int[] dp = new int[num + 1];
        dp[0] = 0;
        dp[1] = 1;
        
        for (int i = 2; i <= num; i++) {
            if ((i & (i - 1)) == 0) { // if this is a power of two, then it has only 1 bit
                dp[i] = 1;
                continue;
            }
            
            int power = (int)(Math.ceil(Math.log(i) / Math.log(2)));
            int closestSmallerPowerOfTwo = (int)Math.pow(2, power - 1);
            
            dp[i] = dp[closestSmallerPowerOfTwo] + dp[i - closestSmallerPowerOfTwo];
        }
        
        return dp;
    }
}
