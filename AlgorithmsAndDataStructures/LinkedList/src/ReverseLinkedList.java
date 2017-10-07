public class ReverseLinkedList {
    public static Node reverseList(Node head) {
        if (head == null)
            return null;
        if (head.next == null)
            return head;

        Node cur = head.next;
        Node prev = head;
        prev.next = null;

        while (cur != null) {
            Node next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;
    }
}
