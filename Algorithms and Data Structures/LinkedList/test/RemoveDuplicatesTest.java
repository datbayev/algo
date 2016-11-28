import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RemoveDuplicatesTest {
    @Test
    void test_general() {
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

        RemoveDuplicates.removeDuplicates(head);

        assertEquals(6, Node.getLength(head));
    }

    @Test
    void test_two_equal_elements() {
        Node head = new Node(1);
        head.appendToTail(1);

        RemoveDuplicates.removeDuplicates(head);

        assertEquals(1, Node.getLength(head));
    }

    @Test
    void test_two_different_elements() {
        Node head = new Node(1);
        head.appendToTail(10);

        RemoveDuplicates.removeDuplicates(head);

        assertEquals(2, Node.getLength(head));
    }
}
