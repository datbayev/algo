public class NumberOfOnes {
    public static int numberOfOnes(int x) {
        int res = 0;
        while (x != 0) {
            x = x & (x - 1);
            res++;
        }
        return res;
    }
}
