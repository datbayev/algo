public class CountryGroup {

    public int solve(int[] a) {
        int i = 0;
        int total = 0;
        boolean inconsistent = false;
        while (i < a.length && !inconsistent) {
            int cur = a[i];
            for (int j = i; j < i + cur; j++) {
                if (j >= a.length || a[j] != cur) {
                    inconsistent = true;
                    break;
                }
            }
            total++;
            i += cur;
        }
        return inconsistent ? -1 : total;
    }

    public static void main(String[] args) {
        int[] a = new int[] {4,4,4,4,1,1,2,2,3,3,3};
        int res = new CountryGroup().solve(a);
        System.out.println("Result=" + res);
    }
}
