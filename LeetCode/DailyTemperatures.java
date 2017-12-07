// https://leetcode.com/problems/daily-temperatures/description/
// 739. Daily Temperatures

class DailyTemperatures {
    public int[] dailyTemperatures(int[] t) {
        Map<Integer, List<Integer>> map = new HashMap();
        int n = t.length;
        int[] res = new int[n];
        
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(t[i]))
                map.put(t[i], new ArrayList());
            
            map.get(t[i]).add(i);
        }
        
        for (int i = 30; i <= 100; i++) {
            List<Integer> curList = map.get(i);
            if (curList != null)
                Collections.sort(curList);
        }
        
        for (int i = 0; i < n; i++) {
            int cur = t[i];
            int minK = Integer.MAX_VALUE;
            for (int j = cur + 1; j <= 100; j++) {
                if (map.containsKey(j)) {
                    List<Integer> curList = map.get(j);
                    int k = binSearchMinMax(curList, i);

                    if (k != -1) {
                        minK = Math.min(minK, curList.get(k) - i);
                    }
                }
            }
            res[i] = minK == Integer.MAX_VALUE ? 0 : minK;
        }
        
        return res;
    }
    
    public int binSearchMinMax(List<Integer> list, int x) {
        if (x >= list.get(list.size() - 1))
            return -1;
        
        int n = list.size();
        if (n == 1)
            return list.get(0) > x ? 0 : -1;
        
        int l = 0, r = n - 1, right = Integer.MAX_VALUE, left = Integer.MIN_VALUE;
        while (l < r) {
            int m = l + (r - l) / 2;
            int cur = list.get(m);
            
            if (cur > x) {
                r = m;
                right = m;
            } else if (cur <= x) {
                l = m + 1;
                left = m;
            }
        }
        
        if (right != Integer.MAX_VALUE)
            return right;
        
        if (left != Integer.MIN_VALUE && left < list.size() - 1)
            return left + 1;
        
        return -1;
    }
}
