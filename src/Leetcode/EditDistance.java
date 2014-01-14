package Leetcode;

public class EditDistance
{
	public static void main(String[] args)
	{
		String w2="happyhour";
		String w1="apply";
		System.out.println(minDistance(w1, w2));
	}

	public static int minDistance(String word1, String word2)
	{
		int m=word1.length();
		int n=word2.length();
		int[][] a=new int[m+1][n+1];
		for (int i=0; i<=m; i++)
			a[i][0]=i;
		for (int i=0; i<=n; i++)
			a[0][i]=i;
		for (int i=1; i<=m; i++)
			for (int j=1; j<=n; j++)
			{
				if(word1.charAt(i-1)==word2.charAt(j-1)) a[i][j]=a[i-1][j-1];
				else a[i][j]=1+Math.min(a[i-1][j], a[i][j-1]);
			}

		return a[m][n];
	}
}
