package Leetcode;

public class JumpGameII
{

	public static void main(String[] args)
	{
		int[] A=new int[]{5,9,3,2,1,0,2,3,3,1,0,0};
		System.out.println(jump(A));
	}

	public static int jump(int[] A)
	{
		int n=A.length;
		if(n<=1) return 0;
		int i=0;
		int jumps=0;
		while (A[i]+i<n-1)
		{
			int step=0;
			int maxLength=0;
			for (int j=1; j<=A[i]; j++)
			{
				int length=j+A[i+j];
				if(A[i+j]!=0&&length>maxLength)
				{
					maxLength=length;
					step=j;
				}
			}
			i+=step;
			jumps++;
		}

		return jumps+1;
	}
}
