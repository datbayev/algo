package leetcode;

// https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
// Remove Nth Node From End of List

public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null)
            return null;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode slow = dummy;
        ListNode fast = dummy;

        for (int i = 0; i < n; i++)
            fast = fast.next;

        // the tricky part here is that "fast" node is "n" steps ahead of "slow"
        // and once fast reaches end of the list, "slow" will be on "n"-th position from end

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return dummy.next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
