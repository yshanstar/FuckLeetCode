package hack.google;

import hack.util.TreeNode;

/*
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

For example, you may serialize the following tree

    1
   / \
  2   3
     / \
    4   5
as "[1,2,3,null,null,4,5]", just the same as how LeetCode OJ serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
 */
public class SerializeAndDeserializeBinaryTree {
	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		serializeHelper(root, sb);
		return sb.substring(0, sb.length() - 1);
	}

	private void serializeHelper(TreeNode node, StringBuilder sb) {
		if (node == null) {
			sb.append("#,");
		} else {
			sb.append(node.val + ",");
			serializeHelper(node.left, sb);
			serializeHelper(node.right, sb);
		}
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		String[] nodes = ("#," + data).split(",");
		TreeNode dummy = new TreeNode(0);
		deserializeHelper(dummy, 0, nodes);
		return dummy.right;
	}
	
	private int deserializeHelper(TreeNode root, int index, String[] nodes){
		if(root == null) {
			return index;
		}
		else {
	        String left = nodes[index++];
	        if(!left.equals("#")) {
	            root.left = new TreeNode(Integer.parseInt(left));
	            index = deserializeHelper(root.left, index, nodes);
	        }
	        String right = nodes[index++];
	        if(!right.equals("#")) {
	            root.right = new TreeNode(Integer.parseInt(right));
	            index = deserializeHelper(root.right, index, nodes);
	        }
	    }
	    return index;
	}

	public static void main(String[] args) {
		SerializeAndDeserializeBinaryTree test = new SerializeAndDeserializeBinaryTree();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(5);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		String s = test.serialize(root);
		test.deserialize(s);
	}
}
