package leetcode;

// https://leetcode.com/problems/binary-watch/description/
// 401. Binary Watch

import java.util.*;

public class BinaryWatch {
    public List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<>();
        rec(0, num, new ArrayList<Integer>(), res);
        return res;
    }

    private void rec(int index, int n, ArrayList<Integer> list, List<String> res) {
        if (list.size() == n) {
            add(res, list);
            return;
        }

        for (int i = index; i < 10; i++) {
            list.add(i);
            rec(i + 1, n, list, res);
            list.remove(list.size() - 1);
        }
    }

    // bitset to time string
    private void add(List<String> res, List<Integer> list) {
        int h = 0, m = 0;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) < 4)
                h += 1 << list.get(i);
            else
                m += 1 << (list.get(i) - 4);
        }

        if (h > 11 || m > 59)
            return;

        String time = String.format("%d:%02d", h, m);
        res.add(time);
    }
}
