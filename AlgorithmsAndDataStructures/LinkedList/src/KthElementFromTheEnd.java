import java.util.ArrayList;
import java.util.List;

public class KthElementFromTheEnd {
    static List<Node> nodes;

    public static Node getKthLastElement(Node head, int k) {
        nodes = new ArrayList<>();

        numerateNodes(head);
        if (nodes.size() < k) // k is too big
            return null;

        return nodes.get(k);
    }

    public static void numerateNodes(Node node) {
        if (node.next == null) {
            nodes.add(node);
            return;
        }

        numerateNodes(node.next);
        nodes.add(node);
    }
}
