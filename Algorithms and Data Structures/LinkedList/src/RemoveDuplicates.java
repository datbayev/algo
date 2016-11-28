import java.util.HashSet;

public class RemoveDuplicates {
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
