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
}
