package Leetcode;

import java.util.ArrayList;

import Leetcode.customerDataType.ListNode;

public class RemoveNthFromEnd
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

	public ListNode removeNthFromEnd(ListNode head, int n)
	{
		ArrayList<ListNode> a=new ArrayList<ListNode>();
		ListNode ptr=head;
		int count=0;
		while (ptr!=null)
		{
			count++;
			a.add(ptr);
			ptr=ptr.next;
		}
		assert (count>0&&n<=count);
		if(count==1) return null;
		if(n==count) return head.next;
		if(n==0) return head;
		if(n==1)
		{
			a.get(count-2).next=null;
		}
		else a.get(count-n-1).next=a.get(count-n+1);
		return head;
	}

}
