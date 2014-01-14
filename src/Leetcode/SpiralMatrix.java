package Leetcode;

import java.util.ArrayList;

public class SpiralMatrix
{

	public static void main(String[] args)
	{
		int[][] matrix=new int[][]{{1,2,3,4}};
		ArrayList<Integer> arr=spiralOrder(matrix);
		for (int i : arr)
			System.out.print(i+" ");

	}

	public static ArrayList<Integer> spiralOrder(int[][] matrix)
	{
		ArrayList<Integer> ret=new ArrayList<Integer>();
		int m=matrix.length;
		if(m==0) return ret;
		int n=matrix[0].length;
		if(n==0) return ret;
		if(m==1||n==1)
		{
			for (int i=0; i<m; i++)
				for (int j=0; j<n; j++)
					ret.add(matrix[i][j]);
			return ret;
		}
		int c=0;
		while (c<m/2&&c<n/2)
		{
			for (int a=c; a<n-c; a++)
			{
				ret.add(matrix[c][a]);
			}
			for (int a=c+1; a<m-c; a++)
			{
				ret.add(matrix[a][n-c-1]);
			}
			for (int a=n-c-2; a>=c; a--)
			{
				ret.add(matrix[m-c-1][a]);
			}
			for (int a=m-c-2; a>c; a--)
			{
				ret.add(matrix[a][c]);
			}
			c++;
		}
		if(m%2==1) for (int a=c; a<n-c; a++)
		{
			ret.add(matrix[c][a]);
		}
		else if(n%2==1) for (int a=c; a<m-c; a++)
		{
			ret.add(matrix[a][c]);
		}
		return ret;
	}

}
