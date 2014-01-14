package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class CombinationSum
{

	public static void main(String[] args)
	{
		int[] candidates=new int[]{2,3,8,4};
		int target=6;
		for (ArrayList<Integer> a : combinationSum(candidates, target))
		{
			for (Integer n : a)
				System.out.print(n+" ");
			System.out.println();
		}

	}

	public static ArrayList<ArrayList<Integer>> combinationSum(
			int[] candidates, int target)
	{
		ArrayList<ArrayList<Integer>> ret=new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> cand=new ArrayList<Integer>();
		Arrays.sort(candidates);
		if(candidates.length==0) return ret;
		cand.add(candidates[0]);
		int prev=candidates[0];
		for (int i=1; i<candidates.length; i++)
		{
			if(candidates[i]!=prev)
			{
				cand.add(candidates[i]);
				prev=candidates[i];
			}
		}
		ArrayList<Integer> comb=new ArrayList<Integer>();
		helper(cand, target, comb, 0, 0, ret);
		return ret;
	}

	private static void helper(ArrayList<Integer> cand, int target,
			ArrayList<Integer> comb, int last, int count,
			ArrayList<ArrayList<Integer>> ret)
	{
		for (Integer c : cand)
		{

			ArrayList<Integer> newComb=new ArrayList<Integer>();
			newComb.addAll(comb);
			if(c>=last)
			{
				newComb.add(c);
				int newCount=count+c;
				if(newCount==target) ret.add(newComb);
				else if(newCount<target) helper(cand, target, newComb, c,
						newCount, ret);
			}
		}//for
		return;
	}//helper

}
