package hack.facebook;

import hack.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
Example 1:
Input:
    3
   / \
  9  20
    /  \
   15   7
Output: [3, 14.5, 11]
Explanation:
The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
Note:
The range of node's value is in the range of 32-bit signed integer.
 */
public class AverageOfLevelsInBinaryTree {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);
        long sum = 0;
        int count = 0;
        Queue<TreeNode> levelNode = new LinkedList<>();

        while (!nodeQueue.isEmpty()) {
            TreeNode tmp = nodeQueue.poll();
            sum += tmp.val;
            count++;
            if (tmp.left != null) {
                levelNode.offer(tmp.left);
            }

            if (tmp.right != null) {
                levelNode.offer(tmp.right);
            }

            if (nodeQueue.isEmpty()) {
                nodeQueue = levelNode;
                levelNode = new LinkedList<>();
                res.add(sum * 1.0 / count);
                sum = 0;
                count = 0;
            }
        }

        return res;
    }
}
