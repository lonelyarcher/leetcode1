package Leetcode;
import java.util.ArrayList;
import java.util.LinkedList;

public class Permutation {
	public ArrayList<ArrayList<Integer>> permute(int[] num) {
		int n = num.length;
		ArrayList<LinkedList<Integer>>[] ret = new ArrayList[n];
		ArrayList<ArrayList<Integer>> retArray = new ArrayList<ArrayList<Integer>>();

		ret[0] = new ArrayList<LinkedList<Integer>>();
		LinkedList<Integer> a = new LinkedList<Integer>();
		a.add(num[0]);
		ret[0].add(a);
		System.out.println(ret[0].toString());
		for (int i = 1; i < n; i++) {
			ret[i] = new ArrayList<LinkedList<Integer>>();
			for (LinkedList<Integer> ar : ret[i - 1]) {
				// System.out.println(ar.size());
				for (int j = 0; j <= ar.size(); j++) {
					ar.add(j, num[i]);
					// System.out.println(ar.toString());
					ret[i].add(ar);
					System.out.println(ret[i].toString());
					ar.remove(j);
				}

			}
			System.out.println("ret" + ret[i].toString());
		}

		for (LinkedList<Integer> ar : ret[n - 1]) {
			retArray.add((new ArrayList<Integer>(ar)));
		}
		return retArray;
	}

	public static void main(String[] args) {
		int[] a = { 1, 2, 3 };
		ArrayList<ArrayList<Integer>> arr = new Permutation().permute(a);
		for (ArrayList<Integer> ar : arr) {
			for (Integer i : ar) {
				// System.out.print(i + ",");
			}
			// System.out.println();

		}
	}

}
