package leetcode;

// https://leetcode.com/problems/merge-two-sorted-lists/description/
// 21. Merge Two Sorted Lists

class MergeTwoSortedLists {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        
        if (l2 == null)
            return l1;
        
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
