public class RemoveMiddleInLinkedList {
    public static Node removeMiddle(Node head) {
        if (head == null || head.next == null)
            return null;

        int size = Node.getLength(head);

        if (size == 2)
            return head;

        Node prev = head;
        Node cur = prev.next;
        Node next = cur.next;
        int i = 2;

        while (i < (size + 1) / 2) {
            prev = cur;
            cur = next;
            next = cur.next;
            i++;
        }

        prev.next = next; // cur is deleted

        return head;
    }
}
