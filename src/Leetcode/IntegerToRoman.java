package Leetcode;

public class IntegerToRoman {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(intToRoman(2637));
	}

	public static String intToRoman(int num) {
		assert (num <= 3999 && num >= 1);
		StringBuilder roman = new StringBuilder();
		int[] ds = new int[] { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5,
				4, 1 };
		String[] rs = new String[] { "M", "CM", "D", "CD", "C", "XC", "L",
				"XL", "X", "IX", "V", "IV", "I" };
		for (int i = 0; i < ds.length; i++) {
			int times = num / ds[i];
			for (int j = 0; j < times; j++)
				roman.append(rs[i]);
			num = num - times * ds[i];
		}
		return roman.toString();
	}
}
