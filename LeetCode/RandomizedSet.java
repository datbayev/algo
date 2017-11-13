// https://leetcode.com/problems/insert-delete-getrandom-o1/description/
// 380. Insert Delete GetRandom O(1)

class RandomizedSet {
    Map<Integer, Integer> keys;
    Map<Integer, Integer> values;
    Random rand;
    int size;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        keys = new HashMap();
        values = new HashMap();
        rand = new Random();
        size = 0;
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (keys.containsKey(val)) {
            return false;
        }
        
        keys.put(val, size);
        values.put(size, val);
        
        size = keys.size();
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!keys.containsKey(val))
            return false;
        
        int pos = keys.get(val);
        int latestVal = values.get(size - 1);
        keys.put(latestVal, pos);
        
        values.remove(size - 1);
        values.put(pos, latestVal);
        keys.remove(val);
        
        size = keys.size();
        
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int n = rand.nextInt(size);

        return values.get(n);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
