package Leetcode;

import Leetcode.customerDataType.ListNode;

public class ReverseNodeInKGroup
{

	public static void main(String[] args)
	{
		ListNode l1=new ListNode(1);
		ListNode l2=new ListNode(2);
		ListNode l3=new ListNode(3);
		ListNode l4=new ListNode(4);
		ListNode l5=new ListNode(5);
		l1.next=l2;
		l2.next=l3;
		l3.next=l4;
		l4.next=l5;
		l1=reverseKGroup(l1, 4);
		while (l1!=null)
		{
			System.out.println(l1.val);
			l1=l1.next;
		}

	}

	public static ListNode reverseKGroup(ListNode head, int k)
	{
		if(head==null||head.next==null||k==1||k==0) return head;
		ListNode fake=new ListNode(0);
		fake.next=head;
		ListNode ptr=fake;
		for (int i=1; head!=null; i++)
		{

			if(i%k==0)
			{
				ListNode end=reverse(ptr, head.next);
				ptr=end;
				head=end.next;
			}
			else head=head.next;
		}
		return fake.next;
	}

	private static ListNode reverse(ListNode pre, ListNode next)
	{
		ListNode last=pre.next;
		ListNode ptr=last.next;
		while (ptr!=next)
		{
			last.next=ptr.next;
			ptr.next=pre.next;
			pre.next=ptr;
			ptr=last.next;
		}
		return last;
	}
}
