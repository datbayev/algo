package leetcode;

// https://leetcode.com/problems/cheapest-flights-within-k-stops/description/
// 787. Cheapest Flights Within K Stops

import java.util.*;

public class CheapestFlightsWithinKStops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[] dist = new int[n]; // distance from src to all nodes in K stops
        int[] prev = new int[n]; // distance from src to all nodes in K-1 stops

        Arrays.fill(dist, Integer.MAX_VALUE / 2); // very big number, but the max, not to hit the boundaries
        Arrays.fill(prev, Integer.MAX_VALUE / 2);

        dist[src] = 0;
        prev[src] = 0;

        for (int i = 0; i <= K; i++) {
            for (int[] flight : flights)
                dist[flight[1]] = Math.min(dist[flight[1]], flight[2] + prev[flight[0]]);

            prev = dist;
        }

        return dist[dst] < Integer.MAX_VALUE / 2 ? dist[dst] : -1;
    }
}
