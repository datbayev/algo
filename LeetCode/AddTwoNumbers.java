// https://leetcode.com/problems/add-two-numbers/description/
// 2. Add Two Numbers

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class AddTwoNumbers {
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {        
        ListNode head1 = l1;
        ListNode head2 = l2;
        
        int buf = 0;
        ListNode res = null;
        ListNode prev = null;
        
        while (head1 != null && head2 != null) {
            
            int curVal = head1.val + head2.val + buf;
            
            if (curVal > 9) {
                buf = 1;
                curVal -= 10;
            } else
                buf = 0;
            
            ListNode cur = new ListNode(curVal);
            
            if (prev != null)
                prev.next = cur;
            
            if (res == null)
                res = cur;
            
            prev = cur;
            
            head1 = head1.next;
            head2 = head2.next;
        }
        
        if (head1 != null || head2 != null) {
            ListNode tail = head1 != null ? head1 : head2;
            
            while (tail != null) {
                int curVal = tail.val + buf;
                if (curVal > 9) {
                    curVal = 0;
                    buf = 1;
                } else
                    buf = 0;
                
                ListNode cur = new ListNode(curVal);
                
                tail = tail.next;
                prev.next = cur;
                prev = cur;
            }
        }
        
        if (buf == 1) {
            ListNode last = new ListNode(1);
            prev.next = last;
        }
        
        return res;
    }
}
