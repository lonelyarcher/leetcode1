package Leetcode;

public class SearchForRange
{

	public static void main(String[] args)
	{
		int[] A=new int[]{1,3};
		int target=1;
		System.out.println(searchRange(A, target)[0]+"  "
				+searchRange(A, target)[1]);

	}

	public static int[] searchRange(int[] A, int target)
	{
		if(A.length==0||target<A[0]||target>A[A.length-1]) return new int[]{-1,
				-1};
		return helper(A, 0, A.length-1, target);
	}

	private static int[] helper(int[] A, int begin, int end, int target)
	{
		int mid=(begin+end)/2;
		int right=-1, left=-1;
		if(end-begin<=1)
		{
			if(begin==0&&A[begin]==target) left=begin;
			if(end==A.length-1&&A[end]==target) right=end;
			if(left>-1&&right==-1) right=left;
			if(left==-1&&right>-1) left=right;
			return new int[]{left,right};
		}
		if(target<A[mid]) return helper(A, 0, mid, target);
		if(target>A[mid]) return helper(A, mid, end, target);
		else
		{
			left=mid;
			while (left>=0&&A[left]==target)
				left--;
			right=mid;
			while (right<A.length&&A[right]==target)
				right++;
			return new int[]{left+1,right-1};
		}
	}
}
