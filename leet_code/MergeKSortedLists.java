package leet_code;

// https://leetcode.com/problems/merge-k-sorted-lists/description/
// 23. Merge k Sorted Lists

class MergeKSortedLists {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode merge(int count, ListNode h1, ListNode h2) {
        if (h1 == null)
            return h2;
        
        if (h2 == null)
            return h1;
        
        ListNode res = null;
        ListNode cur = null;
        
        while (h1 != null && h2 != null) {
            if (h1.val < h2.val) {
                if (res == null) {
                    res = h1;
                    cur = res;
                } else {
                    cur.next = h1;
                    cur = cur.next;
                }

                h1 = h1.next;
            } else {
                if (res == null) {
                    res = h2;
                    cur = res;
                } else {
                    cur.next = h2;
                    cur = cur.next;
                }

                h2 = h2.next;
            }
        }
        
        if (h1 == null)
            cur.next = h2;
        
        if (h2 == null)
            cur.next = h1;
        
        return res;
    }
    
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0)
            return null;
        
        if (lists.length == 1)
            return lists[0];
        
        int k = lists.length;
        int count = 0;
        ListNode cur = lists[0];
        for (int size = 1; size < k; size *= 2) {
            for (int lo = 0; lo < k - size; lo += 2 * size) {
                int ind1 = lo;
                int ind2 = Math.min(k - 1, lo + 2 * size - 1);
                lists[ind1] = merge(count++, lists[ind1], lists[ind2]);
                lists[ind2] = lists[ind1];
            }
        }
        
        return lists[0];
    }
}
