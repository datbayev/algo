package leetcode;

// https://leetcode.com/problems/minimize-max-distance-to-gas-station/description/
// 774. Minimize Max Distance to Gas Station

public class MinimizeMaxDistanceToGasStation {
    final double EPS = 1e-6;

    public double minmaxGasDist(int[] stations, int k) {
        int n = stations.length;
        double left = 0, right = 1e8;

        while (right - left > EPS) {
            int cur = 0;

            // is it possible to get max distance m?
            double m = left + (right - left) / 2;

            for (int i = 1; i < n; i++)
                cur += (int)(Math.abs(stations[i] - stations[i - 1]) / m);

            if (cur <= k)
                right = m;
            else
                left = m;
        }

        return right;
    }
}
