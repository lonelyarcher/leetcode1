package Leetcode;

import java.util.ArrayList;
import java.util.Stack;

import Leetcode.customerDataType.TreeNode;

public class PreorderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static ArrayList<Integer> preorderTraversal(TreeNode root) {
		ArrayList<Integer> tree = new ArrayList<Integer>();
		preorder(root, tree);
		return tree;

	}

	public static void preorder(TreeNode root, ArrayList<Integer> tree) {

		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode t = stack.pop();
			tree.add(t.val);
			if (t.right != null)
				stack.push(t.right);
			if (t.left != null)
				stack.push(t.left);
		}
	}

}
