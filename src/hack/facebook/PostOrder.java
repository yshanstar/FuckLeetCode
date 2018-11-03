package hack.facebook;


import hack.util.TreeNodeWithParent;

public class PostOrder {
    public static int findNext(TreeNodeWithParent n) throws Exception {
        if (n == null) throw new Exception();

        TreeNodeWithParent p = n.parent;

        if (p == null) throw new Exception();

        if (n == p.left) {
            TreeNodeWithParent node = p.right;
            while (node != null) {
                if (node.left != null) node = node.left;
                else if (node.right != null) node = node.right;
                else return node.value;
            }
        }

        return p.value;
    }

    public static void main(String[] args) {
        TreeNodeWithParent root = new TreeNodeWithParent(8);
        TreeNodeWithParent n1 = new TreeNodeWithParent(4);
        TreeNodeWithParent n2 = new TreeNodeWithParent(10);
        TreeNodeWithParent n3 = new TreeNodeWithParent(1);
        TreeNodeWithParent n4 = new TreeNodeWithParent(5);
        TreeNodeWithParent n5 = new TreeNodeWithParent(9);
        TreeNodeWithParent n6 = new TreeNodeWithParent(22);
        TreeNodeWithParent n7 = new TreeNodeWithParent(12);
        TreeNodeWithParent n8 = new TreeNodeWithParent(3);

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