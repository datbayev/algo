package leetcode;

// https://leetcode.com/problems/paint-fence/
// 276. Paint Fence

public class PaintFence {
    public int numWays(int n, int k) {
        if (n == 0)
            return 0;

        if (n == 1)
            return k;

        int same = k;
        int diff = k * (k - 1);

        for (int i = 2; i < n; i++) {
            int temp = diff;
            diff = (same + diff) * (k - 1);
            same = temp;
        }

        return same + diff;
    }
}
