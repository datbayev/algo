// https://leetcode.com/problems/sort-list/
// 148. Sort List

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null)
            return head;
        
        if (head.next == null)
            return head;
        
        ListNode slow = head;
        ListNode fast = head;
        
        ListNode prev = head;
        
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        prev.next = null; // split into to sub-lists
        
        ListNode left = sortList(head);
        ListNode right = sortList(slow);
        
        return merge(left, right);
    }
    
    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode l = new ListNode(0), p = l;
        
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                p.next = head1;
                head1 = head1.next;
            } else {
                p.next = head2;
                head2 = head2.next;
            }
            
            p = p.next;
        }
        
        if (head1 != null)
            p.next = head1;

        if (head2 != null) 
            p.next = head2;
        
        return l.next;
    }
}
