package leetcode;

// https://leetcode.com/problems/minimize-max-distance-to-gas-station/description/
// 774. Minimize Max Distance to Gas Station

import java.util.Arrays;

public class MinimizeMaxDistanceToGasStation {
    final double EPS = 1E-6;

    public double minmaxGasDist(int[] stations, int k) {
        int n = stations.length;
        int[] d = new int[n - 1];
        Arrays.sort(stations);

        for (int i = 1; i < n; i++)
            d[i - 1] = stations[i] - stations[i - 1];

        Arrays.sort(d);

        double left = 0, right = d[d.length - 1];
        double res = right;

        while (right - left > EPS) {
            int cur = 0;

            // is it possible to get max distance m?
            double m = left + (right - left) / 2;

            for (int i = 0; i < n - 1; i++)
                cur += get(d[i], m);

            if (cur <= k) {
                res = Math.min(res, m);
                right = m;
            } else {
                left = m;
            }
        }

        return right;
    }

    // how many times you need to divide "dist" so that distance is at least is target
    public int get(int dist, double target) {

        if (dist * 1.0 - target <= EPS)
            return 0;

        return (int)(dist * 1.0 / target);
    }
}
