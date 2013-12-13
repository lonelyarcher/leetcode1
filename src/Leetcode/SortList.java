package Leetcode;

import Leetcode.customerDataType.ListNode;

public class SortList {

	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode a = head;
		ListNode b = head.next;
		while ((b != null) && (b.next != null)) {
			head = head.next;
			b = (b.next).next;
		}
		b = head.next;
		head.next = null;
		return merge(sortList(a), sortList(b));

	}

	public ListNode merge(ListNode a, ListNode b) {
		ListNode temp = new ListNode(0);
		ListNode head = temp;
		ListNode c = head;
		while ((a != null) && (b != null)) {
			if (a.val <= b.val) {
				c.next = a;
				c = a;
				a = a.next;
			} else {
				c.next = b;
				c = b;
				b = b.next;
			}
		}
		c.next = (a == null) ? b : a;
		return head.next;
	}

	public static void main(String[] args) {

	}

}
