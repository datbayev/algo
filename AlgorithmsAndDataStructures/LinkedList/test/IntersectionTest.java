import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntersectionTest {
    @Test
    void test0() {
        Node head1 = new Node(10);
        Node head2 = new Node(20);

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);

        head1.appendToTail(node4);
        head1.appendToTail(node5);
        head1.appendToTail(node6); // 10->4->5->6

        head2.appendToTail(node1);
        head2.appendToTail(node2);
        head2.appendToTail(node3);
        head2.appendToTail(node5); // 20->1->2->3->5->6

        Node intersection = Intersection.intersection(head1, head2);
        assertEquals("5 6", Node.pathToString(intersection));
    }

    @Test
    void testNull() {
        Node head1 = new Node(10);
        Node head2 = new Node(20);

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);

        head1.appendToTail(node4);
        head1.appendToTail(node5);
        head1.appendToTail(node6); // 10->4->5->6

        head2.appendToTail(node1);
        head2.appendToTail(node2);
        head2.appendToTail(node3); // 20->1->2->3

        Node intersection = Intersection.intersection(head1, head2); // 5 is the intersection
        assertEquals(null, intersection);
    }
}
