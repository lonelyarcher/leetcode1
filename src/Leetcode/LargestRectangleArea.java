package Leetcode;

public class LargestRectangleArea {

	public static void main(String[] args) {
		LargestRectangleArea lra = new LargestRectangleArea();
		System.out.println(lra.largestRectangleArea(new int[] { 999, 999, 999,
				999, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
				1, 1, 1 }));

	}

	public int largestRectangleArea(int[] height) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		// Dynamic programming
		if (height == null || height.length == 0)
			return 0;
		int max = height[0];
		for (int i = 1; i < height.length; i++) {

			int prevHeight = height[i];
			int prevArea = height[i];
			int ptr = i - 1;
			while (ptr >= 0 && height[ptr] > 0) {
				if (height[ptr] >= prevHeight)
					prevArea += prevHeight;
				else {
					max = Math.max(prevArea, max);
					prevHeight = height[ptr];
					prevArea = prevHeight;
				}
				ptr--;
			}
			max = Math.max(prevArea, max);

		}
		return max;
	}

}
