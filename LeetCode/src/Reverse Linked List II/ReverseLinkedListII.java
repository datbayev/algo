/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class ReverseLinkedListII {
    public static Node reverseBetween(Node head, int n, int m) {
        if (n == m)
            return head;

        if (head == null)
            return null;

        if (head.next == null)
            return head;

        int ind = 1;
        Node initial = head;
        Node left = head; // (n-1)'st node

        while (ind < n) {
            left = head;
            head = head.next;
            ind++;
        }

        Node innerHead = n > 1 ? left.next : left; // next to the left node, or the left node itself (if n = 1)

        Node cur = head.next;
        Node prev = head;
        prev.next = null;

        while (ind < m) {
            Node next = cur.next;
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
