// https://leetcode.com/problems/sum-of-square-numbers/description/
// 633. Sum of Square Numbers

class SumOfSquareNumbers {
    public boolean judgeSquareSum(int c) {
        if (c < 3)
            return true;
        List<Integer> list = new ArrayList();
        Set<Integer> set = new HashSet();
        
        int i = 1;
        set.add(c);
        while (c / i >= i) {
            list.add(i * i);
            set.add(c - i * i);
            if (set.contains(i * i))
                return true;
            
            i++;
        }
        
        return false;
    }
}
