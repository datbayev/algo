public class Partition {
    static Node partitionLinkedList(Node head, int partition) {
        if (head == null)
            return null;

        if (head.next == null)
            return head;

        Node left = null;
        Node right = null;
        Node leftTail = null;

        while (head != null) {
            int curData = head.data;

            if (head.data < partition) {
                Node newEnd = new Node(curData);
                if (left == null)
                    left = newEnd;
                else
                    left.appendToTail(newEnd);
                leftTail = newEnd;
            } else {
                if (right == null)
                    right = new Node(curData);
                else
                    right.appendToTail(curData);
            }

            head = head.next;
        }

        if (leftTail != null)
            leftTail.next = right;

        return left != null ? left : right;
    }
}
