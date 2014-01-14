package Leetcode;

import java.util.Arrays;

public class ValidSudoku
{
	public static void main(String[] args)
	{
		char c='3';
		System.out.println((int) c);
		System.out.println(Character.getNumericValue(c));

	}

	public static boolean isValidSudoku(char[][] board)
	{
		//validate row
		for (int i=0; i<9; i++)
		{
			boolean[] a=new boolean[10];
			Arrays.fill(a, false);
			for (int j=0; j<9; j++)
			{
				if(board[i][j]!='.')
				{
					int n=Character.getNumericValue(board[i][j]);
					if(a[n]) return false;
					else a[n]=true;
				}
			}
		}
		//validate column
		for (int i=0; i<9; i++)
		{
			boolean[] a=new boolean[10];
			Arrays.fill(a, false);
			for (int j=0; j<9; j++)
			{
				if(board[j][i]!='.')
				{
					int n=Character.getNumericValue(board[j][i]);
					if(a[n]) return false;
					else a[n]=true;
				}
			}
		}
		//validate block
		for (int i=0; i<9; i+=3)
		{
			for (int j=0; j<9; j+=3)
			{
				boolean[] a=new boolean[10];
				Arrays.fill(a, false);
				for (int k=0; k<3; k++)
				{
					for (int l=0; l<3; l++)
					{
						if(board[i+k][j+l]!='.')
						{
							int n=Character.getNumericValue(board[i+k][j+l]);
							if(a[n]) return false;
							else a[n]=true;
						}
					}
				}
			}
		}

		return true;
	}
}
