package hack.util;

public class TrieNode {
	public String word;
	public TrieNode[] children;

	public TrieNode() {
		this.children = new TrieNode[26];
	}
}
