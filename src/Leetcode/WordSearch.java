package Leetcode;


public class WordSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordSearch ws = new WordSearch();
		/*
		 * char[][] board = new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F',
		 * 'C', 'S' }, { 'A', 'D', 'E', 'E' }, { 'A', 'B', 'C', 'E' } }; String
		 * word1 = "ABCCED"; String word2 = "SEE"; String word3 = "ABCB";
		 * System.out.println(ws.exist(board, word1));
		 * System.out.println(ws.exist(board, word2));
		 * System.out.println(ws.exist(board, word3));
		 */
		char[][] board1 = new char[][] { { 'a', 'a', 'a', 'a' },
				{ 'a', 'a', 'a', 'a' }, { 'a', 'a', 'a', 'a' },
				{ 'a', 'a', 'a', 'a' }, { 'a', 'a', 'a', 'b' } };
		String word4 = "aaaaaaaaaaaaaaaaaaaa";
		System.out.println(ws.exist(board1, word4));

	}

	public boolean exist(char[][] board, String word) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		if (board == null || board.length == 0 || word == null
				|| word.isEmpty())
			return false;

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == word.charAt(0)) {
					board[i][j] = '#';
					boolean found = helper(i, j, board, word.substring(1));
					if (found)
						return true;
					board[i][j] = word.charAt(0);
				}
			}
		}
		return false;
	}

	public static boolean helper(int i, int j, char[][] board, String word) {
		// TODO Auto-generated method stub
		if (word.length() == 0)
			return true;
		int[][] move = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
		for (int[] mv : move) {
			int ii = i + mv[0];
			int jj = j + mv[1];
			if (ii >= 0 && ii < board.length && jj >= 0
					&& jj < board[ii].length && board[ii][jj] == word.charAt(0)) {
				board[ii][jj] = '#';
				if (helper(ii, jj, board, word.substring(1))) {
					return true;
				}
				board[ii][jj] = word.charAt(0);
			}
		}

		return false;
	}

}
