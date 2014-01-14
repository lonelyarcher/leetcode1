package Leetcode;

import Leetcode.customerDataType.ListNode;

public class SwapNodesInPair
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		ListNode l1=new ListNode(1);
		ListNode l2=new ListNode(2);
		ListNode l3=new ListNode(3);
		ListNode l4=new ListNode(4);
		ListNode l5=new ListNode(5);
		l1.next=l2;
		l2.next=l3;
		l3.next=l4;
		l4.next=l5;
		l1=swapPairs(l1);
		while (l1!=null)
		{
			System.out.println(l1.val);
			l1=l1.next;
		}

	}

	public static ListNode swapPairs(ListNode head)
	{
		if(head==null||head.next==null) return head;
		ListNode fake=new ListNode(0);
		ListNode ptr0=fake;
		ListNode ptr1=head;
		ListNode ptr2=head.next;
		while (ptr2!=null)
		{
			ptr0.next=ptr2;
			ptr1.next=ptr2.next;
			ptr2.next=ptr1;

			ptr0=ptr1;
			ptr1=ptr1.next;
			if(ptr1!=null) ptr2=ptr1.next;
			else ptr2=null;
		}
		return fake.next;

	}

}
