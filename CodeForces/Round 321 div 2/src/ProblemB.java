import java.io.PrintWriter;
import java.util.*;

public class ProblemB {

    List<Friend> friends;

    class Friend {
        long money;
        long level;

        public Friend(int money, int level) {
            this.money = money;
            this.level = level;
        }
    }

    Comparator<Friend> friendComparator = new Comparator<Friend>() {
        public int compare(Friend o1, Friend o2) {
            if (o1.money > o2.money)
                return 1;

            if (o1.money < o2.money)
                return -1;

            return 0;
        }
    };

    public void solve() {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        friends = new ArrayList<Friend>();
        int n = in.nextInt();
        int d = in.nextInt();

        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            Friend newFriend = new Friend(x, y);
            friends.add(newFriend);
        }

        Collections.sort(friends, friendComparator);

        long maxLevel = 0;
        long curLevel = 0;
        int j = 0;

        for (int i = 0; i < n; i++) {
            while (j < n && friends.get(j).money - friends.get(i).money < d) {
                curLevel += friends.get(j).level;
                j++;
            }
            maxLevel = Math.max(maxLevel, curLevel);

            curLevel -= friends.get(i).level;
        }
        out.println(maxLevel);
        out.close();
    }


    public static void main(String[] args) {
        new ProblemB().solve();
    }
}
