// https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii
// 82. Remove Duplicates from Sorted List II

import java.util.*;

public class RemoveDuplicatesSortedListII {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode listToNodes(int[] a) {
        if (a.length == 0)
            return null;
        ListNode res = new ListNode(a[0]);
        ListNode last = res;
        for (int i = 1; i < a.length; i++) {
            last.next = new ListNode(a[i]);
            last = last.next;
        }

        return res;
    }

    public ListNode listToNodes(List<Integer> a) {
        if (a.size() == 0)
            return null;
        ListNode res = new ListNode(a.get(0));
        ListNode last = res;
        for (int i = 1; i < a.size(); i++) {
            last.next = new ListNode(a.get(i));
            last = last.next;
        }

        return res;
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return null;

        if (head.next == null)
            return head;

        List<Integer> list = new ArrayList<Integer>();

        while (head != null) {
            if (head.next != null && head.val == head.next.val) {
                while (head.next != null && head.val == head.next.val)
                    head = head.next;
                head = head.next;
            } else {
                list.add(head.val);
                head = head.next;
            }
        }

        ListNode res = listToNodes(list);
        return res;
    }

    public void printNodes(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public void solve() {
//        int[] list = {1, 2, 3, 3, 4, 4, 5};
        int[] list = {1, 1};
        ListNode node = listToNodes(list);
        ListNode noDups = deleteDuplicates(node);
        printNodes(noDups);
    }

    public static void main(String[] args) {
        new RemoveDuplicatesSortedListII().solve();
    }
}
