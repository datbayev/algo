import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoopDetectionTest {
    @Test
    void test0() {
        Node head = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(30);
        Node node3 = new Node(70);
        Node node4 = new Node(30);
        Node node5 = new Node(60);

        head.appendToTail(node1);
        head.appendToTail(node2);
        head.appendToTail(node3);
        head.appendToTail(node4);
        head.appendToTail(node5);

        head.appendToTail(node2); // node2 is a node where list in looping

        Node looper = LoopDetection.loopNode(head);

        assertEquals(node2, looper);
    }

    @Test
    void test1() {
        Node head = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(30);
        Node node3 = new Node(70);
        Node node4 = new Node(30);
        Node node5 = new Node(60);

        head.appendToTail(node1);
        head.appendToTail(node2);
        head.appendToTail(node3);
        head.appendToTail(node4);
        head.appendToTail(node5);

        head.appendToTail(node4); // node4 is a node where list in looping

        Node looper = LoopDetection.loopNode(head);

        assertEquals(node4, looper);
    }

    @Test
    void testNull() {
        Node head = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(30);
        Node node3 = new Node(70);
        Node node4 = new Node(30);
        Node node5 = new Node(60);

        head.appendToTail(node1);
        head.appendToTail(node2);
        head.appendToTail(node3);
        head.appendToTail(node4);
        head.appendToTail(node5); // there's no loop

        Node looper = LoopDetection.loopNode(head);

        assertEquals(null, looper);
    }

    @Test
    void testSingleElement() {
        Node head = new Node(0); // no loop, just node itself

        Node looper = LoopDetection.loopNode(head);

        assertEquals(null, looper);
    }
}
