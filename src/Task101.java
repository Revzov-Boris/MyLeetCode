public class Task101 {
    public boolean isSymmetric(TreeNode root) {
        return inWalker(root.left, root.right);
    }


    public static boolean inWalker(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null) {
            return true;
        }
        if (n1 != null && n2 == null ||
                n1 == null && n2 != null) {
            return false;
        }
        if (n1.val != n2.val) return false;
        return inWalker(n1.left, n2.right) && inWalker(n1.right, n2.left);
    }



    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
