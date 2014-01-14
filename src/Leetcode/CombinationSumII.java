package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CombinationSumII
{

	public static void main(String[] args)
	{
		int[] candidates=new int[]{2,3,8,4,5,1};
		int target=6;
		for (ArrayList<Integer> a : combinationSum2(candidates, target))
		{
			for (Integer n : a)
				System.out.print(n+" ");
			System.out.println();
		}

	}

	public static ArrayList<ArrayList<Integer>> combinationSum2(int[] num,
			int target)
	{
		ArrayList<ArrayList<Integer>> ret=new ArrayList<ArrayList<Integer>>();
		HashMap<Integer, Integer> cand=new HashMap<Integer, Integer>();
		for (int i=0; i<num.length; i++)
		{
			if(!cand.containsKey(num[i])) cand.put(num[i], 1);
			else cand.put(num[i], cand.get(num[i])+1);
		}
		ArrayList<Integer> comb=new ArrayList<Integer>();
		helper(cand, target, comb, 0, 0, ret);
		return ret;
	}

	private static void helper(HashMap<Integer, Integer> cand, int target,
			ArrayList<Integer> comb, int last, int count,
			ArrayList<ArrayList<Integer>> ret)
	{
		HashMap<Integer, Integer> temp=new HashMap<Integer, Integer>();
		temp.putAll(cand);
		for (Map.Entry<Integer, Integer> entry : cand.entrySet())
		{
			int key=entry.getKey();
			int value=entry.getValue();
			if(key>=last&&value>0&&key+count<=target)
			{
				ArrayList<Integer> newComb=new ArrayList<Integer>();
				newComb.addAll(comb);
				newComb.add(key);
				entry.setValue(value-1);
				if(key+count==target) ret.add(newComb);
				else if(key+count<target) helper(cand, target, newComb, key,
						key+count, ret);
			}
		}//for
		for (Integer key : cand.keySet())
			cand.put(key, temp.get(key));
		return;
	}//helper

}
