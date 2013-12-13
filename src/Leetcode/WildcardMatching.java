package Leetcode;

public class WildcardMatching {

	public static void main(String[] args) {
		String s = "babaaababaabababbbbbbaabaabbabababbaababbaaabbbaaab";

		String p = "***bba**a*bbba**aab**b";
		System.out.println(isMatch(s, p));

	}

	public static boolean isMatch(String s, String p) {
		p = p.replaceAll("\\*+", "*");
		if (p.length() == 0) return s.length() == 0;
		if (s.length() == 0) return p == "*";
		if (s.charAt(s.length() - 1) != p.charAt(p.length() - 1)
				&& p.charAt(p.length() - 1) != '*') return false;
		p = p.replaceAll("\\*+", "*");
		//System.out.println(p);
		return helper(s, p, 0, 0);

	}

	private static boolean helper(String s, String p, int i, int j) {
		if (j >= p.length()) return i >= s.length();
		if (p.charAt(j) != '*') {
			if (i >= s.length()) return false;
			if (p.charAt(j) == s.charAt(i) || p.charAt(j) == '?') return helper(
					s, p, i + 1, j + 1);
			else return false;
		} else {
			int pp = p.substring(j).replaceAll("\\*", "").length();
			for (int k = 0; k <= s.length() - i - pp; k++) {
				if (helper(s, p, i + k, j + 1)) return true;
			}
			return false;
		}
	}

}
