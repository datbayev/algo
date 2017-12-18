package leet_code;

// https://leetcode.com/problems/lru-cache/description/
// 146. LRU Cache

import java.util.*;

class LRUCache {
    
    Map<Integer, Node> cache;
    int capacity;
    Node head;
    Node tail;
    
    public LRUCache(int capacity) {
        cache = new HashMap(capacity);
        this.capacity = capacity;
        head = null;
        tail = null;
    }
    
    public int get(int key) {
        if (!cache.containsKey(key))
            return -1;
        
        Node cur = cache.get(key);

        if (capacity == 1 || cur.next == null)
            return cur.val;
        
        moveToTail(cur);
        
        return cur.val;
    }
    
    public void moveToTail(Node cur) {
        Node next = cur.next;
        Node prev = cur.prev;
        
        if (prev != null) { // there is something before cur, re-link nodes
            next.prev = prev;
            prev.next = next;
        } else {
            head = head.next;
            head.prev = null;
        }
        
        tail.next = cur;
        cur.prev = tail;
        cur.next = null;
        tail = cur;
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node cur = cache.get(key);
            cur.val = value;
            if (cur.next != null)
                moveToTail(cur);
            
            return;
        }
        
        Node node = new Node(key, value);
        
        if (tail == null) { // no data at all yet
            head = node;
            tail = node;
        } else {
            node.prev = tail;
            tail.next = node;
            tail = node;
        }
        
        cache.put(key, node);
        
        if (cache.size() > capacity) {
            cache.remove(head.key);
            head = head.next;
            head.prev = null;
        }
    }
    
    class Node {
        int key, val;
        Node prev;
        Node next;
        
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}
