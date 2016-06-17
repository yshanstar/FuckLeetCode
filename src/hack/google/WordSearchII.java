package hack.google;

import hack.util.TrieNode;

import java.util.ArrayList;
import java.util.List;

/*
 * Given a 2D board and a list of words from the dictionary, find all words in the board.

 Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

 For example,
 Given words = ["oath","pea","eat","rain"] and board =

 [
 ['o','a','a','n'],
 ['e','t','a','e'],
 ['i','h','k','r'],
 ['i','f','l','v']
 ]
 Return ["eat","oath"].
 */
public class WordSearchII {
	int[][] directions = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public List<String> findWords(char[][] board, String[] words) {
		List<String> res = new ArrayList<String>();
		if (board == null || board.length == 0 || board[0].length == 0 || words == null || words.length == 0) {
			return res;
		}

		TrieNode root = buildTrie(words);

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				helper(i, j, board, res, root);
			}
		}

		return res;
	}

	private void helper(int i, int j, char[][] board, List<String> res, TrieNode root) {
		char c = board[i][j];
		int idx = c - 'a';
		if (c == '-' || root.children[idx] == null) {
			return;
		}

		root = root.children[idx];

		if (root.word != null) {
			res.add(root.word);
			root.word = null;
		}

		board[i][j] = '-';

		for (int[] dir : directions) {
			int ii = i + dir[0];
			int jj = j + dir[1];

			if (ii < 0 || ii >= board.length || jj < 0 || jj >= board[0].length || board[ii][jj] == '-') {
				continue;
			}

			helper(ii, jj, board, res, root);
		}

		board[i][j] = c;
	}

	private TrieNode buildTrie(String[] words) {
		TrieNode root = new TrieNode();

		for (String word : words) {
			TrieNode p = root;
			for (char c : word.toCharArray()) {
				int idx = c - 'a';
				if (p.children[idx] == null) {
					p.children[idx] = new TrieNode();
				}
				p = p.children[idx];
			}
			p.word = word;
		}

		return root;
	}

	public static void main(String[] args) {
		WordSearchII test = new WordSearchII();
		char[][] board = new char[][] { "ab".toCharArray(), "cd".toCharArray() };
		String[] words = new String[] { "abcd" };
		test.findWords(board, words);
	}
}
