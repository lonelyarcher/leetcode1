package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LetterCombinationOnThePhone
{

	public static void main(String[] args)
	{
		String digits="3473067563";
		ArrayList<String> letters=letterCombinations(digits);
		for (String l : letters)
			System.out.println(l);
	}

	public static ArrayList<String> letterCombinations(String digits)
	{
		ArrayList<String> ret=new ArrayList<String>();
		if(digits==null) return ret;
		digits=digits.replaceAll("1", "").replaceAll("0", "");
		//System.out.println(digits);
		if(digits.length()==0) return new ArrayList<String>(Arrays.asList(""));
		Map<Character, ArrayList<Character>> phone=new HashMap<Character, ArrayList<Character>>();
		phone.put('2', new ArrayList<Character>(Arrays.asList('a', 'b', 'c')));
		phone.put('3', new ArrayList<Character>(Arrays.asList('d', 'e', 'f')));
		phone.put('4', new ArrayList<Character>(Arrays.asList('g', 'h', 'i')));
		phone.put('5', new ArrayList<Character>(Arrays.asList('j', 'k', 'l')));
		phone.put('6', new ArrayList<Character>(Arrays.asList('m', 'n', 'o')));
		phone.put('7',
				new ArrayList<Character>(Arrays.asList('p', 'q', 'r', 's')));
		phone.put('8', new ArrayList<Character>(Arrays.asList('t', 'u', 'v')));
		phone.put('9',
				new ArrayList<Character>(Arrays.asList('w', 'x', 'y', 'z')));

		for (Character c : phone.get(digits.charAt(0)))
			ret.add(c+"");
		for (int i=1; i<digits.length(); i++)
		{
			//System.out.println(digits.charAt(i));
			ArrayList<String> temp=new ArrayList<String>();
			for (String s : ret)
				for (Character c : phone.get(digits.charAt(i)))
					temp.add(s+c);
			ret=temp;
		}
		return ret;
	}
}
