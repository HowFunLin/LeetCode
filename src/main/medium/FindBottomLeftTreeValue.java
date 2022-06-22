package main.medium;

import struct.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

@SuppressWarnings("unused")
public class FindBottomLeftTreeValue {
    private int depth = -1; // 记录当前遍历的深度

    /**
     * 513. 找树左下角的值
     *
     * @param root 二叉树的 根节点
     * @return 二叉树的 最底层 最左边 节点的值
     */
    public int findBottomLeftValue(TreeNode root) {
        return dfs(root, root.val, 0);
    }

    private int dfs(TreeNode node, int val, int depth) {
        // 直接返回更深层的叶子节点，由于优先向左节点遍历，因此一定为最左边节点
        if (node.left == null && node.right == null && depth > this.depth) {
            val = node.val;
            this.depth = depth;

            return val;
        }

        if (node.left != null)
            val = dfs(node.left, val, depth + 1);

        if (node.right != null)
            val = dfs(node.right, val, depth + 1);

        return val;
    }

    /**
     * 从右向左的广度优先遍历
     */
    private int bfs(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        int res = 0;

        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();

            if (cur.right != null)
                queue.offer(cur.right);

            if (cur.left != null)
                queue.offer(cur.left);

            if (queue.isEmpty())
                res = cur.val;
        }

        return res;
    }
}
