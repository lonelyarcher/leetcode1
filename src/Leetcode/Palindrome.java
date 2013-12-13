package Leetcode;
public class Palindrome {

	public String longestPalindrome(String s) {
		String ss = preprocess(s);
		char[] cs = ss.toCharArray();
		int n = cs.length;
		int[] P = new int[n];
		int c;
		int maxIndex, maxLength;
		P[0] = 0;
		P[1] = 1;
		c = 1;
		maxIndex = 1;
		maxLength = 1;
		for (int i = 2; i < n - 1; i++) {
			int mirror = c - (i - c);
			int front = c + P[c];
			if (i > front)
				P[i] = 1;
			else
				P[i] = Math.min(P[mirror], front - i);
			while ((i - P[i] - 1 >= 0 && i + P[i] + 1 < n)
					&& cs[i + P[i] + 1] == cs[i - P[i] - 1]) {
				P[i]++;
			}
			if (i + P[i] > front) {
				c = i;
				front = c + P[c];
			}
			if (P[i] > P[maxIndex]) {
				maxIndex = i;
				maxLength = P[i];
			}

		}
		StringBuilder sb = new StringBuilder();
		for (int i = maxIndex - maxLength; i <= maxIndex + maxLength; i++) {
			if (!(cs[i] == '#'))
				sb.append(cs[i]);
		}

		return sb.toString();

	}

	public static String preprocess(String s) {
		char[] chars = s.toCharArray();
		StringBuilder ret = new StringBuilder("#");
		for (char ch : chars) {
			ret = ret.append(ch).append("#");
		}
		return ret.toString();
	}

}
