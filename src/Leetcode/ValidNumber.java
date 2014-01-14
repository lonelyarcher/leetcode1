package Leetcode;

public class ValidNumber
{

	public static void main(String[] args)
	{
		System.out.println(isNumber("+.4E-34.00"));

	}

	public static boolean isNumber(String s)
	{
		s=s.trim();
		int n=s.length();
		if(n==0) return false;
		s=s.replaceAll("E", "e");
		if(count(s, 'e')==1)
		{
			String[] temp=s.split("e");
			if(temp.length<2) return false;
			return areDigits(temp[0], "float")&&areDigits(temp[1], "int");
		}
		return areDigits(s, "float");

	}

	private static boolean isDigit(char c)
	{
		for (int j=0; j<10; j++)
			if(c=='0'+j) return true;
		return false;
	}

	private static boolean areDigits(String s, String type)
	{
		if(s.length()==0) return false;
		if(s.charAt(0)=='+'||s.charAt(0)=='-') s=s.substring(1);
		if(s.length()==0) return false;

		if(type.equals("float"))
		{
			if(count(s, '.')>1) return false;
			if(count(s, '.')==1) s=s.replaceAll("\\.", "");
			if(s.length()==0) return false;
		}

		for (int i=0; i<s.length(); i++)
			if(!isDigit(s.charAt(i))) return false;
		return true;
	}

	private static int count(String s, char c)
	{
		int count=0;
		for (int i=0; i<s.length(); i++)
			if(s.charAt(i)==c) count++;
		return count;
	}
}
