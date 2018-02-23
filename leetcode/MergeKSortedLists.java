package leetcode;

// https://leetcode.com/problems/merge-k-sorted-lists/description/
// 23. Merge k Sorted Lists

import java.util.*;

class MergeKSortedLists {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;

        if (l2 == null)
            return l1;

        if (l1.val < l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        } else {
            l2.next = merge(l1, l2.next);
            return l2;
        }
    }
    
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0)
            return null;
        
        if (lists.length == 1)
            return lists[0];
        
        int k = lists.length;
        for (int size = 1; size < k; size *= 2) {
            for (int lo = 0; lo < k - size; lo += 2 * size) {
                int ind2 = Math.min(k - 1, lo + 2 * size - 1);
                lists[lo] = merge(lists[lo], lists[ind2]);
                lists[ind2] = lists[lo];
            }
        }
        
        return lists[0];
    }

    public ListNode mergeKListsHeaps(ListNode[] lists) {
        if (lists.length == 0)
            return null;

        PriorityQueue<Item> pq = new PriorityQueue<>(lists.length, (o1, o2) -> Integer.compare(o1.val, o2.val));

        for (int i = 0; i < lists.length; i++)
            if (lists[i] != null)
                pq.add(new Item(lists[i].val, i));

        ListNode root = null;
        ListNode node = null;

        while (!pq.isEmpty()) {
            Item cur = pq.poll();
            ListNode next = new ListNode(lists[cur.idx].val);

            if (root == null) {
                root = next;
                node = root;
            } else {
                node.next = next;
                node = node.next;
            }

            lists[cur.idx] = lists[cur.idx].next;

            if (lists[cur.idx] != null)
                pq.add(new Item(lists[cur.idx].val, cur.idx));
        }

        return root;
    }

    class Item {
        int val;
        int idx;

        Item(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }
}
