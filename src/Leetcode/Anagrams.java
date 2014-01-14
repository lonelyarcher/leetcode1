package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Anagrams
{

	public static void main(String[] args)
	{
		//String[] strs=new String[]{"ana","aan","bbc","abc","naa","xyz","123",	"cbb"};
		String[] strs=new String[]{"",""};
		for (String s : anagrams(strs))
			System.out.print(s+"||");

	}

	public static ArrayList<String> anagrams(String[] strs)
	{
		ArrayList<String> ret=new ArrayList<String>();
		HashMap<String, String> map=new HashMap<String, String>();
		HashMap<String, ArrayList<String>> ana=new HashMap<String, ArrayList<String>>();
		for (String s : strs)
		{
			char[] chs=s.toCharArray();
			Arrays.sort(chs);
			String ss=String.valueOf(chs);
			if(!map.containsKey(ss)) map.put(ss, s);
			else
			{
				if(!ana.containsKey(ss))
				{
					ArrayList<String> temp=new ArrayList<String>();
					temp.add(map.get(ss));
					temp.add(s);
					ana.put(ss, temp);
				}
				else ana.get(ss).add(s);
			}
		}
		for (ArrayList<String> arr : ana.values())
			ret.addAll(arr);
		return ret;
	}
}
