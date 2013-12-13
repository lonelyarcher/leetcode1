package Leetcode;

import java.util.HashSet;

public class LongestStringWithoutRepeat {

	public static void main(String[] args) {
		LongestStringWithoutRepeat s = new LongestStringWithoutRepeat();
		String str = "aaaabca";
		System.out.println(s.lengthOfLongestSubstring(str));

	}

	public int lengthOfLongestSubstring(String s) {
		if (s == null) return 0;
		int max = 0;
		int head = 0;
		int tail = 0;
		HashSet<Character> hs = new HashSet<Character>();
		while (tail < s.length()) {
			System.out.println(hs.toString());
			if (!hs.contains(s.charAt(tail))) {
				hs.add(s.charAt(tail));
			} else {
				max = Math.max(max, tail - head);
				while (s.charAt(head) != s.charAt(tail)) {
					hs.remove(s.charAt(head));
					head++;
				}
				head++;
			}
			tail++;
		}
		max = Math.max(max, tail - head);
		return max;

	}
}
