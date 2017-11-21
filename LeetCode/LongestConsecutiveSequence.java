// https://leetcode.com/problems/longest-consecutive-sequence/description/
// 128. Longest Consecutive Sequence

class LongestConsecutiveSequence {
    Set<Integer> set;
    Map<Integer, Node> map;
    Set<String> used;
    int maxLen;
    
    public int longestConsecutive(int[] nums) {
        if (nums.length < 2)
            return nums.length;
        
        maxLen = 1;
        map = new HashMap();
        set = new HashSet();
        used = new HashSet();
        
        for (int x : nums) {
            set.add(x);
            map.put(x, new Node());
        }
        
        for (int x : nums) {
            if (set.contains(x - 1) && !used.contains(ok(x, x - 1))) {
                unite(x, x - 1);
                used.add(ok(x, x - 1));
                used.add(ok(x - 1, x));
            }
            
            if (set.contains(x + 1) && !used.contains(ok(x, x + 1))) {
                unite(x, x + 1);
                used.add(ok(x, x + 1));
                used.add(ok(x + 1, x));
            }
        }
        
        return maxLen;
    }
    
    public String ok(int x, int y) {
        return String.valueOf(x) + "-" + String.valueOf(y);
    }
    
    public void unite(int x, int y) {
        int min = Math.min(x, y);
        int max = Math.max(x, y);
        
        Node minNode = map.get(min);
        Node maxNode = map.get(max);
        
        minNode.parent = maxNode;
        while (maxNode.parent != null)
            maxNode = maxNode.parent;
        
        maxNode.val += minNode.val;
        
        maxLen = Math.max(maxLen, maxNode.val);
    }
    
    class Node {
        Node parent;
        int val;
        
        public Node() {
            this.val = 1; 
        }
    }
}
