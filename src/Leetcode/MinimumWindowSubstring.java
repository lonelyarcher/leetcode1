package Leetcode;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring
{

	public static void main(String[] args)
	{
		String S="ADOBECODEBANC";
		String T="ABC";
		System.out.println(minWindow(S, T));
	}

	public static String minWindow(String S, String T)
	{
		int m=S.length();
		int n=T.length();
		Map<Character, Integer> needFind=new HashMap<Character, Integer>();
		Map<Character, Integer> hasFound=new HashMap<Character, Integer>();
		for (int i=0; i<T.length(); i++)
		{
			char c=T.charAt(i);
			hasFound.put(c, 0);
			if(!needFind.containsKey(c)) needFind.put(c, 1);
			else needFind.put(c, needFind.get(c)+1);
		}

		int minLength=Integer.MAX_VALUE;
		int minLeft=0;
		int right=0;
		int left=0;
		int count=0;
		while (right<m)
		{
			char r=S.charAt(right);
			if(needFind.containsKey(r))
			{
				if(hasFound.get(r)<needFind.get(r)) count++;
				hasFound.put(r, hasFound.get(r)+1);
				if(count==n)
				{
					char l=S.charAt(left);
					while ((!hasFound.containsKey(l))
							||hasFound.get(l)>needFind.get(l))
					{
						if(hasFound.containsKey(l)) hasFound.put(l,
								hasFound.get(l)-1);
						l=S.charAt(++left);
					}
					System.out.println("match "+left+" "+right);
					if(right-left+1<minLength)
					{
						minLength=right-left+1;
						minLeft=left;
					}
					hasFound.put(l, hasFound.get(l)-1);
					count--;
					left++;
				}
			}
			right++;
		}
		if(minLength==Integer.MAX_VALUE) return "";
		return S.substring(minLeft, minLeft+minLength);
	}
}
