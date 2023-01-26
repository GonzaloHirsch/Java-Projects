package interviewProblems.LRU_Cache;

import java.util.HashMap;
import java.util.Map;

class LRUCache {
    private final Map<Integer, ListNode> store;
    private ListNode head = new ListNode(-1, -1), tail = new ListNode(-1, -1);
    private final int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.store = new HashMap<>(capacity, 1);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public int get(int key) {
        ListNode node = this.store.get(key);
        if (node == null) return -1;
        this.remove(node);
        this.insert(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (this.store.containsKey(key)) this.remove(this.store.get(key));
        if (this.store.size() == this.capacity) this.remove(this.tail.prev);
        this.insert(new ListNode(key, value));
    }

    private void remove(ListNode node) {
        this.store.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insert(ListNode node) {
        this.store.put(node.key, node);
        ListNode headNext = this.head.next;
        node.prev = head;
        node.next = headNext;
        head.next = node;
        headNext.prev = node;
    }
    private class ListNode {
        public int key;
        public int val;
        public ListNode prev, next;
        public ListNode(int _key, int _val) {
            this.val = _val;
            this.key = _key;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */