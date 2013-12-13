package Leetcode;
public class PalindromeNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPalindrome(1294664921));

	}

	public static boolean isPalindrome(int x) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		if (x < 0)
			return false;
		int length = 0;
		long d = 0;
		for (long i = 1; x / i >= 1; i *= 10) { // if i type int, pow(10,11)
												// will out of int range
			d = i;
			length++;
		}
		for (int i = 1; i <= length / 2; i++) {
			int left = (int) (x / d) % 10;
			int right = x % 10;
			if (left != right)
				return false;
			x = x / 10;
			d = d / 100;
		}
		return true;

	}
}
