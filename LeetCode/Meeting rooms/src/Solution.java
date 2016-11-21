import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class Solution {

    class Meeting {
        int begin;
        int end;

        public Meeting(int begin, int end) {
            this.begin = begin;
            this.end = end;
        }

        public String toString() {
            return String.format("%s-%s", this.begin, this.end);
        }
    }

    public int getMinRooms(List<Meeting> meetings) {
        int maxCount = 1;

        for (int i = 0; i < meetings.size(); i++) {
            Meeting currentMeeting = meetings.get(i);
            int count = 1;
            int maxLeft = currentMeeting.begin;
            int minRight = currentMeeting.end;

            for (int j = 0; j < meetings.size(); j++) {
                if (i == j) // skip comparison of meeting with itself
                    continue;

                Meeting next = meetings.get(j);
                if (maxLeft < next.end && next.begin < minRight) {
                    maxLeft = Math.max(maxLeft, next.begin);
                    minRight = Math.min(minRight, next.end);
                    count++;
                }
            }
            if (maxCount < count)
                maxCount = count;
        }

        return maxCount;
    }

    public void solve() throws FileNotFoundException {
        Scanner in = new Scanner(new File("input.txt"));
        PrintWriter out = new PrintWriter(System.out);
        int n = in.nextInt();
        List<Meeting> meetings = new ArrayList<Meeting>();
        for (int i = 0; i < n; i++) {
            int begin = in.nextInt();
            int end = in.nextInt();
            Meeting newMeeting = new Meeting(begin, end);
            meetings.add(newMeeting);
        }
        int res = getMinRooms(meetings);
        out.print(res);
        out.close();
    }

    public static void main(String[] args) throws FileNotFoundException{
        new Solution().solve();
    }
}
