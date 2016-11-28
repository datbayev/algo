import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NodeTest {
    @Test
    void test_basic() {
        Node n = new Node(1);
        assertEquals(1, Node.getLength(n));
    }

    @Test
    void test_null() {
        Node n = null;
        assertEquals(0, Node.getLength(n));
    }

    @Test
    void test_more_elements_1() {
        Node n = new Node(1);
        n.appendToTail(2);
        n.appendToTail(3);
        n.appendToTail(4);

        assertEquals(4, Node.getLength(n));
    }

    @Test
    void test_more_elements_2() {
        Node n = new Node(1);
        n.appendToTail(10);
        n.appendToTail(20);
        n.appendToTail(30);
        n.appendToTail(40);
        n.appendToTail(50);
        assertEquals(6, Node.getLength(n));
    }

}