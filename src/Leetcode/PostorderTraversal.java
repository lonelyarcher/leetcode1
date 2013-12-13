package Leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

import Leetcode.customerDataType.TreeNode;

public class PostorderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root0 = new TreeNode(0);
		TreeNode root1 = new TreeNode(1);
		TreeNode root2 = new TreeNode(2);
		TreeNode root3 = new TreeNode(3);
		TreeNode root4 = new TreeNode(4);
		TreeNode root5 = new TreeNode(5);
		root0.left = root1;
		root0.right = root2;
		root1.left = root3;
		root1.right = root4;
		root4.right = root5;
		ArrayList<Integer> res = postorderTraversal(root0);
		for (int i : res)
			System.out.println(i + ",");

	}

	public static ArrayList<Integer> postorderTraversal(TreeNode root) {
		ArrayList<Integer> ret = new ArrayList<Integer>();
		if (root == null)
			return ret;
		postorderByRecursion(root, ret);

		return ret;
	}

	public static void postorderByRecursion(TreeNode root,
			ArrayList<Integer> ret) {
		if (root == null)
			return;
		postorderByRecursion(root.left, ret);
		postorderByRecursion(root.right, ret);
		ret.add(root.val);
	}

	public static ArrayList<Integer> postorderByIterative(TreeNode root) {
		ArrayList<Integer> ret = new ArrayList<Integer>();
		HashSet<TreeNode> visited = new HashSet<TreeNode>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		if (root == null)
			return ret;
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode t = stack.peek();
			if (visited.contains(t)) {
				ret.add(t.val);
				stack.pop();
			} else {
				if (t.right != null)
					stack.push(t.right);
				if (t.left != null)
					stack.push(t.left);
				if (t.right == null && t.left == null) {
					ret.add(t.val);
					stack.pop();
				} else
					visited.add(t);
			}
		}
		return ret;

	}

}
