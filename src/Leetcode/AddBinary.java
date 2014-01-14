package Leetcode;

public class AddBinary
{

	public static void main(String[] args)
	{
		System.out.println(addBinary("111", "001"));
	}

	public static String addBinary(String a, String b)
	{
		StringBuilder sum=new StringBuilder();
		int i=a.length()-1;
		int j=b.length()-1;
		int add=0;
		while (add>0||i>=0||j>=0)
		{
			int n1=0;
			if(i>=0) n1=Character.getNumericValue(a.charAt(i--));
			int n2=0;
			if(j>=0) n2=Character.getNumericValue(b.charAt(j--));
			int s=n1+n2+add;
			add=s/2;
			sum.insert(0, s%2);

		}
		return sum.toString();
	}
}
