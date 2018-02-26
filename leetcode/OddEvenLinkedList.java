package leetcode;

// https://leetcode.com/problems/odd-even-linked-list/description/
// 328. Odd Even Linked List

public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null)
            return head;

        ListNode first = head;
        ListNode second = head.next;

        ListNode headSecond = second;

        while (second != null && second.next != null) {
            first.next = second.next;
            second.next = second.next.next;

            first = first.next;
            second = second.next;
        }

        first.next = headSecond; // last link between odd and even nodes

        return head;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
