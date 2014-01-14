package Leetcode;

public class SpiralMatrixII
{

	public static void main(String[] args)
	{
		int[][] a=generateMatrix(4);
		for (int i=0; i<a.length; i++)
		{
			for (int j=0; j<a.length; j++)
				System.out.print(a[i][j]);
			System.out.println();
		}

	}

	public static int[][] generateMatrix(int n)
	{
		int[][] a=new int[n][n];
		int m=1;
		for (int i=0; i<n/2; i++)
		{
			for (int up=i; up<n-i; up++)
				a[i][up]=m++;
			for (int left=i+1; left<n-i; left++)
				a[left][n-i-1]=m++;
			for (int down=n-i-2; down>=i; down--)
				a[n-i-1][down]=m++;
			for (int right=n-i-2; right>i; right--)
				a[right][i]=m++;
		}
		if(n%2==1)
		{
			a[(n-1)/2][(n-1)/2]=m;
		}
		return a;
	}

}
