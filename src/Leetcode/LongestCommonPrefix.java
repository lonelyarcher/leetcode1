package Leetcode;

public class LongestCommonPrefix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strs = new String[] { "abc", "abcd", "ab" };
		System.out.println(longestCommonPrefix(strs));

	}

	public static String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0) return "";
		String p = strs[0];
		for (int i = 1; i < strs.length; i++) {
			p = helper(p, strs[i]);
		}
		return p;
	}

	private static String helper(String p, String s) {
		for (int i = 0; i < p.length(); i++) {
			if (i == s.length() || p.charAt(i) != s.charAt(i)) return p
					.substring(0, i);
			if (p.length() == 1) break;
		}
		return p;
	}

}
