import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SumListsTest {
    @Test
    void test_normal() {
        Node node1 = new Node(7);
        node1.appendToTail(1);
        node1.appendToTail(6); // 7->1->6 = 617

        Node node2 = new Node(5);
        node2.appendToTail(9);
        node2.appendToTail(2); // 5->9->2 = 295

        Node sum = SumLists.sumLists(node1, node2); // 617 + 295 = 912
        assertEquals("2 1 9", Node.pathToString(sum));
    }

    @Test
    void test_normal_2() {
        Node node1 = new Node(2);
        node1.appendToTail(2);
        node1.appendToTail(2); // 2->2->2 = 222

        Node node2 = new Node(1);
        node2.appendToTail(8);
        node2.appendToTail(1); // 1->8->1

        Node sum = SumLists.sumLists(node1, node2); // 222 + 181 = 403
        assertEquals("3 0 4", Node.pathToString(sum));
    }

    @Test
    void test_normal_3() {
        Node node1 = new Node(9);
        node1.appendToTail(9);
        node1.appendToTail(9); // 9->9->9 = 999

        Node node2 = new Node(4);
        node2.appendToTail(9);
        node2.appendToTail(2);
        node2.appendToTail(4); // 4->9->2->4 = 4294

        Node sum = SumLists.sumLists(node1, node2); // 999 + 4294 = 5293
        assertEquals("3 9 2 5", Node.pathToString(sum));
    }
}
