package Leetcode;

import Leetcode.customerDataType.ListNode;

public class LinkedListCycle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static boolean hasCycle(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) return true;
		}
		return false;

	}

	public ListNode detectCycle(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		int meet = 0;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			if (meet == 0) fast = fast.next.next;
			else fast = fast.next;
			if (slow == fast && meet == 0) {
				slow = head;
				meet++;
			}
			if (slow == fast && meet > 0) return fast;
		}
		return null;
	}

}
