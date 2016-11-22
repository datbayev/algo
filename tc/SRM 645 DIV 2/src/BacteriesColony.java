public class BacteriesColony {

    public int[] performTheExperiment(int[] colonies) {

        int count = 1;
        while (count != 0) {
            int[] copy = colonies.clone();
            count = 0;
            for (int i = 1; i < colonies.length - 1; i++) {
                if (colonies[i - 1] > colonies[i] && colonies[i + 1] > colonies[i]) {
                    copy[i]++;
                    count++;
                } else if (colonies[i] > colonies[i - 1] && colonies[i] > colonies[i + 1]) {
                    copy[i]--;
                    count++;
                }
            }
            colonies = copy.clone();
        }
        return colonies;
    }

    public void solve() {
        int[] colonies = new int[] {78, 34, 3, 54, 44, 99 };
        int[] res = performTheExperiment(colonies);
        for (int i = 0; i < res.length; i++) System.out.print(res[i] + " ");
    }

    public static void main(String[] args) {
        new BacteriesColony().solve();
    }
}
