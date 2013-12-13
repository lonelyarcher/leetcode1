package Leetcode;

public class RegularExpressionMatch {
	public static void main(String[] args) {
		String s = "a";
		String p = "ab*";
		System.out.println(isMatch(s, p));

	}

	public static boolean isMatch(String s, String p) {
		if (p.length() == 0) return s.length() == 0;
		return helper(s, p, 0, 0);
	}

	private static boolean helper(String s, String p, int i, int j) {
		if (j >= p.length()) return i >= s.length();

		assert (p.charAt(j) != '*');
		if (j == p.length() - 1 || p.charAt(j + 1) != '*') {
			if (i > s.length() - 1) return false;
			if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') return helper(
					s, p, i + 1, j + 1);
			else return false;
		} else {
			if (helper(s, p, i, j + 2)) return true;

			for (int repeat = 1; repeat <= s.length() - i; repeat++) {
				if (s.charAt(i + repeat - 1) == p.charAt(j)
						|| p.charAt(j) == '.') {
					if (helper(s, p, i + repeat, j + 2)) return true;
				} else break;
			}

		}
		return false;
	}
}
