import java.util.HashSet;

public class RemoveDuplicates {
    static void removeDuplicates(Node head) {
        Node prev = head;
        Node cur = prev.next;
        HashSet<Integer> used = new HashSet<>();
        used.add(prev.data);

        if (used.contains(cur.data)) { // first iteration, to cover case of similar first two elements
            prev.next = cur.next;
            cur = cur.next;
        }

        while (cur != null && cur.next != null) {
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
