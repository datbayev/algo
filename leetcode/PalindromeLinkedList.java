package leetcode;

// https://leetcode.com/problems/palindrome-linked-list
// 234. Palindrome Linked List

import java.util.*;

class PalindromeLinkedList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public boolean isPalindrome(ListNode head) {
        int len = 0;
        ListNode x = head;
        while (x != null) {
            len++;
            x = x.next;
        }
        
        if (len <= 1)
            return true;
        
        Stack<Integer> stack = new Stack();
        ListNode cur = head;
        for (int i = 0; i < len / 2; i++) {
            stack.push(cur.val);
            cur = cur.next;
        }
        
        if (len % 2 == 1) // odd length
            cur = cur.next;
        
        while (cur != null) {
            if (cur.val != stack.pop())
                return false;
            cur = cur.next;
        }
        
        return true;
    }
}
