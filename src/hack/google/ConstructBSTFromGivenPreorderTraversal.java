package hack.google;

import hack.util.TreeNode;

/*
 * Given preorder traversal of a binary search tree, construct the BST.

For example, if the given traversal is {10, 5, 1, 7, 40, 50}, then the output should be root of following tree.

     10
   /   \
  5     40
 /  \      \
1    7      50
Method 1 ( O(n^2) time complexity )
The first element of preorder traversal is always root. We first construct the root. Then we find the index of first element which is greater than root. Let the index be ¡®i¡¯. The values between root and ¡®i¡¯ will be part of left subtree, and the values between ¡®i+1¡ä and ¡®n-1¡ä will be part of right subtree. Divide given pre[] at index ¡°i¡± and recur for left and right sub-trees.
For example in {10, 5, 1, 7, 40, 50}, 10 is the first element, so we make it root. Now we look for the first element greater than 10, we find 40. So we know the structure of BST is as following.

             10
           /    \
          /      \
  {5, 1, 7}       {40, 50}
We recursively follow above steps for subarrays {5, 1, 7} and {40, 50}, and get the complete tree.
 */
public class ConstructBSTFromGivenPreorderTraversal {
	public TreeNode constructBST(int[] preOrder) {
		return helper(preOrder, 0, preOrder.length - 1, preOrder.length);
	}

	private TreeNode helper(int[] preOrder, int low, int high, int size) {
		if (low > high) {
			return null;
		}

		TreeNode root = new TreeNode(preOrder[low]);

		if (low == high) {
			return root;
		}

		int i = low;
		for (i = low; i <= high; i++) {
			if (preOrder[i] > root.val) {
				break;
			}
		}

		root.left = helper(preOrder, low + 1, i - 1, size);
		root.right = helper(preOrder, i, high, size);

		return root;
	}

	public void inOrder(TreeNode n) {
		if (n == null) {
			return;
		}

		inOrder(n.left);
		System.out.print(n.val + " ");
		inOrder(n.right);
	}

	public static void main(String[] args) {
		int preOrder[] = new int[] { 10, 5, 1, 7, 40, 50 };
		ConstructBSTFromGivenPreorderTraversal test = new ConstructBSTFromGivenPreorderTraversal();

		TreeNode root = test.constructBST(preOrder);
		test.inOrder(root);
	}
}
