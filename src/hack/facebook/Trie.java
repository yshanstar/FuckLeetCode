package hack.facebook;

/*
Implement a trie with insert, search, and startsWith methods.

Example:

Trie trie = new Trie();

trie.insert("apple");
trie.search("apple");   // returns true
trie.search("app");     // returns false
trie.startsWith("app"); // returns true
trie.insert("app");
trie.search("app");     // returns true
Note:

You may assume that all inputs are consist of lowercase letters a-z.
All inputs are guaranteed to be non-empty strings.
 */

import java.util.HashMap;
import java.util.Map;

class Trie2 {

    private TrieNo root;

    /**
     * Initialize your data structure here.
     */
    public Trie2() {
        root = new TrieNo();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        insert(word, 0, root);
    }

    private void insert(String word, int i, TrieNo node) {
        if (i == word.length()) {
            node.isLeaf = true;
            return;
        }

        char c = word.charAt(i);
        node.children.putIfAbsent(c, new TrieNo(c));
        insert(word, i + 1, node.children.get(c));
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        return search(word, 0, root);
    }

    private boolean search(String word, int i, TrieNo node) {
        if (i == word.length()) {
            return node.isLeaf;
        }

        char c = word.charAt(i);
        return node.children.containsKey(c) && search(word, i + 1, node.children.get(c));
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        return startWith(prefix, 0, root);
    }

    private boolean startWith(String word, int i, TrieNo node) {
        if (i == word.length()) {
            return true;
        }

        char c = word.charAt(i);
        return node.children.containsKey(c) && startWith(word, i + 1, node.children.get(c));
    }
}

class TrieNo {
    Character c;
    Map<Character, TrieNo> children;
    boolean isLeaf;

    public TrieNo(char c) {
        this.c = c;
        this.children = new HashMap<>();
        this.isLeaf = false;
    }

    public TrieNo() {
        this.children = new HashMap<>();
        this.isLeaf = false;
    }
}

public class Trie {

    private TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        insert(word.toCharArray(), 0, root);
    }

    private void insert(char[] chars, int i, TrieNode node) {
        if (i == chars.length) {
            node.isLeaf = true;
            return;
        }

        char c = chars[i];
        if (node.children[c - 'a'] == null) {
            node.children[c - 'a'] = new TrieNode();
        }

        insert(chars, i + 1, node.children[c - 'a']);
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        return search(word.toCharArray(), 0, root);
    }

    private boolean search(char[] chars, int i, TrieNode node) {
        if (i == chars.length) {
            return node.isLeaf;
        }

        char c = chars[i];
        return node.children[c - 'a'] != null && search(chars, i + 1, node.children[c - 'a']);
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        return startWith(prefix.toCharArray(), 0, root);
    }

    private boolean startWith(char[] chars, int i, TrieNode node) {
        if (i == chars.length) {
            return true;
        }

        char c = chars[i];
        return node.children[c - 'a'] != null && startWith(chars, i + 1, node.children[c - 'a']);
    }
}

class TrieNode {
    TrieNode[] children;
    boolean isLeaf;

    public TrieNode() {
        this.children = new TrieNode[26];
        this.isLeaf = false;
    }
}
