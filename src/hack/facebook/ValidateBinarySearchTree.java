package hack.facebook;

import hack.util.TreeNode;

//Given a binary tree, determine if it is a valid binary search tree (BST).
//Assume a BST is defined as follows:
//
//The left subtree of a node contains only nodes with keys less than the node's key.
//The right subtree of a node contains only nodes with keys greater than the node's key.
//Both the left and right subtrees must also be binary search trees.
//Example 1:
//    2
//   / \
//  1   3
//Binary tree [2,1,3], return true.
//Example 2:
//    1
//   / \
//  2   3
//Binary tree [1,2,3], return false
public class ValidateBinarySearchTree {
	public boolean isValidBST(TreeNode root) {
		if (root == null || (root.left == null && root.right == null)) {
			return true;
		}

		return helper(root.left, Long.MIN_VALUE, root.val) && helper(root.right, root.val, Long.MAX_VALUE);
	}

	private boolean helper(TreeNode node, long min, long max) {
		if (node == null) {
			return true;
		}

		if (node.val > min && node.val < max) {
			return helper(node.left, min, node.val) && helper(node.right, node.val, max);
		}
		return false;
	}
}
