package leetcode;

// https://leetcode.com/problems/lru-cache/description/
// 146. LRU Cache

import java.util.*;

class LRUCache {

    private HashMap<Integer, Node> cache;
    private int capacity;
    private Node head;
    private Node tail;

    private void moveToTail(Node cur) {
        if (cur.next == null)
            return;

        removeNode(cur);
        addNodeToTail(cur);
    }

    private void removeNode(Node cur) {
        Node next = cur.next;
        Node prev = cur.prev;

        if (prev != null) { // there is something before cur, re-link nodes
            next.prev = prev;
            prev.next = next;
        } else {
            head = head.next; // cur is the head, cut the head, and bring cur to tail
            head.prev = null;
        }
    }

    private void addNodeToTail(Node cur) {
        if (tail == null) {
            tail = cur;
            head = cur;
            return;
        }

        tail.next = cur;
        cur.prev = tail;
        cur.next = null;

        tail = cur;
    }

    public LRUCache(int capacity) {
        cache = new HashMap<>(capacity);
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!cache.containsKey(key))
            return -1;

        Node cur = cache.get(key);

        moveToTail(cur);

        return cur.val;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node cur = cache.get(key);
            cur.val = value;
            moveToTail(cur);

            return;
        }

        Node node = new Node(key, value);

        addNodeToTail(node);

        cache.put(key, node);

        if (cache.size() > capacity) {
            cache.remove(head.key);
            removeNode(head); // remove the least
        }
    }

    class Node {
        int key, val;
        Node prev, next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}
