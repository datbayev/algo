package leetcode;

// https://leetcode.com/problems/delete-node-in-a-linked-list/description/
// 237. Delete Node in a Linked List

public class DeleteNodeInALinkedList {
    public void deleteNode(ListNode node) {
        if (node == null)
            return;
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
