package hack.google;

import hack.util.TreeNode;

/*
 * Given a binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path does not need to go through the root.

For example:
Given the below binary tree,

       1
      / \
     2   3
Return 6.
 */
public class BinaryTreeMaximumPathSum {
	public int maxPathSum(TreeNode root) {
		if (root == null) {
			return 0;
		}

		if ((root.left == null && root.right == null)) {
			return root.val;
		}

		Sum s = new Sum(Integer.MIN_VALUE);
		Sum tmp = new Sum(0);

		helper(root, s, tmp);

		return s.v;
	}

	private void helper(TreeNode node, Sum s, Sum tmp) {
		if (node == null) {
			tmp.v = 0;
			return;
		}

		Sum left = new Sum(0);
		Sum right = new Sum(0);

		helper(node.left, s, left);
		helper(node.right, s, right);

		tmp.v = Math.max(node.val, Math.max(left.v, right.v) + node.val);
		s.v = Math.max(s.v, Math.max(tmp.v, node.val + left.v + right.v));
	}
}

class Sum {
	int v;

	public Sum(int v) {
		this.v = v;
	}
}
