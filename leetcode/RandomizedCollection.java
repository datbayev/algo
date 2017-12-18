package leetcode;

// https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed/description/
// 381. Insert Delete GetRandom O(1) - Duplicates allowed

import java.util.*;

class RandomizedCollection {
    Map<Integer, Set<Integer>> pos;
    List<Integer> list;
    Random rand;

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        list = new ArrayList();
        pos = new HashMap();
        rand = new Random();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean isNew = false;
        
        if (!pos.containsKey(val)) {
            isNew = true;
            pos.put(val, new HashSet());
        }
        
        pos.get(val).add(list.size());
        list.add(val);
        return isNew;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!pos.containsKey(val))
            return false;
        
        int idx = pos.get(val).iterator().next(); // last position of 4
        pos.get(val).remove(idx);
        
        if (idx < list.size() - 1) { // just cut the last element in general list and positions list
            int tmp = list.get(list.size() - 1);
            list.set(idx, tmp);
            pos.get(tmp).remove(list.size() - 1);
            pos.get(tmp).add(idx);
        }
        
        list.remove(list.size() - 1);
        
        if (pos.get(val).isEmpty()) // clean-up if no elements left
            pos.remove(val);
        
        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        int n = rand.nextInt(list.size());
        return list.get(n);
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
