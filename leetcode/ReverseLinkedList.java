package leetcode;

// https://leetcode.com/problems/reverse-linked-list
// 206. Reverse Linked List

public class ReverseLinkedList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null)
            return null;
        if (head.next == null)
            return head;

        ListNode cur = head.next;
        ListNode prev = head;
        prev.next = null; // new tail

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;
    }
}
