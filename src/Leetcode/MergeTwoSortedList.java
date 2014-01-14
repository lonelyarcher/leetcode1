package Leetcode;

import Leetcode.customerDataType.ListNode;

public class MergeTwoSortedList
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2)
	{
		ListNode fake=new ListNode(0);
		ListNode ptr=fake;
		while (l1!=null&&l2!=null)
		{
			if(l1.val<=l2.val)
			{
				ptr.next=l1;
				l1=l1.next;
			}
			else
			{
				ptr.next=l2;
				l2=l2.next;
			}
			ptr=ptr.next;
		}
		ptr.next=(l1==null) ? l2 : l1;
		return fake.next;
	}
}
