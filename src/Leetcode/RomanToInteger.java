package Leetcode;

public class RomanToInteger {
	public static void main(String[] args) {
		System.out.println(romanToInt("MMMXLV"));

	}

	public static int romanToInt(String s) {
		int[] ds = new int[] { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5,
				4, 1 };
		String[] rs = new String[] { "M", "CM", "D", "CD", "C", "XC", "L",
				"XL", "X", "IX", "V", "IV", "I" };
		int ret = 0;

		int ptr = 0;
		int i = 0;
		while (ptr < s.length()) {
			while (s.matches("^.{" + ptr + "}" + rs[i] + ".*$")) {
				ret += ds[i];
				ptr += rs[i].length();
			}
			i++;
		}

		return ret;
	}

}
