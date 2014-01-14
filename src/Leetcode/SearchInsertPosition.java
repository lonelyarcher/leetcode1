package Leetcode;

public class SearchInsertPosition
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

	public int searchInsert(int[] A, int target)
	{
		int n=A.length;
		if(n==0||target<=A[0]) return 0;
		if(target==A[n-1]) return n-1;
		if(target>A[n-1]) return n;
		return helper(A, 0, n-1, target);
	}

	private int helper(int[] A, int begin, int end, int target)
	{
		int mid=(begin+end)/2;
		if(end-begin<=1) return end;
		if(target==A[mid]) return mid;
		if(target>A[mid]) return helper(A, mid, end, target);
		else return helper(A, begin, mid, target);
	}

}
