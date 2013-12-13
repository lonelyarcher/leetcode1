package Leetcode;
import java.util.concurrent.ConcurrentHashMap;

public class LongestConsecutiveSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestConsecutiveSequence lcs = new LongestConsecutiveSequence();
		int[] num = { 1, 2, 3, 4, 5, 10 };
		System.out.println(lcs.longestConsecutive(num));

	}

	public int longestConsecutive(int[] num) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		ConcurrentHashMap<Integer, Integer> hs = new ConcurrentHashMap<Integer, Integer>();
		int longest = 0;
		for (int i : num)
			hs.put(i, 1);

		for (Integer key : hs.keySet())
			System.out.print(key + ",");

		for (Integer key : hs.keySet()) {
			System.out.println("key=" + key);
			int length = 1;
			hs.remove(key);
			int front = key;
			int end = key;
			while (hs.containsKey(++front)) {
				length++;
				hs.remove(front);
				System.out.println("removeFront:" + front);
			}
			while (hs.containsKey(--end)) {
				length++;
				hs.remove(end);
				System.out.println("removeEnd:" + end);
			}
			System.out.println("length=" + length);
			longest = Math.max(longest, length);
		}

		return longest;

	}
}
