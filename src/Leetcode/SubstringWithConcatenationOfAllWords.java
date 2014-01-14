package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;

public class SubstringWithConcatenationOfAllWords
{
	public static void main(String[] args)
	{
		String s="abaababbaba";
		String[] l=new String[]{"ab","ba","ab","ba"};
		for (int i : findSubstring(s, l))
			System.out.println(i);
	}

	public static ArrayList<Integer> findSubstring(String S, String[] L)
	{
		ArrayList<Integer> ret=new ArrayList<Integer>();
		int n=L[0].length();
		int m=L.length;
		if(S.isEmpty()||L.length==0||S.length()<n||n==0) return ret;
		HashMap<String, Integer> map=new HashMap<String, Integer>();

		for (String s : L)
		{
			if(map.containsKey(s)) map.put(s, map.get(s)+1);
			else map.put(s, 1);
		}

		for (int base=0; base<n; base++)
		{
			int front=base;
			int end=base;
			int count=0;
			HashMap<String, Integer> fill=new HashMap<String, Integer>();
			while (front<=S.length()-n)
			{

				String temp=S.substring(front, front+n);
				if(!map.containsKey(temp))
				{
					fill.clear();
					count=0;
					end=front+n;
				}
				else
				{
					if(fill.containsKey(temp))
					{
						fill.put(temp, fill.get(temp)+1);
						while (fill.get(temp)>map.get(temp))
						{
							String temp2=S.substring(end, end+n);
							reduce(fill, temp2);
							end+=n;
							count--;
						}
					}
					else fill.put(temp, 1);
					count++;
				}

				if(count==m)
				{
					ret.add(end);
					String temp2=S.substring(end, end+n);
					System.out.println("temp2="+temp2);
					reduce(fill, temp2);
					end+=n;
					count--;
				}
				front+=n;
			}

		}
		return ret;
	}

	private static void reduce(HashMap<String, Integer> map, String temp)
	{
		int n=map.get(temp);
		if(n>1) map.put(temp, n-1);
		else map.remove(temp);
	}
}
