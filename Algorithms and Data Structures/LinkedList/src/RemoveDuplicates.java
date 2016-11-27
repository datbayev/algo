import java.util.HashSet;

public class RemoveDuplicates {
    public static void main(String[] args) {
        Node head = new Node(1);

        head.appendToTail(10);
        head.appendToTail(5);
        head.appendToTail(3);
        head.appendToTail(16);
        head.appendToTail(3);
        head.appendToTail(5);
        head.appendToTail(10);
        head.appendToTail(1);
        head.appendToTail(1);
        head.appendToTail(1);
        head.appendToTail(16);
        head.appendToTail(7);

        head.printList();
        removeDuplicates(head);
        head.printList();
    }

    static void removeDuplicates(Node head) {
        Node prev = head;
        Node cur = prev.next;
        HashSet<Integer> used = new HashSet<>();
        used.add(prev.data);
        while (cur.next != null) {
            if (!used.contains(cur.data)) {
                used.add(cur.data);

                prev = cur;
                cur = cur.next;
            } else {
                prev.next = cur.next;
                cur = cur.next;
            }
        }
    }
}
