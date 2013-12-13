package Leetcode;
class TreeLinkNode {
	int val;
	TreeLinkNode left, right, next;

	TreeLinkNode(int x) {
		val = x;
	}
}

public class RightNodePointer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TreeLinkNode t1 = new TreeLinkNode(1);
		TreeLinkNode t2 = new TreeLinkNode(2);
		TreeLinkNode t3 = new TreeLinkNode(3);
		TreeLinkNode t4 = new TreeLinkNode(4);
		TreeLinkNode t5 = new TreeLinkNode(5);
		TreeLinkNode t6 = new TreeLinkNode(6);
		TreeLinkNode t7 = new TreeLinkNode(7);
		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t2.right = t5;
		t3.left = t6;
		t3.right = t7;
		connect(t1);

		System.out.println(t5.next.val + "  t6 is next to t5");

		System.out.println(t2.next.val + "  t2 is next to t3");
		if (t3.next == null)
			System.out.println("t3 is the rightest");

	}

	public static void connect(TreeLinkNode root) {
		while (root != null) {
			TreeLinkNode ptr = root;
			while (ptr != null) {
				if (ptr.left != null) {
					ptr.left.next = ptr.right;
					if (ptr.next != null)
						ptr.right.next = ptr.next.left;
					else
						ptr.right.next = null;
				}
				ptr = ptr.next;
			}
			root = root.left;
		}

	}
}
