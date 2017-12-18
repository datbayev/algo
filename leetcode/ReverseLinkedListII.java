package leetcode;

// https://leetcode.com/problems/reverse-linked-list-ii
// 92. Reverse Linked List II

public class ReverseLinkedListII {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode reverseBetween(ListNode head, int n, int m) {
        if (n == m)
            return head;

        if (head == null)
            return null;

        if (head.next == null)
            return head;

        int ind = 1;
        ListNode initial = head;
        ListNode left = head; // (n-1)'st node

        while (ind < n) {
            left = head;
            head = head.next;
            ind++;
        }

        ListNode innerHead = n > 1 ? left.next : left; // next to the left node, or the left node itself (if n = 1)

        ListNode cur = head.next;
        ListNode prev = head;
        prev.next = null;

        while (ind < m) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            ind++;
        }

        if (n > 1) left.next = prev; // update (n-1)'st next node, which is head of reversed list
        innerHead.next = cur; // update next node of reversed list's tail (before reversing it was a head)

        return n > 1 ? initial : prev;
    }
}
