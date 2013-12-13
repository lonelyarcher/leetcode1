package Leetcode;

import Leetcode.customerDataType.ListNode;

public class SortListByQuickSort {
	public static void main(String[] args) {
		SortListByQuickSort sl = new SortListByQuickSort();
		ListNode n1 = new ListNode(4);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(1);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;

		ListNode n = sl.sortList(n1);
		System.out.println("n1=" + n.val);
		System.out.println("n2=" + n.next.val);
		System.out.println("n3=" + n.next.next.val);
		System.out.println("n4=" + n.next.next.next.val);

	}

	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode[] HT = sort(head, null);
		return HT[0];

	}

	public static ListNode[] sort(ListNode head, ListNode tail) {
		if (head == tail) {
			return new ListNode[] { head, tail };
		}
		if (tail != null)
			tail.next = null;
		ListNode pivot = head;
		tail = pivot;
		ListNode beforePivot = null;
		ListNode ptr = head.next;
		while (ptr != null) {
			if (ptr.val < pivot.val) {
				if (beforePivot == null)
					beforePivot = ptr;
				tail.next = ptr.next;
				ptr.next = head;
				head = ptr;
			} else {
				tail = ptr;
			}
			ptr = tail.next;
		}
		ListNode[] left = new ListNode[2];
		ListNode[] right = new ListNode[2];

		if (beforePivot != null)
			left = sort(head, beforePivot);
		else
			left = null;

		if (pivot.next != null)
			right = sort(pivot.next, tail);
		else
			right = null;
		if (left != null && right != null) {
			left[1].next = pivot;
			pivot.next = right[0];
			return new ListNode[] { left[0], right[1] };
		} else if (left != null) {
			left[1].next = pivot;
			return new ListNode[] { left[0], pivot };
		}

		else if (right != null) {
			pivot.next = right[0];
			return new ListNode[] { pivot, right[1] };
		} else
			return new ListNode[] { pivot, pivot };
	}
}