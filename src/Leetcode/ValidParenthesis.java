package Leetcode;

import java.util.Stack;

public class ValidParenthesis
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

		String s="([)][[()]{}]";
		System.out.println(isValid(s));

	}

	public static boolean isValid(String s)
	{
		Stack<Character> st=new Stack<Character>();
		for (int i=0; i<s.length(); i++)
		{
			switch (s.charAt(i))
			{
			case ('('):
				st.push('(');
				break;
			case ')':
				if(!st.empty()&&st.peek()=='(') st.pop();
				else return false;
				break;
			case ('['):
				st.push('[');
				break;
			case ']':
				if(!st.empty()&&st.peek()=='[') st.pop();
				else return false;
				break;
			case ('{'):
				st.push('{');
				break;
			case '}':
				if(!st.empty()&&st.peek()=='{') st.pop();
				else return false;
				break;
			}
		}
		if(st.empty()) return true;
		else return false;
	}

}
