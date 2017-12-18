package leetcode;

// https://leetcode.com/problems/ugly-number-ii
// 264. Ugly Number II

public class UglyNumberII {
    public int nthUglyNumber(int n) {
        int[] k = new int[n];
        k[0] = 1;
        int t2 = 0;
        int t3 = 0;
        int t5 = 0;

        for (int i = 1; i < n; i++) {
            k[i] = Math.min(Math.min(k[t2]*2, k[t3]*3), k[t5]*5);

            if (k[i] == k[t2] * 2) t2++;
            if (k[i] == k[t3] * 3) t3++;
            if (k[i] == k[t5] * 5) t5++;
        }

        return k[n - 1];
    }

    public static void main(String[] args) {
        UglyNumberII s = new UglyNumberII();
        System.out.println(s.nthUglyNumber(1352));
    }
}
