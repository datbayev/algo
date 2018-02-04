package leetcode;

// https://leetcode.com/problems/k-empty-slots/description/
// 683. K Empty Slots

import java.util.ArrayDeque;

public class KEmptySlots {

    public int kEmptySlots(int[] flowers, int k) {
        if (k >= flowers.length - 1)
            return -1;

        ArrayDeque<Integer> window = new ArrayDeque();
        int n = flowers.length, res = n;
        int[] days = new int[n];

        for (int i = 0; i < n; i++) // inverse days when flowers blooms
            days[flowers[i] - 1] = i + 1;

        for (int i = 0; i < n; i++) {
            int cur = days[i];

            while (!window.isEmpty() && window.peekLast() > cur)
                window.pollLast();

            window.add(cur);

            // have enough elements in window to slide it to the right
            if (i >= k && i < n - 1) {
                if (days[i - k] == window.peekFirst())
                    window.pollFirst();

                if (k == 0 || window.peekFirst() > days[i - k] && window.peekFirst() > days[i + 1])
                    res = Math.min(res, Math.max(days[i + 1], days[i - k]));
            }
        }

        return res == n ? -1 : res;
    }
}
