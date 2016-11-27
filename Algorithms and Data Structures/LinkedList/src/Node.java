public class Node {
    int data;
    Node next = null;

    public Node(int data) {
        this.data = data;
    }

    void appendToTail(int d) {
        Node end = new Node(d);
        Node n = this;
        while (n.next != null)
            n = n.next;

        n.next = end;
    }

    void printList() {
        Node n = this;
        while (n.next != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.println(n.data);
    }

    public String toString() {
        return Integer.toString(this.data);
    }

    public static int getLength(Node head) {
        if (head == null)
            return 0;

        if (head.next == null)
            return 1;

        return getLength(head.next) + 1;
    }
}
