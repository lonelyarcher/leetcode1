package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class Combinations
{

	public static void main(String[] args)
	{
		Combinations c=new Combinations();
		for (ArrayList<Integer> a : c.combine(5, 2))
		{
			for (Integer i : a)
				System.out.print(i+" ");
			System.out.println();
		}

	}

	public ArrayList<ArrayList<Integer>> combine(int n, int k)
	{
		assert (n>=k);

		ArrayList<ArrayList<Integer>> ret=new ArrayList<ArrayList<Integer>>();
		if(n==0||k==0) return ret;
		int[] toBePicked=new int[n];
		Arrays.fill(toBePicked, 1);
		ArrayList<Integer> hasPicked=new ArrayList<Integer>();
		helper(toBePicked, hasPicked, ret, k);
		return ret;
	}

	private void helper(int[] toBePicked, ArrayList<Integer> hasPicked,
			ArrayList<ArrayList<Integer>> ret, int k)
	{
		int m=hasPicked.size();
		if(m==k)
		{
			ret.add(hasPicked);
			return;
		}
		int i=0;
		if(m>0) i=hasPicked.get(m-1);
		for (; i<toBePicked.length; i++)
		{
			if(toBePicked[i]==1)
			{
				ArrayList<Integer> temp=new ArrayList<Integer>();
				temp.addAll(hasPicked);
				temp.add(i);
				toBePicked[i]=0;
				helper(toBePicked, temp, ret, k);
				toBePicked[i]=1;
			}
		}
	}

}
