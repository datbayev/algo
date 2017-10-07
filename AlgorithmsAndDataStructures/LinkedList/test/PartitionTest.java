import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PartitionTest {
    @Test
    void test_normal() {
        Node head = new Node(1);
        head.appendToTail(2);
        head.appendToTail(22);
        head.appendToTail(12);
        head.appendToTail(16);
        head.appendToTail(18);
        head.appendToTail(15);
        head.appendToTail(6);
        head.appendToTail(19);
        head.appendToTail(4);
        head.appendToTail(13);

        int partition = 15;
        Node newNode = Partition.partitionLinkedList(head, partition);

        assertEquals("1 2 12 6 4 13 22 16 18 15 19", Node.pathToString(newNode));
    }

    @Test
    void test_null() {
        Node head = null;
        Node newNode = Partition.partitionLinkedList(head, 1000);
        assertEquals(null, newNode);
    }

    @Test
    void test_all_similar_elements() {
        Node head = new Node(1);
        head.appendToTail(1);
        head.appendToTail(1);
        head.appendToTail(1);
        head.appendToTail(1);

        Node newNode = Partition.partitionLinkedList(head, 1);
        assertEquals("1 1 1 1 1", Node.pathToString(newNode));
    }
}
