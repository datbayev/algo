public class SumLists {
    public static Node sumLists(Node node1, Node node2) {
        int num1 = Node.listToNum(node1);
        int num2 = Node.listToNum(node2);
        return Node.numToList(num1 + num2);
    }
}
