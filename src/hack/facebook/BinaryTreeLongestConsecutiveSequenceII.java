package hack.facebook;

import hack.util.TreeNode;

/*
Given a binary tree, you need to find the length of Longest Consecutive Path in Binary Tree.

Especially, this path can be either increasing or decreasing. For example, [1,2,3,4] and [4,3,2,1] are both considered valid, but the path [1,2,4,3] is not valid. On the other hand, the path can be in the child-Parent-child order, where not necessarily be parent-child order.

Example 1:
Input:
        1
       / \
      2   3
Output: 2
Explanation: The longest consecutive path is [1, 2] or [2, 1].
Example 2:
Input:
        2
       / \
      1   3
Output: 3
Explanation: The longest consecutive path is [1, 2, 3] or [3, 2, 1].
Note: All the values of tree nodes are in the range of [-1e7, 1e7].
 */
public class BinaryTreeLongestConsecutiveSequenceII {
    /*
     * Reference:
     * https://leetcode.com/problems/binary-tree-longest-consecutive-sequence-ii/discuss/101510/Java-solution-Binary-Tree-Post-Order-Traversal
     */

    private int max = 0;

    public int longestConsecutive(TreeNode root) {
        postOrder(root);
        return max;
    }

    private Result postOrder(TreeNode node) {
        if (node == null) return null;

        Result left = postOrder(node.left);
        Result right = postOrder(node.right);

        Result current = new Result();
        current.node = node;
        current.inc = 1;
        current.des = 1;

        checkNode(current, left);
        checkNode(current, right);

        max = Math.max(max, current.inc + current.des - 1);
        return current;
    }

    private void checkNode(Result current, Result target) {
        if (target != null) {
            if (current.node.val - target.node.val == 1) {
                current.inc = Math.max(current.inc, target.inc + 1);
            } else if (current.node.val - target.node.val == -1) {
                current.des = Math.max(current.des, target.des + 1);
            }
        }
    }

    class Result {
        TreeNode node;
        int inc;
        int des;
    }
}


