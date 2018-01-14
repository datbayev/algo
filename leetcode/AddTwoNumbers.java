package leetcode;

// https://leetcode.com/problems/add-two-numbers/description/
// 2. Add Two Numbers

class AddTwoNumbers {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = l1;
        ListNode last = l1;
        int carry = 0;

        while (l1 != null && l2 != null) {
            int cur = l1.val + l2.val + carry;

            l1.val = cur % 10;
            carry = cur / 10;

            last = l1;

            l1 = l1.next;
            l2 = l2.next;
        }

        ListNode rest = l1 != null ? l1 : l2;

        if (rest != null) {
            last.next = rest;
            while (rest != null) {
                int cur = rest.val + carry;

                rest.val = cur % 10;
                carry = cur / 10;

                last = rest;
                rest = rest.next;
            }
        }

        if (carry > 0)
            last.next = new ListNode(carry);

        return res;
    }
}
