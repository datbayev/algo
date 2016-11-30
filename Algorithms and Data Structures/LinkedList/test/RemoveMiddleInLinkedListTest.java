import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RemoveMiddleInLinkedListTest {

    @Test
    void test_normal() {
        Node head = new Node(1);
        head.appendToTail(2);
        head.appendToTail(3);
        head.appendToTail(4);
        head.appendToTail(5);

        Node newHead = RemoveMiddleInLinkedList.removeMiddle(head);
        head.printList();

        assertEquals(4, Node.getLength(newHead));
    }

    @Test
    void test_null() {
        Node newHead = RemoveMiddleInLinkedList.removeMiddle(null);
        assertEquals(null, newHead);
    }

    @Test
    void test_single_element() {
        Node head = new Node(1);
        Node newHead = RemoveMiddleInLinkedList.removeMiddle(head);
        assertEquals(null, newHead);
        assertEquals(0, Node.getLength(newHead));
    }

    @Test
    void test_two_elements() {
        Node head = new Node(1);
        head.appendToTail(2);

        Node newHead = RemoveMiddleInLinkedList.removeMiddle(head);
        assertEquals(2, Node.getLength(newHead));
    }

    @Test
    void test_normal_2() {
        Node head = new Node(1);
        head.appendToTail(2);
        head.appendToTail(3);

        Node newHead = RemoveMiddleInLinkedList.removeMiddle(head);
        head.printList();

        assertEquals(2, Node.getLength(newHead));
    }

    @Test
    void test_normal_3() {
        Node head = new Node(1);
        head.appendToTail(2);
        head.appendToTail(3);
        head.appendToTail(4);
        head.appendToTail(5);
        head.appendToTail(6);
        head.appendToTail(7);
        head.appendToTail(8);
        head.appendToTail(9);

        Node newHead = RemoveMiddleInLinkedList.removeMiddle(head);
        head.printList();

        assertEquals(8, Node.getLength(newHead));
    }
}
