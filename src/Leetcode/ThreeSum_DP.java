package Leetcode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ThreeSum_DP {

	public static void main(String[] args) {

		ThreeSum_DP tj = new ThreeSum_DP();

		int[] num = { 1, -1, 0, -2, 2, 1, -1 };
		ArrayList<ArrayList<Integer>> a = tj.threeSum(num);
		for (int i = 0; i < a.size(); i++) {
			System.out.println(a.get(i).toString());
		}

	}

	public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.

		ArrayList<ArrayList<Integer>> oneCombinations = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> twoCombinations = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> threeSum = new ArrayList<ArrayList<Integer>>();

		if (num.length < 3)
			return null;

		oneCombinations.add(new ArrayList<Integer>(Arrays.asList(num[0])));
		oneCombinations.add(new ArrayList<Integer>(Arrays.asList(num[1])));
		oneCombinations.add(new ArrayList<Integer>(Arrays.asList(num[2])));

		twoCombinations.add(new ArrayList<Integer>(Arrays
				.asList(num[0], num[1])));
		twoCombinations.add(new ArrayList<Integer>(Arrays
				.asList(num[1], num[2])));
		twoCombinations.add(new ArrayList<Integer>(Arrays
				.asList(num[0], num[2])));

		if (num[0] + num[1] + num[2] == 0) {
			ArrayList<Integer> a = new ArrayList<Integer>(Arrays.asList(num[0],
					num[1], num[2]));
			Collections.sort(a);
			threeSum.add(a);
		}

		if (num.length == 3)
			return threeSum;

		for (int i = 4; i < num.length; i++) {
			oneCombinations.add(new ArrayList<Integer>(Arrays.asList(num[i])));
			for (int j = 0; j < oneCombinations.size(); j++) {

				ArrayList<Integer> a = new ArrayList<Integer>();
				a.add(oneCombinations.get(j).get(0));
				a.add(num[i]);
				twoCombinations.add(a);
			}
			for (int j = 0; j < twoCombinations.size(); j++) {
				if (twoCombinations.get(j).get(0)
						+ twoCombinations.get(j).get(1) + num[i] == 0) {
					ArrayList<Integer> a = new ArrayList<Integer>(
							Arrays.asList(twoCombinations.get(j).get(0),
									twoCombinations.get(j).get(1), num[i]));
					Collections.sort(a);
					if (!threeSum.contains(a))
						threeSum.add(a);
				}

			}

		}

		return threeSum;

	}

}
