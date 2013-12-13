package Leetcode;

public class SearchRotatedSortedArray {

	public static void main(String[] args) {
		int[] A = new int[] { 5, 1, 3 };
		int target = 5;
		System.out.println(search(A, target));
	}

	public static int search(int[] A, int target) {
		int ret = -1;
		int pivot = findPivot(A, 0, A.length - 1);
		System.out.println("pivot=" + pivot);
		if (pivot == -1) return binarySearch(A, 0, A.length - 1, target);
		ret = (target >= A[0] && target <= A[pivot]) ? binarySearch(A, 0,
				pivot, target) : binarySearch(A, pivot + 1, A.length - 1,
				target);
		return ret;
	}

	private static int binarySearch(int[] A, int begin, int end, int target) {
		if (begin > end) return -1;
		int mid = (begin + end) / 2;
		if (A[mid] == target) return mid;
		if (A[mid] > target) return binarySearch(A, begin, mid - 1, target);
		else return binarySearch(A, mid + 1, end, target);
	}

	private static int findPivot(int[] A, int begin, int end) {
		if (begin > end) return -1;
		if (begin == end) return begin;
		int mid = (begin + end) / 2;
		if (A[mid] >= A[begin]) {
			if (A[mid + 1] < A[begin]) return mid;
			return findPivot(A, mid + 1, end);
		} else return findPivot(A, begin, mid - 1);
	}

}
