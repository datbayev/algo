package leetcode;

// https://leetcode.com/problems/intersection-of-two-linked-lists
// 160. Intersection of Two Linked Lists

public class Intersect2LinkedLists {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // get size of 1st linked list
        int size1 = 0;
        ListNode head1 = headA;
        while (head1 != null) {
            size1++;
            head1 = head1.next;
        }

        // get size of 2nd linked list
        int size2 = 0;
        ListNode head2 = headB;
        while (head2 != null) {
            size2++;
            head2 = head2.next;
        }

        if (size1 == 0 || size2 == 0)
            return null;

        ListNode node1 = headA;
        ListNode node2 = headB;
        int s1 = size1;
        int s2 = size2;

        // put longer linked list on first place
        if (size2 > size1) {
            ListNode tempNode = node1;
            node1 = node2;
            node2 = tempNode;
            int t = s1;
            s1 = s2;
            s2 = t;
        }

        // shift longer linkedlist right while sizes are not equal
        while (s1 != s2 && node1 != null) {
            node1 = node1.next;
            s1--;
        }

        // move right until we find intersection or get to the end
        while (node1 != node2 && node1 != null && node2 != null) {
            node1 = node1.next;
            node2 = node2.next;
        }

        return node1;
    }
}
