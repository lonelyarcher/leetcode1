package Leetcode;

import java.util.ArrayList;

public class NQueens
{

	public static void main(String[] args)
	{
		ArrayList<String[]> ret=solveNQueens(4);
		for (String[] strs : ret)
			for (String s : strs)
				System.out.println(s);

	}

	public static ArrayList<String[]> solveNQueens(int n)
	{
		ArrayList<String[]> ret=new ArrayList<String[]>();
		char[][] m=new char[n][n];
		for (int i=0; i<n; i++)
		{
			for (int j=0; j<n; j++)
			{
				m[i][j]='0';
			}
		}

		int x=0;
		helper(m, x, ret);
		return ret;
	}

	private static void helper(char[][] m, int x, ArrayList<String[]> ret)
	{
		int n=m.length;
		if(x==n)
		{
			String[] s=new String[n];
			for (int i=0; i<n; i++)
				s[i]=String.valueOf(m[i]);
			ret.add(s);
			return;
		}
		for (int i=0; i<n; i++)
		{
			char[][] newM=new char[n][n];
			copy(m, newM);
			if(!validate(newM, x, i))
			{
				System.out.println("0");
				return;
			}
			System.out.println("1");
			newM[x][i]='Q';
			helper(newM, x+1, ret);
		}
		return;

	}

	private static void copy(char[][] ori, char[][] copy)
	{
		int n=ori.length;
		for (int i=0; i<n; i++)
		{
			for (int j=0; j<n; j++)
			{
				copy[i][j]=ori[i][j];
			}
		}
	}

	private static boolean validate(char[][] m, int x, int y)
	{
		int n=m.length;
		//row
		for (int i=0; i<n; i++)
			if(m[x][i]=='Q'&&i!=y) return false;
		//column		
		for (int i=0; i<n; i++)
			if(m[i][y]=='Q'&&i!=x) return false;
		//diagonal 		
		int i=x, j=y;
		while (i<n-1&&j<n-1)
			if(m[++i][++j]=='Q') return false;
		i=x;
		j=y;
		while (i>0&&j>0)
			if(m[--i][--j]=='Q') return false;
		//another diagonal		
		i=x;
		j=y;
		while (i>0&&j<n-1)
			if(m[--i][++j]=='Q') return false;
		i=x;
		j=y;
		while (i<n-1&&j>0)
			if(m[++i][--j]=='Q') return false;
		return true;
	}
}
