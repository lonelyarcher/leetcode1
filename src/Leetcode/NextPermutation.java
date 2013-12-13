package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NextPermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = new int[] { 1, 3, 2 };
		nextPermutation(num);
		for (int i : num)
			System.out.print(i + ",");
	}

	public static void nextPermutation(int[] num) {
		int n = num.length;
		boolean unable = true;
		List<Integer> list = new ArrayList<Integer>();
		list.add(num[n - 1]);
		int changePoint = 0;
		for (int i = n - 2; i >= 0; i--) {
			if (num[i] < num[i + 1]) {
				num[i] = findNext(list, num[i]);
				unable = false;
				changePoint = i;
				break;
			}
			list.add(num[i]);
		}
		if (unable) {
			Arrays.sort(num);
		} else {
			for (int i = changePoint + 1; i < n; i++) {
				num[i] = list.get(i - changePoint - 1);
			}

		}

	}

	public static int findNext(List<Integer> list, int x) {
		Collections.sort(list);
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) > x) {
				int ret = list.get(i);
				list.set(i, x);
				return ret;
			}
		}

		return x;
	}
}
