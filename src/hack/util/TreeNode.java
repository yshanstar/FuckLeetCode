package hack.util;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int v) {
        this.val = v;
        this.left = null;
        this.right = null;
    }

    public TreeNode(int v, TreeNode left, TreeNode right) {
        this.val = v;
        this.left = left;
        this.right = right;
    }
}
