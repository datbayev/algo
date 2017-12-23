package algorithms.sets;

import java.util.*;

public class SetTest {
    public static void main(String[] args) {
        Set<Integer> intSet = new TreeSet();
        intSet.add(10);
        intSet.add(5);
        intSet.add(20);
        intSet.add(15);
        intSet.add(7);

        Iterator<Integer> it = intSet.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }

        System.out.println();

        Set<Character> charSet = new TreeSet();
        String name = "ALIBEK";
        for (char c : name.toCharArray())
            charSet.add(c);

        Iterator<Character> charSetIt = charSet.iterator();
        while (charSetIt.hasNext()) {
            System.out.print(charSetIt.next() + " ");
        }
    }
}
