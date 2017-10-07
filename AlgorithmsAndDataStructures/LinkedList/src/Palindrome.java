public class Palindrome {
    public static boolean isPalindrome(Node head) {
        if (head == null)
            return true; // depends on problem description, I assumed nothing is a palindrome

        if (head.next == null) // one node itself is a palindrome linked list
            return true;

        Node reversedList = Node.reversedClone(head);
        while (reversedList != null) {
            if (reversedList.data != head.data)
                return false;
            reversedList = reversedList.next;
            head = head.next;
        }

        return true;
    }
}
