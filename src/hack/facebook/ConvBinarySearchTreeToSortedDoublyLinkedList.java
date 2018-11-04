package hack.facebook;

import hack.util.TreeNode;

/*
Convert a BST to a sorted circular doubly-linked list in-place. Think of the left and right pointers as synonymous to the previous and next pointers in a doubly-linked list.

Let's take the following BST as an example, it may help you understand the problem better:





We want to transform this BST into a circular doubly linked list. Each node in a doubly linked list has a predecessor and successor. For a circular doubly linked list, the predecessor of the first element is the last element, and the successor of the last element is the first element.

The figure below shows the circular doubly linked list for the BST above. The "head" symbol means the node it points to is the smallest element of the linked list.





Specifically, we want to do the transformation in place. After the transformation, the left pointer of the tree node should point to its predecessor, and the right pointer should point to its successor. We should return the pointer to the first element of the linked list.

The figure below shows the transformed BST. The solid line indicates the successor relationship, while the dashed line means the predecessor relationship.


Reference: https://leetcode.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/discuss/149151/Concise-Java-solution-Beats-100
 */
public class ConvBinarySearchTreeToSortedDoublyLinkedList {
    private TreeNode prev = null;

    public TreeNode treeToDoublyList(TreeNode root) {
        if (root == null) {
            return null;
        }

        // dummy is the dummy node which used to track the first node
        TreeNode dummy = new TreeNode(-1, null, null);
        prev = dummy;

        helper(root);

        // connect the head and tail
        // prev is current tail;
        prev.right = dummy.right;
        dummy.right.left = prev;
        return dummy.right;
    }

    private void helper(TreeNode currentNode) {
        if (currentNode == null) {
            return;
        }

        helper(currentNode.left);

        prev.right = currentNode;
        currentNode.left = prev;
        prev = currentNode;

        helper(currentNode.right);
    }
}