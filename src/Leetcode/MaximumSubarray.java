package Leetcode;

public class MaximumSubarray
{

	public static void main(String[] args)
	{
		int[] A=new int[]{-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(maxSubArray(A));
	}

	public static int maxSubArray(int[] A)
	{
		int ret=A[0];
		int count=0;
		for (int i=0; i<A.length; i++)
		{
			count+=A[i];
			ret=Math.max(ret, count);
			if(count<0) count=0;
		}
		return ret;
	}
}
