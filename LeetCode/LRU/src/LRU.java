
import java.util.*;
// This is the text editor interface. 
// Anything you type or change here will be seen by the other person in real time.

// implement a LRU cache
// get(key) -> val
// put(key, val) -> void
// caller will initialize cache with a capacity N
// rhall@zenefits.com

class Node {
    int value;
    Node prev;
    Node next;

    public Node(int value) {
        this.value = value;
        this.next = null;
        this.prev = null;
    }
}

class ZList {
    Map<Integer, Node> map; // storage
    Node begin; // first element
    Node end; // last element
    int size;

    public ZList() {
        this.map = new HashMap<Integer, Node>();
        this.size = 0;
    }

    public void add(int key) {
        Node newNode = new Node(key);

        if (this.end == null) {
            this.end = newNode;
            this.begin = newNode;
            this.size++;
            return;
        }
        this.end.next = newNode;
        newNode.prev = this.end; // back-link
        this.end = newNode;
        this.map.put(key, newNode);
        this.size++;
        System.out.println("size=" + size);
    }

    public void remove(int key) {
        if (!this.map.containsKey(key))
            return; // no such value in map

        Node node = this.map.get(key);
        boolean isBegin = false;
        boolean isEnd = false;

        if (node.prev == null) {
            // this is the beginning
            isBegin = true;
        }

        if (node.next == null) {
            // this is the last element
            isEnd = true;
        }

        Node prev = node.prev;
        Node next = node.next;

        if (!isEnd)
            prev.next = next;

        if (!isBegin)
            next.prev = prev;

        if (isBegin)
            this.begin = node;

        if (isEnd)
            this.end = node;

        this.map.remove(key);
        this.size--;
    }

    public void removeFirst() {
        if (this.begin == null)
            return;

        Node node = this.begin;
        Node next = node.next;
        next.prev = null;
        this.begin = next;
        this.map.remove(node.value);
        this.size--;
    }

    public int getFirst() {
        if (this.begin == null)
            return -1;

        return this.begin.value;
    }

    public int size() {
        return this.size;
    }
}


class LRU {
    int capacity;
    Map<Integer, Integer> map;
    ZList list;

    public LRU(int N) {
        this.capacity = N; // init capacity
        this.map = new HashMap<Integer, Integer>();
        this.list = new ZList();
    }

    public int get(int key) {
        if (!this.map.containsKey(key))
            return -1;


        // 1 -> 2 -> 3 -> 4 ->

        this.list.remove(key);
        this.list.add(key);

        return this.map.get(key);
    }

    public void put(int key, int val) {
        if (this.list.size() == this.capacity) {
            this.map.remove(this.list.getFirst()); // remove from map
            this.list.removeFirst(); // remove from linked list
        }

        this.list.add(key);
        this.map.put(key, val);
    }

    public static void main(String[] args) {

        LRU lru = new LRU(3);
        lru.put(1, 1);
        lru.put(2, 2);
        lru.put(3, 3);
        lru.put(4, 4);

        System.out.println(lru.get(1));
    }
}
