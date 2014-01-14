package Leetcode;

public class DivideTwoIntegers
{

	public static void main(String[] args)
	{
		int dividend=-2147483648;
		int divisor=2;
		System.out.println(divide(dividend, divisor));

	}

	public static int divide(int dividend, int divisor)
	{
		if(dividend==0||divisor==1) return dividend;
		int sign=1;
		if((dividend<0&&divisor>0)||(dividend>0&&divisor<0)) sign=-1;
		long n=Math.abs((long) dividend);
		long m=Math.abs((long) divisor);
		System.out.println("n="+n);
		int ret=0;
		int shift=31;
		while (n>=m)
		{
			long M=m<<shift;
			while (M>n)
			{
				M=M>>1;
				shift--;
			}
			ret+=(1<<shift);
			n=n-M;
		}
		return (sign==1) ? ret : -ret;
	}

	public static int divideLikeHuman(int dividend, int divisor)
	{
		assert (divisor!=0);
		if(dividend==0) return 0;
		if(divisor==1) return dividend;
		int sign=1;
		if((dividend<0&&divisor>0)||(dividend>0&&divisor<0)) sign=-1;
		dividend=Math.abs(dividend);
		divisor=Math.abs(divisor);

		String s1=Integer.toString(dividend);
		String s2=Integer.toString(divisor);
		int[] ret=helper(s1, s2);
		return (sign==1) ? ret[0] : -ret[0];
	}

	private static int[] helper(String s1, String s2)
	{

		int l=s1.length();
		int r=s2.length();
		int n1=Integer.parseInt(s1);
		int n2=Integer.parseInt(s2);
		int N2=Integer.parseInt(s2+"0");

		if(n1<N2)
		{
			int ret=0;
			long add=n2;
			while (add<n1)
			{
				add+=n2;
				ret++;
			}
			long left=n1-add+n2;
			return new int[]{ret,(int) left};
		}
		else
		{
			String p1=s1.substring(0, r);
			String p2=s1.substring(r);
			int[] ret1=helper(p1, s2);
			StringBuilder sb1=new StringBuilder(Integer.toString(ret1[0]));
			StringBuilder sb2=new StringBuilder(Integer.toString(ret1[1]));
			for (int i=0; i<l-r; i++)
			{
				sb1.append("0");
				sb2.append("0");
			}
			int sp1=Integer.parseInt(sb1.toString());
			int sp2=Integer.parseInt(sb2.toString())+Integer.parseInt(p2);
			int[] ret2=helper(Integer.toString(sp2), s2);
			return new int[]{sp1+ret2[0],ret2[1]};

		}
	}

}
