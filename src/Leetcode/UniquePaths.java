package Leetcode;

public class UniquePaths
{

	public static void main(String[] args)
	{
		UniquePaths up=new UniquePaths();
		System.out.println(up.uniquePaths(23, 12));
	}

	int count=0;

	public int uniquePaths(int m, int n)
	{
		int[][] a=new int[m][n];
		for (int i=0; i<n; i++)
			a[0][i]=1;
		for (int i=1; i<m; i++)
		{
			a[i][0]=1;
			for (int j=1; j<n; j++)
				a[i][j]=a[i][j-1]+a[i-1][j];
		}
		return a[m-1][n-1];
	}

	public int uniquePaths2(int m, int n)
	{

		findPath(m-1, n-1, 0, 0);
		return count;
	}

	private void findPath(int m, int n, int i, int j)
	{
		if(i==m||j==n)
		{
			count++;
			return;
		}

		findPath(m, n, i+1, j);
		findPath(m, n, i, j+1);
	}
}
