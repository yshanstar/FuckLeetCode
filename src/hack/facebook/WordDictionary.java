package hack.facebook;

import java.util.HashMap;
import java.util.Map;

/*
 * Design a data structure that supports the following two operations:

void addWord(word)
bool search(word)
search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.

For example:

addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true
Note:
You may assume that all words are consist of lowercase letters a-z.
 */
public class WordDictionary {
	TrieN root;

	public WordDictionary() {
		this.root = new TrieN();
	}

	// Adds a word into the data structure.
	public void addWord(String word) {
		TrieN cur = this.root;
		for (char c : word.toCharArray()) {
			if (!cur.children.containsKey(c)) {
				cur.children.put(c, new TrieN(c));
			}

			TrieN child = cur.children.get(c);
			cur = child;
		}

		cur.isLeaf = true;
	}

	// Returns if the word is in the data structure. A word could
	// contain the dot character '.' to represent any one letter.
	public boolean search(String word) {
		TrieN cur = this.root;
		return dfsHelper(cur, word, 0);
	}
	
	private boolean dfsHelper(TrieN node, String word, int idx){
		if(idx == word.length()){
			return node.isLeaf;
		}
		
		char c = word.charAt(idx);

		if (node.children.containsKey(c)) {
			if (idx == word.length() - 1 && node.children.get(c).isLeaf) {
				return true;
			}

			return dfsHelper(node.children.get(c), word, idx + 1);
		} else if (c == '.') {
			boolean result = false;
			for (Map.Entry<Character, TrieN> child : node.children.entrySet()) {
				if (idx == word.length() - 1 && child.getValue().isLeaf) {
					return true;
				}

				if (dfsHelper(child.getValue(), word, idx + 1)) {
					result = true;
				}
			}
			return result;
		} else {
			return false;
		}
	}
}

class TrieN {
	public char c;
	public boolean isLeaf;
	public Map<Character, TrieN> children;

	public TrieN() {
		this.isLeaf = false;
		this.children = new HashMap<Character, TrieN>();
	}

	public TrieN(char c) {
		this.c = c;
		this.isLeaf = false;
		this.children = new HashMap<Character, TrieN>();
	}
}