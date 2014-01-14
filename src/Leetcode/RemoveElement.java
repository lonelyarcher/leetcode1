package Leetcode;

public class RemoveElement
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

	public int removeElement(int[] A, int elem)
	{
		if(A==null||A.length==0) return 0;
		int times=0;
		int ret=0;
		for (int i=0; i<A.length; i++)
		{
			if(A[i]==elem)
			{
				times++;
			}
			else
			{
				A[i-times]=A[i];
				ret++;
			}
		}

		return ret;
	}

}
