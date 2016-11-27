import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KthElementFromTheEndTest {
    @Test
    void test_normal() {
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
        head.appendToTail(7);

        int k = 8; // 1-based index from the end

        Node kth = KthElementFromTheEnd.getKthLastElement(head, k - 1);

        assertEquals(3, kth.data);
    }

    @Test
    void test_null() {
        Node head = new Node(1);

        head.appendToTail(2);
        head.appendToTail(3);
        head.appendToTail(4);

        int k = 10; // result should be null, 10 is too big

        Node kth = KthElementFromTheEnd.getKthLastElement(head, k - 1);

        assertEquals(null, kth);
    }

    @Test
    void test_one_element() {
        Node head = new Node(1);

        int k = 1;

        Node kth = KthElementFromTheEnd.getKthLastElement(head, k - 1);

        assertEquals(1, kth.data);
    }
}
