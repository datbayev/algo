package leetcode;

// https://leetcode.com/problems/heaters/description/
// 475. Heaters

import java.util.TreeSet;

public class Heaters {
    public int findRadius(int[] houses, int[] heaters) {
        TreeSet<Integer> set = new TreeSet();
        int res = 0;

        for (int heater : heaters)
            set.add(heater);

        for (int house : houses) {
            Integer upperHeater = set.ceiling(house);
            Integer lowerHeater = set.floor(house);

            int rightDist = (upperHeater == null ? Integer.MAX_VALUE : upperHeater - house);
            int leftDist = (lowerHeater == null ? Integer.MAX_VALUE : house - lowerHeater);

            res = Math.max(res, Math.min(leftDist, rightDist));
        }

        return res;
    }
}
