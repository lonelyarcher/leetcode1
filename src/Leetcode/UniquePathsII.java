package Leetcode;

public class UniquePathsII
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

	public int uniquePathsWithObstacles(int[][] obstacleGrid)
	{
		int m=obstacleGrid.length;
		if(m==0) return 0;
		int n=obstacleGrid[0].length;
		if(n==0) return 0;

		int[][] a=new int[m][n];
		for (int i=0; i<n; i++)
			if(obstacleGrid[0][i]==0) a[0][i]=1;
			else break;
		for (int i=1; i<m; i++)
		{
			if(obstacleGrid[i][0]==0) a[i][0]=a[i-1][0];
			for (int j=1; j<n; j++)
				if(obstacleGrid[i][j]==0) a[i][j]=a[i-1][j]+a[i][j-1];
		}
		return a[m-1][n-1];

	}

}
