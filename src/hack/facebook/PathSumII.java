package hack.facebook;

import hack.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \    / \
7    2  5   1
Return:

[
   [5,4,11,2],
   [5,8,4,5]
]
 */
public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        helper(root, sum, res, new ArrayList<>());
        return res;
    }

    private void helper(TreeNode node, int target, List<List<Integer>> res, List<Integer> currentPath) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            if (node.val == target) {
                currentPath.add(node.val);
                res.add(currentPath);
            }
            return;
        }

        currentPath.add(node.val);

        helper(node.left, target - node.val, res, new ArrayList<>(currentPath));
        helper(node.right, target - node.val, res, new ArrayList<>(currentPath));
    }
}
