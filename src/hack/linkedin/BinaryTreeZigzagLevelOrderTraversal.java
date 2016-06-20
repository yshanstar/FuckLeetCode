package hack.linkedin;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import hack.util.TreeNode;

/*
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
 */
public class BinaryTreeZigzagLevelOrderTraversal {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();

		if (root == null) {
			return res;
		}

		boolean isOdd = true;
		Stack<TreeNode> cur = new Stack<TreeNode>();
		Stack<TreeNode> next = new Stack<TreeNode>();
		List<Integer> curLevel = new ArrayList<Integer>();
		cur.push(root);

		while (!cur.isEmpty()) {
			TreeNode curNode = cur.pop();

			curLevel.add(curNode.val);
			if (!isOdd) {
				if (curNode.right != null) {
					next.push(curNode.right);
				}

				if (curNode.left != null) {
					next.push(curNode.left);
				}
			} else {
				if (curNode.left != null) {
					next.push(curNode.left);
				}

				if (curNode.right != null) {
					next.push(curNode.right);
				}
			}

			if (cur.isEmpty()) {
				res.add(new ArrayList<Integer>(curLevel));
				curLevel.clear();
				cur = next;
				next = new Stack<TreeNode>();
				isOdd = !isOdd;
			}
		}

		return res;
	}
}
