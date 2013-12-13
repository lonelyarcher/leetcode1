package Leetcode;

import java.util.HashMap;

public class TwoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers = new int[] { 5, 75, 25 };
		int[] twoSum = twoSum(numbers, 100);
		System.out.println(twoSum[0] + "   " + twoSum[1]);

	}

	public static int[] twoSum(int[] numbers, int target) {
		/*
		 * find pairs from collection or array problem, we can add and search
		 * one by one, it is same as add all then search, but it was convenient.
		 */
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		for (int i = 0; i < numbers.length; i++) {
			if (hm.containsKey(target - numbers[i])) {
				return new int[] { hm.get(target - numbers[i]) + 1, i + 1 };
			} else {
				hm.put(numbers[i], i);
			}
		}
		return null;

	}

}
