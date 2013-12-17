package Leetcode;

public class WildcardMatching
{

	public static void main(String[] args)
	{
		String s="bbabaab";

		String p="*b";
		System.out.println(isMatch(s, p));

	}

	public static boolean isMatch(String s, String p)
	{
		int n=s.length();
		int m=p.length();
		int star=-1;
		int sp=0;
		int i=0;
		int j=0;

		while (i<n)
		{
			while (j<m&&p.charAt(j)=='*')
			{
				star=j;
				sp=i;
				j++;
			}
			if(j<m&&(s.charAt(i)==p.charAt(j)||p.charAt(j)=='?'))
			{
				i++;
				j++;
			}
			else if(star>=0)
			{
				i=++sp;
				j=star+1;
			}
			else
			{
				return false;
			}
		}
		while (j<m&&p.charAt(j)=='*')
			j++;
		return j==m;

	}

}
