package Leetcode;

import java.util.Arrays;

public class NQueensII
{

	public static void main(String[] args)
	{
		System.out.println(new NQueensII().totalNQueens(4));

	}

	int count=0;

	public int totalNQueens(int n)
	{

		int[] pos=new int[n];
		helper(pos, 0, n);
		return count;
	}

	private void helper(int[] pos, int row, int n)
	{
		if(row==n)
		{
			count++;
			return;
		}
		for (int i=0; i<n; i++)
		{
			if(isValid(pos, row, i))
			{
				int[] newPos=Arrays.copyOf(pos, n);
				newPos[row]=i;
				helper(newPos, row+1, n);
			}
		}
		return;
	}

	private boolean isValid(int[] pos, int row, int i)
	{
		for (int j=0; j<row; j++)
		{
			if(pos[j]==i||Math.abs(j-row)==Math.abs(pos[j]-i)) return false;
		}
		return true;
	}

}
