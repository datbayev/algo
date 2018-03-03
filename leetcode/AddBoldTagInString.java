package leetcode;

// https://leetcode.com/problems/add-bold-tag-in-string/description/
// 616. Add Bold Tag in String

import java.util.*;

public class AddBoldTagInString {
    public String addBoldTag(String s, String[] dict) {
        // create list of intervals
        // merge intervals
        // go backwards in string and add tags

        List<Interval> intervals = getIntervals(s, dict);
        intervals.sort((a, b) -> a.left != b.left ? Integer.compare(a.left, b.left) : Integer.compare(a.right, b.right));
        intervals = mergeIntervals(intervals);

        StringBuffer sb = new StringBuffer(s);
        addTags(sb, intervals);

        return sb.toString();
    }

    private void addTags(StringBuffer sb, List<Interval> list) {
        for (int i = list.size() - 1; i >= 0; i--) {
            int left = list.get(i).left;
            int right = list.get(i).right;

            sb.insert(right, "</b>");
            sb.insert(left, "<b>");
        }
    }

    private List<Interval> mergeIntervals(List<Interval> list) {
        List<Interval> res = new ArrayList<>();
        int i = 0;
        while (i < list.size()) {
            int curmax = list.get(i).right;
            int j = i + 1;
            while (j < list.size() && list.get(j).left <= curmax)
                curmax = Math.max(curmax, list.get(j++).right);

            res.add(new Interval(list.get(i).left, curmax));
            i = j;
        }

        return res;
    }

    private List<Interval> getIntervals(String s, String[] dict) {
        List<Interval> res = new ArrayList<>();
        for (String word : dict) {
            int ind = s.indexOf(word);
            while (ind >= 0) {
                res.add(new Interval(ind, ind + word.length()));
                ind = s.indexOf(word, ind + 1);
            }
        }

        return res;
    }

    class Interval {
        int left, right;
        Interval(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }
}
