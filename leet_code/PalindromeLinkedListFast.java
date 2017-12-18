package leet_code;

// https://leetcode.com/problems/palindrome-linked-list
// 234. Palindrome Linked List

class PalindromeLinkedListFast {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || (head != null && head.next == null))
            return true;
        
        ListNode middleNode = getMiddleNode(head); // find the middle of the whole list
        ListNode newNode = reverseList(middleNode.next); // reverse second half of the list
        middleNode.next = null; // cut the rope, split into two separate linked lists
        
        while (newNode != null && head != null) { // compare first half and reversed second half
            if (newNode.val != head.val)
                return false;
            
            newNode = newNode.next;
            head = head.next;
        }
        
        return true;
    }
    
    private ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode prev = null;
        
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        
        return prev;
    }
    
    private ListNode getMiddleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while (slow.next != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
}
