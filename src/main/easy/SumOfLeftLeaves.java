package main.easy;

import struct.TreeNode;

@SuppressWarnings("unused")
public class SumOfLeftLeaves {
    private int sum;

    /**
     * 404. 左叶子之和
     *
     * @param root 二叉树的根节点
     * @return 所有左叶子之和
     */
    public int sumOfLeftLeaves(TreeNode root) {
        dfs(root);

        return sum;
    }

    /**
     * 深度优先遍历
     *
     * @param node 当前遍历节点
     */
    private void dfs(TreeNode node) {
        if (node == null)
            return;

        if (node.left != null && node.left.left == null && node.left.right == null)
            sum += node.left.val;

        dfs(node.left);
        dfs(node.right);
    }
}
