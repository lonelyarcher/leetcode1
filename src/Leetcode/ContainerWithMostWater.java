package Leetcode;

import java.util.ArrayList;

public class ContainerWithMostWater {

	public static void main(String[] args) {
		int[] height = new int[] { 1, 1 };
		System.out.println(maxArea(height));

	}

	public static int maxArea(int[] height) {
		ArrayList<int[]> left = new ArrayList<int[]>();
		int l = height[0];
		left.add(new int[] { 0, l });
		for (int i = 1; i < height.length - 1; i++) {
			if (height[i] > l) {
				int[] temp = new int[] { i, height[i] };
				left.add(temp);
				l = height[i];
			}
		}

		ArrayList<int[]> right = new ArrayList<int[]>();
		int r = height[height.length - 1];
		right.add(new int[] { height.length - 1, r });
		for (int i = height.length - 2; i > 0; i--) {
			if (height[i] > r) {
				int[] temp = new int[] { i, height[i] };
				right.add(temp);
				r = height[i];
			}
		}

		int water = 0;
		for (int[] ll : left) {
			int i = 0;
			while (i < right.size() && right.get(i)[0] > ll[0]) {
				int area = Math.min(ll[1], right.get(i)[1])
						* (right.get(i)[0] - ll[0]);
				water = Math.max(water, area);
				System.out.println(ll[0] + " X " + right.get(i)[0] + " = "
						+ area);
				i++;
			}
		}

		return water;
	}
}
