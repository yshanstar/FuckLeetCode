package hack.facebook;

import hack.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
Given a binary tree, write a function to get the maximum width of the given tree. The width of a tree is the maximum width among all levels. The binary tree has the same structure as a full binary tree, but some nodes are null.

The width of one level is defined as the length between the end-nodes (the leftmost and right most non-null nodes in the level, where the null nodes between the end-nodes are also counted into the length calculation.

Example 1:
Input:

           1
         /   \
        3     2
       / \     \
      5   3     9

Output: 4
Explanation: The maximum width existing in the third level with the length 4 (5,3,null,9).
Example 2:
Input:

          1
         /
        3
       / \
      5   3

Output: 2
Explanation: The maximum width existing in the third level with the length 2 (5,3).
Example 3:
Input:

          1
         / \
        3   2
       /
      5

Output: 2
Explanation: The maximum width existing in the second level with the length 2 (3,2).
Example 4:
Input:

          1
         / \
        3   2
       /     \
      5       9
     /         \
    6           7
Output: 8
Explanation:The maximum width existing in the fourth level with the length 8 (6,null,null,null,null,null,null,7).


Note: Answer will in the range of 32-bit signed integer.


 */
public class MaximumWidthBinaryTree {
    /*
     * Reference:
     * https://leetcode.com/problems/maximum-width-of-binary-tree/discuss/106645/C%2B%2BJava-*-BFSDFS3liner-Clean-Code-With-Explanation
     *
     * The idea is to use heap indexing:
     *         1
     *    2         3
     *  4   5     6   7
     * 8 9 x 11  x 13 x 15
     * Regardless whether these nodes exist:

     * Always make the id of left child as parent_id * 2;
     * Always make the id of right child as parent_id * 2 + 1;
     * So we can just:

     * Record the id of left most node when first time at each level of the tree during an pre-order run.(you can tell by check the size of the
     * container
     *  to hold the first nodes);
     * At each node, compare the distance from it the left most node with the current max width;
     */
    public int widthOfBinaryTree(TreeNode root) {
        List<Integer> leftMostIdx = new ArrayList<>();
        return dfs(root, 1, 0, leftMostIdx);
    }

    private int dfs(TreeNode node, int idx, int depth, List<Integer> leftMostIdx) {
        if (node == null) {
            return 0;
        }

        if (depth >= leftMostIdx.size()) {
            leftMostIdx.add(idx);
        }

        return Math.max(idx + 1 - leftMostIdx.get(depth),
                Math.max(dfs(node.left, idx * 2, depth + 1, leftMostIdx),
                        dfs(node.right, idx * 2 + 1, depth + 1, leftMostIdx)));
    }
}
