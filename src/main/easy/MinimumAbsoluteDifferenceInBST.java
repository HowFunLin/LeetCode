package main.easy;

import struct.TreeNode;

@SuppressWarnings("unused")
public class MinimumAbsoluteDifferenceInBST {
    private int last = -1, res = Integer.MAX_VALUE;

    /**
     * 530. 二叉搜索树的最小绝对差
     *
     * @param root 二叉搜索树的根节点
     * @return 树中任意两不同节点值之间的最小差值。差值是一个正数，其数值等于两值之差的绝对值
     */
    public int getMinimumDifference(TreeNode root) {
        dfs(root);

        return res;
    }

    /**
     * 利用 BST 的性质中序遍历计算节点值的最小差值
     *
     * @param node 当前遍历节点
     */
    private void dfs(TreeNode node) {
        if (node == null)
            return;

        dfs(node.left);

        if (last == -1)
            last = node.val;
        else {
            res = Math.min(res, node.val - last);
            last = node.val;
        }

        dfs(node.right);
    }
}
