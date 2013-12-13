package Leetcode;

import Leetcode.customerDataType.ListNode;

public class AddTwoNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		// Note: The Solution object is instantiated only once and is reused by each test case.
		ListNode head = new ListNode(0);
		ListNode ptr = head;
		int carry = 0;
		while (l1 != null || l2 != null) {
			int d = carry;
			if (l1 != null) {
				d += l1.val;
				l1 = l1.next;
			}
			if (l2 != null) {
				d += l2.val;
				l2 = l2.next;
			}
			carry = d / 10;
			d = d % 10;
			ptr.next = new ListNode(d);
			ptr = ptr.next;
		}
		if (carry == 1) ptr.next = new ListNode(1);
		return head.next;
	}

}
