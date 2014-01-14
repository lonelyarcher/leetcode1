package Leetcode;

import java.util.HashSet;

public class SetMatrixZeroes
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

	public void setZeroes(int[][] matrix)
	{
		int m=matrix.length;
		if(m==0) return;
		int n=matrix[0].length;
		if(n==0) return;
		HashSet<Integer> rows=new HashSet<Integer>();
		HashSet<Integer> cols=new HashSet<Integer>();
		for (int i=0; i<m; i++)
			for (int j=0; j<n; j++)
			{
				if(matrix[i][j]==0)
				{
					rows.add(i);
					cols.add(j);
				}
			}
		for (Integer i : rows)
			for (int j=0; j<n; j++)
				matrix[i][j]=0;
		for (Integer j : cols)
			for (int i=0; i<m; i++)
				matrix[i][j]=0;
	}

}
