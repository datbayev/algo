import java.util.HashSet;
import java.util.Set;

public class LoopDetection {
    public static Node shiftInLoop(Node node, int num) {
        Node next = node;
        while (num > 0) {
            next = next.next;
            num--;
        }

        return next;
    }

    public static Node loopNode(Node head) {
        if (head == null)
            return null;

        if (head.next == null)
            return null;

        int i = 1;
        int nodesNum = 0;
        Node result = null;

        while (true) {
            Node slow = head;
            Node fast = shiftInLoop(head, i);

            if (slow.next == null || fast.next == null) // one of nodes is the end => no loop
                break;

            boolean found = false;
            boolean noLoop = false;
            Set<Node> set = new HashSet<>();

            while (!set.contains(slow)) {
                set.add(slow);
                if (slow.next == fast.next) {
                    found = true;
                    break;
                }
                slow = slow.next;
                fast = shiftInLoop(fast, i);

                if (slow.next == null || fast.next == null) {
                    noLoop = true;
                    break;
                }
            }

            if (noLoop)
                break;

            if (nodesNum == 0)
                nodesNum = set.size();

            if (found) {
                result = slow;
                break;
            }

            i++;
            if (i >= 2 * nodesNum)
                break;
        }

        return result;
    }
}
