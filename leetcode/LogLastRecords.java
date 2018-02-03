package leetcode;

import java.util.*;

public class LogLastRecords {
    int n, index = 0;
    public List<Integer> arr;

    public LogLastRecords(int n) {
        this.n = n;
        arr = new ArrayList();
    }

    public void record(int record) {
        if (arr.size() == n)
            arr.set(index, record);
        else
            arr.add(record);

        index = (index + 1) % n;
    }

    public int getLast(int i) {
        return arr.get((index - i + n) % n);
    }

    public static void main(String[] args) {
        LogLastRecords l = new LogLastRecords(4);
        l.record(1);
        l.record(2);
        l.record(3);
        l.record(4);
        l.record(5);
        l.record(6);
        l.record(7);

        for (int x : l.arr) System.out.print(x + " ");
        System.out.println();

        System.out.println(l.getLast(1));
        System.out.println(l.getLast(2));
        System.out.println(l.getLast(3));
        System.out.println(l.getLast(4));
    }
}
