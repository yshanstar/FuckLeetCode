package hack.facebook;

/*
 * Given a 2D board and a word, find if the word exists in the grid.

 The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

 For example,
 Given board =

 [
 ['A','B','C','E'],
 ['S','F','C','S'],
 ['A','D','E','E']
 ]
 word = "ABCCED", -> returns true,
 word = "SEE", -> returns true,
 word = "ABCB", -> returns false.
 */
public class WordSearch {
	public int[][] directions = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public boolean exist(char[][] board, String word) {
		if (board == null || board.length == 0 || board[0].length == 0) {
			return false;
		}

		if (word == null || word.isEmpty()) {
			return true;
		}

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (helper(board, word, i, j)) {
					return true;
				}
			}
		}

		return false;
	}

	private boolean helper(char[][] board, String word, int i, int j) {
		if (word.length() == 0) {
			return true;
		}

		if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
			return false;
		}

		if (board[i][j] != word.charAt(0)) {
			return false;
		}
		
		board[i][j] ^= 256;

		boolean exist = helper(board, word.substring(1), i+1, j) || helper(board, word.substring(1), i-1, j)
				|| helper(board, word.substring(1), i, j+1) || helper(board, word.substring(1), i, j-1);
		
		board[i][j] ^= 256;

		return exist;
	}
}
