public class OkonomiyakiShop {
    public int count(int[] osize, int K) {
        int n = osize.length;
        int res = 0;
        for (int i = 0; i < n - 1; i++)
            for (int j = i + 1; j < n; j++)
                if (Math.abs(osize[i] - osize[j]) <= K)
                    res++;
        return res;
    }
}
