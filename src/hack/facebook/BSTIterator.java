package hack.facebook;

import java.util.Stack;

import hack.util.TreeNode;

/*
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.

Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 */
public class BSTIterator {
	TreeNode root;
	Stack<TreeNode> stack;

	public BSTIterator(TreeNode root) {
		this.root = root;
		this.stack = new Stack<TreeNode>();

		TreeNode cur = root;
		while (cur != null) {
			this.stack.push(cur);
			cur = cur.left;
		}
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return !stack.isEmpty();
	}

	/** @return the next smallest number */
	public int next() {
		if (hasNext()) {
			TreeNode cur = this.stack.pop();
			int target = cur.val;
			if (cur.right != null) {
				cur = cur.right;
				while (cur != null) {
					this.stack.push(cur);
					cur = cur.left;
				}
			}

			return target;
		}
		return Integer.MIN_VALUE;
	}
}
