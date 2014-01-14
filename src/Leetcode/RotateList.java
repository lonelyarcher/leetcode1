package Leetcode;

import Leetcode.customerDataType.ListNode;

public class RotateList
{

	public static void main(String[] args)
	{
		ListNode head=new ListNode(1);
		int n=99;
		ListNode l=new RotateList().rotateRight(head, n);
		while (l!=null)
		{
			System.out.println(l.val);
			l=l.next;
		}

	}

	public ListNode rotateRight(ListNode head, int n)
	{
		ListNode fake=new ListNode(0);
		fake.next=head;
		ListNode end=head;
		int i=1;
		if(head==null) return null;
		while (head.next!=null)
		{
			i++;
			head=head.next;
		}
		int j=1;
		while (j<i-n%i)
		{
			j++;
			end=end.next;
		}
		head.next=fake.next;
		fake.next=end.next;
		end.next=null;
		return fake.next;
	}

}
