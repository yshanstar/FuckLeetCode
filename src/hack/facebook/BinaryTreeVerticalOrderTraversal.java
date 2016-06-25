package hack.facebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import hack.util.TreeNode;

/*
 * Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).

If two nodes are in the same row and column, the order should be from left to right.

Examples:

Given binary tree [3,9,20,null,null,15,7],
   3
  /\
 /  \
 9  20
    /\
   /  \
  15   7
return its vertical order traversal as:
[
  [9],
  [3,15],
  [20],
  [7]
]
Given binary tree [3,9,8,4,0,1,7],
     3
    /\
   /  \
   9   8
  /\  /\
 /  \/  \
 4  01   7
return its vertical order traversal as:
[
  [4],
  [9],
  [3,0,1],
  [8],
  [7]
]
Given binary tree [3,9,8,4,0,1,7,null,null,null,2,5] (0's right child is 2 and 1's left child is 5),
     3
    /\
   /  \
   9   8
  /\  /\
 /  \/  \
 4  01   7
    /\
   /  \
   5   2
return its vertical order traversal as:
[
  [4],
  [9,5],
  [3,0,1],
  [8,2],
  [7]
]
 */
public class BinaryTreeVerticalOrderTraversal {
	public List<List<Integer>> verticalOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();

		if (root == null) {
			return res;
		}

		Queue<TreeNode> nodes = new LinkedList<TreeNode>();
		Queue<Integer> idxes = new LinkedList<Integer>();
		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();

		int min = 0;
		int max = 0;
		nodes.offer(root);
		idxes.offer(0);

		while (!nodes.isEmpty()) {
			TreeNode node = nodes.poll();
			int idx = idxes.poll();

			if (!map.containsKey(idx)) {
				map.put(idx, new ArrayList<Integer>());
			}

			List<Integer> nums = map.get(idx);
			nums.add(node.val);

			if (node.left != null) {
				nodes.offer(node.left);
				idxes.offer(idx - 1);
				min = Math.min(min, idx - 1);
			}

			if (node.right != null) {
				nodes.offer(node.right);
				idxes.offer(idx + 1);
				max = Math.max(max, idx + 1);
			}
		}

		for (int i = min; i <= max; i++) {
			res.add(map.get(i));
		}

		return res;
	}
}
