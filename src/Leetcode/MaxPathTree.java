package Leetcode;

import Leetcode.customerDataType.TreeNode;

public class MaxPathTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		TreeNode root1 = new TreeNode(5);
		TreeNode root2 = new TreeNode(5);
		root.left = root1;
		root.right = root2;
		MaxPathTree mpt = new MaxPathTree();
		System.out.println(mpt.maxPathSum(root));
	}

	public int maxPathSum(TreeNode root) {
		int[] max = helper(root);
		return max[0];
	}

	public static int[] helper(TreeNode root) {
		int leftMaxPath, rightMaxPath;
		int[] max = { Integer.MIN_VALUE, 0 };
		if (root == null)
			return max;

		int[] left = helper(root.left);
		int[] right = helper(root.right);

		leftMaxPath = Math.max(left[1], 0);
		rightMaxPath = Math.max(right[1], 0);
		max[1] = Math.max(leftMaxPath + root.val, rightMaxPath + root.val);
		max[0] = Math.max(Math.max(left[0], right[0]), root.val + leftMaxPath
				+ rightMaxPath);

		return max;
	}
}
