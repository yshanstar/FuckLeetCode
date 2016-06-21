package hack.facebook;

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
	int[][] direction = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public List<String> findWords(char[][] board, String[] words) {
		List<String> res = new ArrayList<String>();

		if (board == null || board.length == 0 || board[0].length == 0) {
			return res;
		}

		if (words == null || words.length == 0) {
			return res;
		}

		TrieNode root = buildTrie(words);

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				helperDFS(res, i, j, root, board);
			}
		}

		return res;
	}

	private void helperDFS(List<String> res, int i, int j, TrieNode node, char[][] board) {
		char c = board[i][j];

		if (c == '-' || node.children[c - 'a'] == null) {
			return;
		}

		node = node.children[c - 'a'];

		if (node.word != null) {
			res.add(node.word);
			node.word = null;
		}

		board[i][j] = '-';
		for (int[] dir : direction) {
			int ii = i + dir[0];
			int jj = j + dir[1];

			if (ii < 0 || ii >= board.length || jj < 0 || jj >= board[0].length || board[ii][jj] == '-') {
				continue;
			}

			helperDFS(res, ii, jj, node, board);
		}

		board[i][j] = c;
	}

	private TrieNode buildTrie(String[] words) {
		TrieNode root = new TrieNode();

		for (String word : words) {
			insert(word, root);
		}

		return root;
	}

	private void insert(String word, TrieNode root) {
		if (word.isEmpty()) {
			return;
		}
		TrieNode cur = root;
		for (char c : word.toCharArray()) {
			int idx = c - 'a';
			if (cur.children[idx] == null) {
				cur.children[idx] = new TrieNode();
			}
			cur = cur.children[idx];
		}
		cur.word = word;
	}
}
