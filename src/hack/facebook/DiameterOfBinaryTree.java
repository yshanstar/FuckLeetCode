package hack.facebook;

import hack.util.TreeNode;

/*
Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

Example:
Given a binary tree
          1
         / \
        2   3
       / \
      4   5
Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

Note: The length of path between two nodes is represented by the number of edges between them.

                5
            /      \
           3       -1
                 /    \
                2     5
              /   \
            12     13
          /   \   /  \
         8    -9 1   10
        /              \
       19              23
      /                 \
     24                 11
 */
public class DiameterOfBinaryTree {
    public int diameterOfBinaryTree(TreeNode root) {

        if (root == null || (root.left == null && root.right == null)) {
            return 0;
        }

        int dia = depth(root.left) + depth(root.right);
        int leftDia = diameterOfBinaryTree(root.left);
        int rightDia = diameterOfBinaryTree(root.right);

        return Math.max(dia, Math.max(leftDia, rightDia));
    }

    private int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }

        return Math.max(depth(node.left), depth(node.right)) + 1;
    }
}
