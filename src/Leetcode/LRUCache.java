package Leetcode;

import java.util.HashMap;

public class LRUCache {

	class Cnode<E> {
		E key;
		E val;
		Cnode<E> prev;
		Cnode<E> next;

		Cnode(E key, E val, Cnode<E> prev, Cnode<E> next) {
			this.key = key;
			this.val = val;
			this.prev = prev;
			this.next = next;
		}
	}

	HashMap<Integer, Cnode<Integer>> map;

	int capacity;
	int head;
	int tail;

	public LRUCache(int capacity) {
		map = new HashMap<Integer, Cnode<Integer>>();
		this.capacity = capacity;
	}

	public int get(int key) {
		if (map.containsKey(key)) {
			Cnode<Integer> cnode = map.get(key);
			moveToHead(cnode);
			return cnode.val;
		} else
			return -1;
	}

	public void set(int key, int value) {

		if (map.containsKey(key)) {
			Cnode<Integer> cnode = map.get(key);
			cnode.val = value;
			moveToHead(cnode);
		} else {
			Cnode<Integer> cnode = new Cnode<Integer>(key, value, null, null);
			if (map.size() == capacity) {
				removeTail();
			}
			if (map.size() == 0) {
				head = key;
				tail = key;
				map.put(key, cnode);
			} else {
				insertToHead(cnode);
			}
		}
	}

	private void insertToHead(Cnode<Integer> cnode) {
		Cnode<Integer> headNode = map.get(head);
		cnode.next = headNode;
		headNode.prev = cnode;
		head = cnode.key;
		map.put(cnode.key, cnode);
	}

	private void removeTail() {
		if (map.size() == 0)
			throw new RuntimeException();
		if (map.size() == 1) {
			map.remove(tail);
			return;
		}
		Cnode<Integer> cnode = map.remove(tail);
		cnode = cnode.prev;
		cnode.next = null;
		tail = cnode.key;
	}

	private void moveToHead(Cnode<Integer> cnode) {
		if (cnode.prev == null)
			return;
		if (cnode.next == null) {
			removeTail();
			cnode.prev = null;
			insertToHead(cnode);
		} else {
			cnode.prev.next = cnode.next;
			cnode.next.prev = cnode.prev;
			cnode.prev = null;
			cnode.next = null;
			map.remove(cnode.key);
			insertToHead(cnode);
		}
	}

	public static void main(String[] args) {
		LRUCache c = new LRUCache(1);
		c.set(1, 1);
		c.set(2, 2);
		c.set(3, 3);
		c.set(4, 4);
		c.set(5, 5);
		System.out.println(c.get(1));
		System.out.println(c.get(2));
		System.out.println(c.get(3));
		System.out.println(c.get(4));
		System.out.println(c.get(5));

	}
}