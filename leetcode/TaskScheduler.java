package leetcode;

// https://leetcode.com/problems/task-scheduler/description/
// 621. Task Scheduler

import java.util.*;

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        if (tasks.length < 2)
            return tasks.length;

        int res = 0;
        int[] count = new int[26];

        Queue<Operation> pq = new PriorityQueue(26, new Comparator<Operation>() {
            @Override
            public int compare(Operation op1, Operation op2) {
                return op2.count != op1.count ? op2.count - op1.count : op1.ch - op2.ch;
            }
        });

        for (char c : tasks)
            count[c - 'A']++;

        for (char c = 'A'; c <= 'Z'; c++)
            if (count[c - 'A'] > 0)
                pq.add(new Operation(c, count[c - 'A']));

        while (!pq.isEmpty()) {
            int k = n + 1;
            List<Operation> list = new ArrayList();

            while (k > 0 && !pq.isEmpty()) {
                Operation cur = pq.poll();
                cur.count--;
                list.add(cur);

                k--;
                res++;
            }

            for (Operation cur : list)
                if (cur.count > 0)
                    pq.add(cur);

            if (pq.size() == 0)
                break;

            res += k;
        }

        return res;
    }

    class Operation {
        char ch;
        int count;

        public Operation(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }
}
