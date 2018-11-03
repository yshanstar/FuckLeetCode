package hack.facebook;

import hack.util.TreeNode;

import java.util.HashMap;
import java.util.Map;

/*
You are given a binary tree in which each node contains an integer value.

Find the number of paths that sum to a given value.

The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).

The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.

Example:

root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1

Return 3. The paths that sum to 8 are:

1.  5 -> 3
2.  5 -> 2 -> 1
3. -3 -> 11
 */
public class PathSumIII {

    /*
    Reference:
    https://leetcode.com/problems/path-sum-iii/discuss/91878/17-ms-O(n)-java-Prefix-sum-method
     */
    public int pathSum(TreeNode root, int sum) {
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);
        return helper(root, 0, sum, preSum);
    }

    private int helper(TreeNode node, int currentSum, int target, Map<Integer, Integer> preSum) {
        if (node == null) {
            return 0;
        }

        currentSum += node.val;
        int res = preSum.getOrDefault(currentSum - target, 0);
        preSum.put(currentSum, preSum.getOrDefault(currentSum, 0) + 1);

        res += helper(node.left, currentSum, target, preSum) + helper(node.right, currentSum, target, preSum);
        preSum.put(currentSum, preSum.get(currentSum) - 1);
        return res;
    }
}
