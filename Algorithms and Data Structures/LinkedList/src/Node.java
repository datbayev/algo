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

    void appendToTail(Node end) {
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

    public static String pathToString(Node node) {
        if (node == null)
            return "";

        if (node.next == null)
            return node.toString();

        String result = "";
        while (node.next != null) {
            result = result + node.toString() + " ";
            node = node.next;
        }

        result = result + node.toString();

        return result;
    }


    public static int listToNum(Node node) {
        if (node == null)
            return 0;

        if (node.next == null)
            return node.data;

        int res = 0;
        int mul = 1;
        while (node != null) {
            res += node.data * mul;
            node = node.next;
            mul *= 10;
        }

        return res;
    }

    /*
    Returns 2->1->9 if the input is 912
     */
    public static Node numToList(int num) {
        if (num < 10)
            return new Node(num);

        Node prev = new Node(num % 10);
        Node head = prev;
        num /= 10;
        while (num > 0) {
            Node cur = new Node(num % 10);
            prev.next = cur;
            prev = cur;
            num /= 10;
        }

        return head;
    }

    public static Node reversedClone(Node currentNode) {
        if (currentNode == null)
            return null;

        if (currentNode.next == null)
            return new Node(currentNode.data);

        Node newHead = reversedClone(currentNode.next);
        newHead.appendToTail(currentNode.data);
        return newHead;
    }
}
