package hack.facebook;

import hack.util.TreeNode;

import java.util.HashSet;
import java.util.Set;

/*
Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to the given target.

Example 1:
Input:
    5
   / \
  3   6
 / \   \
2   4   7

Target = 9

Output: True
Example 2:
Input:
    5
   / \
  3   6
 / \   \
2   4   7

Target = 28

Output: False

Reference:
https://leetcode.com/problems/two-sum-iv-input-is-a-bst/discuss/106059/JavaC++-Three-simple-methods-choose-one-you-like

 */
public class TwoSumIV {
    // Method 1
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> nums = new HashSet<>();

        return dfs(nums, root, k);
    }

    private boolean dfs(Set<Integer> nums, TreeNode node, int k) {
        if (node == null) {
            return false;
        }

        if (nums.contains(k - node.val)) {
            return true;
        }

        nums.add(node.val);

        return dfs(nums, node.left, k) || dfs(nums, node.right, k);
    }

    // Method 2
    public boolean findTarget2(TreeNode root, int k) {
        return dfs(root, root, k);
    }

    private boolean dfs(TreeNode root, TreeNode cur, int k) {
        return cur != null && (binarySearch(root, cur, k - cur.val) || dfs(root, cur.left, k) || dfs(root, cur.right, k));
    }

    private boolean binarySearch(TreeNode root, TreeNode cur, int value) {
        return root != null && (((root.val == value) && (root != cur)) || ((root.val < value) && binarySearch(root.right, cur, value)) || (root.val > value) && binarySearch(root.left, cur, value));
    }

}
