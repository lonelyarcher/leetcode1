package Leetcode;

import java.util.Arrays;

public class ThreeSumClosest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] s = new int[] { 0, 5, -1, -2, 4, -1, 0, -3, 4, -5 };
		System.out.println(threeSumClosest(s, 1));

	}

	public static int threeSumClosest(int[] num, int target) {
		assert (num.length >= 3);
		int closest = Math.abs(num[0] + num[1] + num[2] - target);
		int closestValue = num[0] + num[1] + num[2];
		Arrays.sort(num);
		for (int i = 0; i < num.length - 2; i++) {
			int j = i + 1;
			int k = num.length - 1;
			while (j < k) {
				int dis = num[i] + num[j] + num[k] - target;
				if (Math.abs(dis) < closest) {
					closest = Math.abs(dis);
					closestValue = num[i] + num[j] + num[k];
				}
				if (num[i] + num[j] + num[k] - target > 0) k--;
				else j++;
			}
		}
		return closestValue;
	}

}
