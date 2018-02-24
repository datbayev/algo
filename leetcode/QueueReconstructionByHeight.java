package leetcode;

// https://leetcode.com/problems/queue-reconstruction-by-height/description/
// 406. Queue Reconstruction by Height

public class QueueReconstructionByHeight {
    public int[][] reconstructQueue(int[][] people) {
        int[] count = new int[people.length];

        for (int i = 0; i < people.length; i++)
            count[i] = people[i][1];

        int i = 0;
        while (i < people.length) {
            // find lowest person with count=0
            int min = -1;
            int idx = i;
            int j = i;

            while (j < people.length) {

                if (count[j] == 0 && (min == -1 || people[j][0] < min)) {
                    min = people[j][0]; // the shorter guy
                    idx = j; // on different place
                }

                j++;
            }

            // put the shortest guy in front
            int temp = people[i][0]; people[i][0] = people[idx][0]; people[idx][0] = temp;
            temp = people[i][1]; people[i][1] = people[idx][1]; people[idx][1] = temp;
            temp = count[i]; count[i] = count[idx]; count[idx] = temp;

            for (j = i + 1; j < people.length; j++)
                if (people[j][0] <= min && count[j] > 0)
                    count[j]--;

            i++;
        }

        return people;
    }
}
