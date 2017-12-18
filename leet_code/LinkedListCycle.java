package leet_code;

// https://leetcode.com/problems/linked-list-cycle/description/
// 141. Linked List Cycle

public class LinkedListCycle {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        if (head == null)
            return false;
        
        if (head.next == null)
            return false;
        
        ListNode slow = head;
        ListNode fast = head;
        
        while (slow != null && fast != null) {
            slow = slow.next;
            
            if (fast.next != null)
                fast = fast.next.next;
            else 
                fast = null;
            
            if (slow == fast)
                return true;
        }
        
        return false;
    }
}
