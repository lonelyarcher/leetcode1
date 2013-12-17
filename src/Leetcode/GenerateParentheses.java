package Leetcode;

import java.util.ArrayList;
import java.util.Stack;

public class GenerateParentheses
{

	public static void main(String[] args)
	{
		ArrayList<String> out=generateParenthesisByRecursion(3);
		for (String s : out)
			System.out.println(s);

	}

	public static ArrayList<String> generateParenthesisByRecursion(int n)
	{
		ArrayList<String> ret=new ArrayList<String>();
		if(n<1) return ret;
		StringBuilder sb=new StringBuilder();
		sb.append('(');
		helper(sb, 1, 0, n, ret);
		return ret;
	}

	private static void helper(StringBuilder sb, int left, int right, int n,
			ArrayList<String> ret)
	{

		if(left==n&&right==n)
		{
			ret.add(sb.toString());
			return;
		}
		else if(left==n)
		{
			sb.append(')');
			helper(sb, left, right+1, n, ret);
		}
		else if(left==right)
		{
			sb.append('(');
			helper(sb, left+1, right, n, ret);
		}
		else if(left>right)
		{
			StringBuilder sb1=new StringBuilder();
			sb1.append(sb);

			sb.append(')');
			helper(sb, left, right+1, n, ret);

			sb1.append('(');
			helper(sb1, left+1, right, n, ret);
		}

	}

	public static ArrayList<String> generateParenthesis(int n)
	{
		ArrayList<String> ret=new ArrayList<String>();
		if(n<1) return ret;
		ArrayList<Stack<Character>> stacks=new ArrayList<Stack<Character>>();
		ArrayList<StringBuilder> sbs=new ArrayList<StringBuilder>();
		Stack<Character> stack0=new Stack<Character>();
		StringBuilder sb0=new StringBuilder();
		stack0.push('(');
		stacks.add(stack0);
		sb0.append('(');
		sbs.add(sb0);

		for (int i=1; i<2*n; i++)
		{
			ArrayList<Stack<Character>> newStacks=new ArrayList<Stack<Character>>();
			ArrayList<StringBuilder> newSbs=new ArrayList<StringBuilder>();

			for (int j=0; j<stacks.size(); j++)
			{
				Stack<Character> tempSt=stacks.get(j);
				StringBuilder tempSb=sbs.get(j);
				int left=0;
				for (int k=0; k<tempSb.length(); k++)
				{
					if(tempSb.charAt(k)=='(') left++;
				}
				if(tempSt.empty())
				{
					tempSt.push('(');

					tempSb.append('(');
				}
				else if(left==n)
				{
					tempSt.pop();
					tempSb.append(')');
				}
				else
				{

					Stack<Character> tempSt1=new Stack<Character>();
					tempSt1.addAll(tempSt);
					StringBuilder tempSb1=new StringBuilder();
					tempSb1.append(tempSb);

					tempSt.push('(');
					tempSb.append('(');

					tempSt1.pop();
					newStacks.add(tempSt1);
					tempSb1.append(')');
					newSbs.add(tempSb1);
				}
			}
			stacks.addAll(newStacks);
			sbs.addAll(newSbs);
		}

		for (StringBuilder sb : sbs)
			ret.add(sb.toString());

		return ret;
	}

}
