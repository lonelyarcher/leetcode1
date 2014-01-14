package Leetcode;

public class Pow
{

	public static void main(String[] args)
	{
		double x=-1.00000;

		int n=-2147483648;
		System.out.println(pow(x, n));

	}

	public static double pow(double x, int n)
	{
		if(n==0) return 1;
		double half=pow(x, n/2);
		if(n%2==0) return half*half;
		else return (n>0) ? half*half*x : half*half/x;
	}
}
