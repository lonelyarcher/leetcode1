package Leetcode;

public class TrappingRainWater
{

	public static void main(String[] args)
	{
		int[] A=new int[]{5,5,1,7,1,1,5,2,7,6};
		System.out.println(trap(A));

	}

	public static int trap(int[] A)
	{
		if(A.length==0) return 0;
		int left=0;
		int water=0;
		int trap=0;
		for (int i=1; i<A.length; i++)
		{
			if(i==A.length-1)
			{
				if(A[i]>=A[left]) water+=trap;
				else
				{
					trap=0;
					int right=i;
					for (int j=i; j>=left; j--)
					{
						if(A[j]<A[right]) trap+=A[right]-A[j];
						else
						{
							right=j;
							water+=trap;
							trap=0;
						}
					}
				}
			}
			else if(A[i]<A[left]) trap+=A[left]-A[i];
			else
			{
				left=i;
				water+=trap;
				trap=0;
			}
		}
		return water;
	}

}
