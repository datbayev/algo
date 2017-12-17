package algorithms.hashmap;

import java.util.*;

public class MapTest {
    public static void main(String[] args) {
        Map<Integer, Integer> treeMap = new TreeMap<>();
        treeMap.put(1, 1);
        treeMap.put(8, 8);
        treeMap.put(3, 3);
        treeMap.put(2, 2);
        treeMap.put(0, 0);

        System.out.println("Treemap");
        for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
            System.out.println(String.format("key=%d, value=%d", entry.getKey(), entry.getValue()));
        }

        Map<Integer, Integer> linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(1, 1);
        linkedHashMap.put(8, 8);
        linkedHashMap.put(3, 3);
        linkedHashMap.put(2, 2);
        linkedHashMap.put(0, 0);

        System.out.println("\nLinkedHashMap");
        for (Map.Entry<Integer, Integer> entry : linkedHashMap.entrySet()) {
            System.out.println(String.format("key=%d, value=%d", entry.getKey(), entry.getValue()));
        }
    }
}
