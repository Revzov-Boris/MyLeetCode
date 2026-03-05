import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Task102 {
    // решение через очередь
    public List<List<Integer>> levelOrderByQueue(TreeNode root) {
        List<List<Integer>> list = new ArrayList();
        if (root == null) return list;
        // узлы текущего уровня
        Queue<TreeNode> level = new ArrayBlockingQueue<>(2000);
        level.add(root);
        while (!level.isEmpty()) {
            List<Integer> addLevel = new ArrayList();
            int nowSize = level.size();
            // добавляем в список только значения узлов текущего уровня
            for (int i = 0; i < nowSize; i++) {
                TreeNode node = level.poll();
                addLevel.add(node.val);
                // для сохранения порядка очереди сначала левое, затем правое
                if (node.left != null) level.add(node.left);
                if (node.right != null) level.add(node.right);
            }
            list.add(addLevel);
        }
        return list;
    }


    // рекурсия
    // посещаем узлы не в идеальном порядке, но слева на право, и добавляем в правильный подсписок
    // лист result - ответ
    public static void bfs(List<List<Integer>> result, TreeNode node, int level) {
        if (node == null) return;
        if (level == result.size()) {
            result.add(new ArrayList());
        }
        result.get(level).add(node.val);
        bfs(result, node.left, level+1);
        bfs(result, node.right, level+1);
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
