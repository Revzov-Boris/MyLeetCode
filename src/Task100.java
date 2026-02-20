public class Task100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return isSame(p, q) == 0;
    }


    // -1 -> not same; 0 -> same
    public static int isSame(TreeNode p, TreeNode q) {
        // сначала проверка на null
        if (p == null && q == null) {
            return 0;
        }
        if (p != null && q == null || p == null && q != null) {
            return -1;
        }
        // затем проверка на значение и на наличие левых и правых узлов
        if (p.val != q.val ||
                p.left == null && q.left != null ||
                p.left != null && q.left == null ||
                p.right == null && q.right != null ||
                p.right != null && q.right == null) {
            return -1;
        }
        // после предыдущей проверки остаются только такие 'q' и 'p', у которых
        // левый/правый узел присутствует или отсутствует у ОБОИХ
        if (p.left == null && p.right == null) {
            return 0;
        }
        if (p.left != null && p.right != null) {
            return isSame(p.left, q.left) + isSame(p.right, q.right);
        }
        if (p.left != null) {
            return isSame(p.left, q.left);
        }
        return isSame(p.right, q.right);
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
