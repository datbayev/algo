public class PrivateD2party {

    int[] f;
    int[] map;

    public int dfs(int v) {
        f[v] = 1;
        int x = map[v];
        int currentResult = (x == v || f[x] == 2 ? 1 : 0);

        if (f[x] == 0)
            currentResult += dfs(x) + 1;

        f[v] = 2;

        return currentResult;
    }

    public int getsz(int[] a){
        map = a;
        int n = a.length;
        f = new int[n + 1];

        int result = 0;
        for (int i = 0; i < n; i++)
            if (f[i] == 0)
                result += dfs(i);

        return result;
    }

    public static void main(String[] args) throws Exception {
        int[] a = new int[] {13, 1, 2, 6, 17, 17, 2, 18, 14, 14, 15, 7, 14, 15, 6, 8, 5, 5, 4, 2};
        int res2 = new PrivateD2party().getsz(a);
        System.out.println("Result is " + res2);
    }
}
