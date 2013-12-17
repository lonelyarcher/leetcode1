package Leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

import Leetcode.customerDataType.ListNode;

public class MergeKSortedLists
{

	public static void main(String[] args)
	{

	}

	public static ListNode mergeKListsByHeap(ArrayList<ListNode> lists)
	{
		int k=lists.size();
		if(k==0) return null;
		Comparator<ListNode> comparator=new Comparator<ListNode>()
		{
			@Override
			public int compare(ListNode n1, ListNode n2)
			{
				if(n1.val>n2.val) return 1;
				if(n1.val==n2.val) return 0;
				else return -1;
			}
		};
		PriorityQueue<ListNode> heap=new PriorityQueue<ListNode>(k, comparator);
		for (ListNode node : lists)
			if(node!=null) heap.add(node);
		ListNode root=new ListNode(0);
		ListNode ptr1=root;

		while (!heap.isEmpty())
		{
			ListNode ptr2=heap.poll();
			ptr1.next=ptr2;
			ptr1=ptr1.next;
			if(ptr2.next!=null) heap.offer(ptr2.next);
		}
		return root.next;
	}

	public static ListNode mergeKListsByMerge(ArrayList<ListNode> lists)
	{

		if(lists.size()==0) return null;
		int left=0;
		int right=lists.size()-1;
		while (right>0)
		{
			left=0;
			while (left<right)
			{
				lists.set(left, merge(lists.get(left), lists.get(right)));
				left++;
				right--;
			}
		}
		return lists.get(0);

	}

	private static ListNode merge(ListNode left, ListNode right)
	{
		ListNode root=new ListNode(0);
		ListNode head=root;
		while (left!=null&&right!=null)
		{
			if(left.val<=right.val)
			{
				head.next=left;
				left=left.next;
			}
			else
			{
				head.next=right;
				right=right.next;
			}
			head=head.next;
		}
		head.next=(left==null) ? right : left;
		return root.next;
	}

}
