package Leetcode;

public class JumpGame
{

	public static void main(String[] args)
	{

	}

	public boolean canJump(int[] A)
	{
		//greedy algorithm
		if(A.length==0) return false;
		int i=0;
		while (i+A[i]<A.length-1)
		{
			int jump=0;
			int maxLength=0;
			for (int j=0; j<=A[i]; j++)
			{
				if(j+A[i+j]>maxLength||A[i+j]==0)
				{
					maxLength=j+A[i+j];
					jump=j;
				}
			}
			if(jump==0) return false;
			i+=jump;
		}
		return true;
	}
}
