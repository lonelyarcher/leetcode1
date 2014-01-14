package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;

public class PermutationII
{

	public static void main(String[] args)
	{
		int[] num=new int[]{1,2,2};
		ArrayList<ArrayList<Integer>> ret=permuteUnique(num);
		for (ArrayList<Integer> arr : ret)
		{
			for (int i : arr)
			{
				System.out.print(i+" ");
			}
			System.out.println();
		}

	}

	public static ArrayList<ArrayList<Integer>> permuteUnique(int[] num)
	{
		HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
		for (int n : num)
		{
			if(!map.containsKey(n)) map.put(n, 1);
			else map.put(n, map.get(n)+1);
		}
		ArrayList<ArrayList<Integer>> ret=new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> p=new ArrayList<Integer>();
		permute(map, p, ret);
		return ret;
	}

	private static void permute(HashMap<Integer, Integer> map,
			ArrayList<Integer> p, ArrayList<ArrayList<Integer>> ret)
	{
		if(map.size()==0)
		{
			ret.add(p);
			return;
		}
		for (Integer i : map.keySet())
		{
			HashMap<Integer, Integer> newMap=new HashMap<Integer, Integer>();
			newMap.putAll(map);
			ArrayList<Integer> newP=new ArrayList<Integer>();
			newP.addAll(p);
			newP.add(i);
			if(newMap.get(i)==1) newMap.remove(i);
			else newMap.put(i, newMap.get(i)-1);
			permute(newMap, newP, ret);
		}

	}

}
