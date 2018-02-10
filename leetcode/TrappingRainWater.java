package leetcode;

// https://leetcode.com/problems/trapping-rain-water/description/
// 42. Trapping Rain Water

public class TrappingRainWater {
    public int trap(int[] h) {
        int n = h.length, sum = 0;
        if (n < 3)
            return 0;

        int[] left = new int[n]; // border on left side for i-th cell
        int[] right = new int[n]; // border on right side for i-th cell

        int max = h[0];
        for (int i = 1; i < n - 1; i++) {
            if (h[i] > max) {
                max = h[i];
                left[i] = -1;
            } else
                left[i] = max;
        }

        max = h[n - 1];
        for (int i = n - 1; i > 0; i--) {
            if (h[i] > max) {
                max = h[i];
                right[i] = -1;
            } else
                right[i] = max;
        }

        for (int i = 1; i < n - 1; i++)
            if (left[i] != -1 && right[i] != -1) // there are borders on both sides for this cell
                sum += Math.min(left[i], right[i]) - h[i];

        return sum;
    }
}
