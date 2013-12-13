package Leetcode;

public class MedianOfTwoSortedArray {

	public static void main(String[] args) {
		int[] A = new int[] {};
		;
		int[] B = new int[] { 2, 3 };
		double median = findMedianSortedArrays2(A, B);
		System.out.println("Median=" + median);
	}

	public static double findMedianSortedArrays2(int A[], int B[]) {
		int m = A.length;
		int n = B.length;
		int half = (m + n) / 2;

		if (m == 0) return (n % 2 == 1) ? B[n / 2]
				: (double) (B[n / 2] + B[n / 2 - 1]) / 2.0;
		if (n == 0) return (m % 2 == 1) ? A[m / 2]
				: (double) (A[m / 2] + A[m / 2 - 1]) / 2.0;

		int ret = bsearch(A, B, Math.max(0, half - n),
				Math.min(m - 1, m - (half - n)));
		if (ret == -1) {
			System.out.println("swap to B");
			int[] temp = A;
			A = B;
			B = temp;
			ret = bsearch(A, B, Math.max(0, half - m),
					Math.min(n - 1, n - (half - m)));
		}

		System.out.println("ret=" + ret);

		if ((m + n) % 2 == 1) return A[ret];
		else {
			if (ret == 0) return (A[ret] + B[(m + n) / 2 - 1]) / 2.0;
			if ((m + n) / 2 == ret) return (double) (A[ret] + A[ret - 1]) / 2.0;
			if (A[ret - 1] >= B[(m + n) / 2 - ret - 1]) return (double) (A[ret] + A[ret - 1]) / 2.0;
			else return (double) (A[ret] + B[(m + n) / 2 - ret - 1]) / 2.0;
		}

	}

	private static int bsearch(int[] A, int[] B, int min, int max) {
		System.out.println("min=" + min + "  max=" + max);
		if (min > max) return -1;
		int n = A.length + B.length;
		int a = (max + min) / 2;
		int b = n / 2 - a;

		if (b == 0) {
			if (A[a] <= B[0]) return a;
			else return bsearch(A, B, min, a - 1);
		}

		if (b == B.length) {
			if (A[a] >= B[B.length - 1]) return a;
			else return bsearch(A, B, a + 1, max);
		}

		System.out.println("b=" + b);

		if (A[a] >= B[b - 1] && A[a] <= B[b]) return a;
		else if (A[a] < B[b - 1]) return bsearch(A, B, a + 1, max);
		else return bsearch(A, B, min, a - 1);
	}
}
