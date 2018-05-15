package hack.facebook;

public class PostOrder {
    public static int findNext(TreeNode n) throws Exception {
        if (n == null) throw new Exception();

        TreeNode p = n.parent;

        if (p == null) throw new Exception();

        if (n == p.left) {
            TreeNode node = p.right;
            while (node != null) {
                if (node.left != null) node = node.left;
                else if (node.right != null) node = node.right;
                else return node.value;
            }
        }

        return p.value;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        TreeNode n1 = new TreeNode(4);
        TreeNode n2 = new TreeNode(10);
        TreeNode n3 = new TreeNode(1);
        TreeNode n4 = new TreeNode(5);
        TreeNode n5 = new TreeNode(9);
        TreeNode n6 = new TreeNode(22);
        TreeNode n7 = new TreeNode(12);
        TreeNode n8 = new TreeNode(3);

        root.left = n1;
        root.right = n2;
        n1.left = n3;
        n1.right = n4;
        n1.parent = root;
        n2.left = n5;
        n2.right = n6;
        n3.parent = n1;
        n4.parent = n1;
        n5.parent = n2;
        n6.parent = n2;
        n2.parent = root;
        n5.right = n7;
        n7.parent = n5;
        n7.left = n8;

        try {
            int val = findNext(n1);
            assert val == 3;
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

class TreeNode {
    TreeNode left, right, parent;
    int value;

    public TreeNode(int value) {
        this.value = value;
    }
}