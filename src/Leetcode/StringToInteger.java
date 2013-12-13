package Leetcode;
public class StringToInteger {
	public static void main(String[] args) {
		String max = Integer.toString((int) (Math.pow(2, 31) - 1));
		String min = Integer.toString((int) ((int) (Math.pow(2, 31) * (-1))));
		System.out.println("Max=" + max);
		System.out.println("Min=" + min);
		String str = "-2147483648";
		System.out.println(atoi(str));

	}

	public static int atoi(String str) {
		if (str == null) return 0;
		str = str.trim();
		if (str.length() == 0) return 0;
		String sign = "";
		if (str.charAt(0) == '-') sign = "-";
		if (str.charAt(0) == '+' || str.charAt(0) == '-') str = str
				.substring(1);
		if (str.length() == 0) return 0;

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			if (Character.isDigit(str.charAt(i))) {
				sb.append(str.charAt(i));
			} else break;
		}
		if (sb.length() == 0) return 0;

		String max = Integer.toString(Integer.MAX_VALUE);
		String min = Integer.toString(Integer.MIN_VALUE);

		if (sb.length() > max.length()) return (sign == "") ? Integer.MAX_VALUE
				: Integer.MIN_VALUE;
		if (sb.length() == max.length()) {
			if (sign == "" && compareStrings(sb.toString(), max) > 0) return Integer.MAX_VALUE;
			if (sign == "-"
					&& compareStrings(sb.toString(), min.substring(1)) > 0) return Integer.MIN_VALUE;
		}

		return Integer.parseInt(sign + sb.toString());

	}

	private static int compareStrings(String left, String right) {
		for (int i = 0; i < left.length(); i++) {
			if (left.charAt(i) > right.charAt(i)) return 1;
			if (left.charAt(i) < right.charAt(i)) return -1;
		}
		return 0;
	}
}
