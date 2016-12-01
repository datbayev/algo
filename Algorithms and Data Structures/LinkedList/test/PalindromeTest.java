import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PalindromeTest {
    @Test
    void test0() {
        Node head = new Node(1);
        head.appendToTail(2);
        head.appendToTail(2);
        head.appendToTail(1);

        assertEquals(true, Palindrome.isPalindrome(head));
    }
    @Test
    void testSimpleFalse() {
        Node head = new Node(1);
        head.appendToTail(2);
        head.appendToTail(3);
        head.appendToTail(1);

        assertEquals(false, Palindrome.isPalindrome(head));
    }
    @Test
    void testSingleElement() {
        Node head = new Node(1);

        assertEquals(true, Palindrome.isPalindrome(head));
    }
    @Test
    void testLongerTrue() {
        Node head = new Node(1);
        head.appendToTail(2);
        head.appendToTail(3);
        head.appendToTail(2);
        head.appendToTail(1);

        assertEquals(true, Palindrome.isPalindrome(head));
    }
}
