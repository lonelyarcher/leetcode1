package Leetcode;

public class RemoveDuplicatesFromSortedArray
{

	public static void main(String[] args)
	{
		int[] a=new int[]{1,2,2,2,4,4,5};
		int l=removeDuplicates(a);
		for (int i=0; i<l; i++)
			System.out.println(a[i]);

	}

	public static int removeDuplicates(int[] A)
	{
		if(A==null||A.length==0) return 0;
		int pre=A[0];
		int ret=1;
		int repeat=0;
		for (int i=1; i<A.length; i++)
		{
			if(A[i]==pre)
			{
				repeat++;
			}
			else
			{
				pre=A[i];
				A[i-repeat]=pre;
				ret++;
			}

		}

		return ret;
	}

}
