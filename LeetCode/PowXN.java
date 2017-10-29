// https://leetcode.com/problems/powx-n/description/
// 50. Pow(x, n)

class PowXN {
    Map<Integer, Double> map;
    
    public double myPow(double x, int n) {
        if (n == 0)
            return 1.0;
        
        double res = 1.0;
        
        map = new HashMap();
        
        if (n > 0)
            res = pow(x, n);
        else if (n < 0) {
            res = pow(x, -1 * (n + 1)) * x;
            res = 1.0 / res;
        }
        
        return res;
    }
    
    public double pow(double x, int n) {
        if (map.containsKey(n))
            return map.get(n);
        
        if (n == 0)
            return 1.0;
        
        if (n == 1)
            return x;
        
        if (n % 2 == 0) {
            if (!map.containsKey(n))
                map.put(n, pow(x, n / 2) * pow(x, n / 2));
            
            return map.get(n);
        } else {
            if (!map.containsKey(n))
                map.put(n, pow(x, n / 2) * pow(x, (n / 2) + 1));
            
            return map.get(n);
        }
    }
}
