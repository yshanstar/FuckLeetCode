package hack.google;

import hack.util.DoubleLinkedListNode;

import java.util.HashMap;
import java.util.Map;

/*
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

 get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 */
public class LRUCache {
	private int capacity;
	private Map<Integer, DoubleLinkedListNode> cache;
	private DoubleLinkedListNode head;
	private DoubleLinkedListNode tail;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		this.cache = new HashMap<Integer, DoubleLinkedListNode>(capacity);
		this.head = new DoubleLinkedListNode(Integer.MIN_VALUE, Integer.MIN_VALUE);
		this.tail = new DoubleLinkedListNode(Integer.MAX_VALUE, Integer.MAX_VALUE);
		this.head.next = this.tail;
		this.tail.prev = this.head;
	}

	public int get(int key) {
		if (!this.cache.containsKey(key)) {
			return -1;
		}
		DoubleLinkedListNode node = this.cache.get(key);
		node.prev.next = node.next;
		node.next.prev = node.prev;
		attach(node);
		return node.value;
	}

	public void set(int key, int value) {
		if (!this.cache.containsKey(key)) {
			if (this.cache.size() == this.capacity) {
				dettach();
			}
			DoubleLinkedListNode node = new DoubleLinkedListNode(key, value);
			attach(node);
			cache.put(key, node);
		} else {
			DoubleLinkedListNode node = this.cache.get(key);
			node.value = value;
			node.prev.next = node.next;
			node.next.prev = node.prev;
			attach(node);
		}
	}

	private void dettach() {
		DoubleLinkedListNode node = this.tail.prev;
		node.prev.next = this.tail;
		this.tail.prev = node.prev;
		node.prev = null;
		node.next = null;
		this.cache.remove(node.key);
	}

	private void attach(DoubleLinkedListNode node) {
		DoubleLinkedListNode headNext = this.head.next;
		headNext.prev = node;
		node.next = headNext;
		this.head.next = node;
		node.prev = this.head;
	}
}
