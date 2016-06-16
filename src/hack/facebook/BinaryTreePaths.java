package hack.facebook;

import java.util.ArrayList;
import java.util.List;

import hack.util.TreeNode;

/*
 *Given a binary tree, return all root-to-leaf paths.

For example, given the following binary tree:

   1
 /   \
2     3
 \
  5
All root-to-leaf paths are:

["1->2->5", "1->3"]
 */
public class BinaryTreePaths {
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> path = new ArrayList<String>();

		if (root == null) {
			return path;
		}

		helper(path, root, "");

		return path;
	}

	private void helper(List<String> path, TreeNode node, String tmpPath) {
		if (node.left == null && node.right == null) {
			String curPath = tmpPath;
			curPath += (tmpPath.isEmpty()) ? node.val : "->" + node.val;
			path.add(curPath);
			return;
		}

		String newPath = tmpPath + ((tmpPath.isEmpty()) ? node.val : "->" + node.val);
		if (node.left != null) {
			helper(path, node.left, newPath);
		}

		if (node.right != null) {
			helper(path, node.right, newPath);
		}
	}
}
