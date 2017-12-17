package algorithms.linked_lists;

public class Intersection {
    public static Node intersection(Node head1, Node head2) {
        if (head1 == null || head2 == null)
            return null;

        int size1 = Node.getLength(head1);
        int size2 = Node.getLength(head2);

        if (size1 == size2) {
            return head1 == head2 ? head1 : null;
        }

        Node node1 = size1 < size2 ? head1 : head2; // shorter linked list
        Node node2 = size2 > size1 ? head2 : head1; // longer linked list

        while (size2 != size1) {
            node2 = node2.next;
            size2--;
        }

        while (node1 != node2 && node1 != null && node2 != null) {
            node1 = node1.next;
            node2 = node2.next;
        }

        if (node1 == null || node2 == null)
            return null;

        return node1;
    }
}
