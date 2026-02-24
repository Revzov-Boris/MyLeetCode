import java.util.ArrayList;
import java.util.List;

public class Task94 {
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList();
        inOrder(root, result);
        return result;
    }


    public static void inOrder(TreeNode root, List<Integer> way) {
        if (root != null) {
            inOrder(root.left, way);
            way.add(root.val);
            inOrder(root.right, way);
        }
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
