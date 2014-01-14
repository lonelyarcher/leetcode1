package Leetcode;

public class ImplementStrStr
{

	public static void main(String[] args)
	{
		String haystack="abcaaaaa";
		String needle="aaa";
		System.out.println(strStr(haystack, needle));

	}

	public static String strStr(String haystack, String needle)
	{

		if(needle.isEmpty()) return haystack;
		if(haystack.length()<needle.length()) return null;
		for (int i=0; i<haystack.length(); i++)
		{
			if(match(haystack, i, needle)) return haystack.substring(i);
		}
		return null;
	}

	private static boolean match(String haystack, int i, String needle)
	{
		if(haystack.length()-i<needle.length()) return false;
		for (int j=0; j<needle.length(); j++)
		{
			if(haystack.charAt(i+j)!=needle.charAt(j)) return false;
		}
		return true;
	}

}
