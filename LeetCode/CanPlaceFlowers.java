// https://leetcode.com/problems/can-place-flowers/description/
// 605. Can Place Flowers

class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0)
            return true;
        
        int len = flowerbed.length;
        for (int i = 0; i < len; i++)
            if (flowerbed[i] == 1) {
                if (i > 0)
                    flowerbed[i - 1] = 2;
                if (i < len - 1)
                    flowerbed[i + 1] = 2;
            }
        
        for (int i = 0; i < len; i++) {
            if (flowerbed[i] == 0) {
                n--;
                if (n == 0)
                    return true;
                
                if (i < len - 1)
                    flowerbed[i + 1] = 2;
            }
        }
        
        return false;
    }
}
