package Leetcode;

import java.util.ArrayList;

public class Subsets
{

	public static void main(String[] args)
	{
		Subsets s=new Subsets();
		for (ArrayList<Integer> ss : s.subsets(new int[]{1,2,3,4,5}))
		{
			for (int i : ss)
			{
				System.out.print(i+" ");
			}
			System.out.println();
		}
	}

	public ArrayList<ArrayList<Integer>> subsets(int[] S)
	{
		ArrayList<Integer> s=new ArrayList<Integer>();
		for (Integer i : S)
			s.add(i);

		ArrayList<ArrayList<Integer>> ret0=new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> ret1=new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> s0=new ArrayList<Integer>();
		ret0.add(s0);
		ArrayList<ArrayList<Integer>> ret=new ArrayList<ArrayList<Integer>>();
		ret.addAll(ret0);
		ret.add(s);

		for (int i=1; i<S.length; i++)
		{
			for (ArrayList<Integer> a : ret0)
			{
				for (Integer j : s)
				{
					if(!a.contains(j))
					{
						ArrayList<Integer> temp=new ArrayList<Integer>();
						temp.add(j);
						ret1.add(temp);
					}
				}
			}
			ret.addAll(ret1);
			ret0=ret1;
		}
		return ret;
	}

}
