import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReverseLinkedListTest {
    @Test
    void test_normal() {
        Node head = new Node(1);
        head.appendToTail(2);
        head.appendToTail(3);
        head.appendToTail(4);
        head.appendToTail(5);
        Node oldTail = new Node(6);
        head.appendToTail(oldTail);

        Node newHead = ReverseLinkedList.reverseList(head);
        assertEquals(newHead, oldTail);
    }

    @Test
    void test_null() {
        Node nullNode = null;
        Node n = ReverseLinkedList.reverseList(nullNode);
        assertEquals(null, n);
    }

    @Test
    void test_single_element() {
        Node oneNode = new Node(1);
        Node newHead = ReverseLinkedList.reverseList(oneNode);
        assertEquals(oneNode, newHead);
    }

    @Test
    void test_two_elements() {
        Node firstHeadNode = new Node(1);
        Node secondTailNode = new Node(2);
        firstHeadNode.appendToTail(secondTailNode);

        Node newHead = ReverseLinkedList.reverseList(firstHeadNode);
        assertEquals(secondTailNode, newHead);
    }
}
