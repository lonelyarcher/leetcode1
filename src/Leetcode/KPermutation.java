package Leetcode;
import java.util.ArrayList;

public class KPermutation {
	public String getPermutation(int n, int k) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.

		ArrayList<Integer> digits = new ArrayList<Integer>(n);
		int[] factorials = new int[n + 1];
		factorials[0] = 1;
		for (int i = 1; i <= n; i++) {
			digits.add(i);
			factorials[i] = factorials[i - 1] * i;
		}

		StringBuilder rets = new StringBuilder();
		for (int i = n; i >= 1; i--) {
			int mod = k % factorials[i - 1];
			int digit = k / factorials[i - 1];
			if (mod != 0) {
				digit++;
				k = mod;
			} else {
				k = factorials[i - 1];
			}
			rets.append(digits.get(digit - 1));
			digits.remove(digits.get(digit - 1));

		}
		return rets.toString();
	}

}
