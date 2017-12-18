package leet_code;

// https://leetcode.com/problems/add-two-numbers-ii/description/
// 445. Add Two Numbers II

import java.util.Stack;

class AddTwoNumbersII {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack();
        Stack<Integer> stack2 = new Stack();
        
        ListNode head1 = l1;
        while (head1 != null) {
            stack1.push(head1.val);
            head1 = head1.next;
        }
        
        ListNode head2 = l2;
        while (head2 != null) {
            stack2.push(head2.val);
            head2 = head2.next;
        }
        
        int x = 0;
        ListNode prev = null;
        while (!stack1.isEmpty() || !stack2.isEmpty() || x > 0) {
            if (!stack1.isEmpty())
                x += stack1.pop();
            
            if (!stack2.isEmpty())
                x += stack2.pop();
            
            ListNode cur = new ListNode(x % 10);
            cur.next = prev;
            prev = cur;
            x /= 10;
        }
        
        return prev;
    }
}
