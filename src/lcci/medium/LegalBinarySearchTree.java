package lcci.medium;

import struct.TreeNode;

@SuppressWarnings("unused")
public class LegalBinarySearchTree {
    /**
     * 面试题 04.05. 合法二叉搜索树
     *
     * @param root 二叉树根节点
     * @return 二叉树是否为二叉搜索树
     */
    public boolean isValidBST(TreeNode root) {
        return dfs(root, null, null);
    }

    /**
     * 检查二叉树是否为二叉搜索树
     *
     * @param node 当前节点
     * @param low  当前节点所允许的最小值
     * @param high 当前节点所允许的最大值
     * @return 二叉树是否为二叉搜索树
     */
    private boolean dfs(TreeNode node, Integer low, Integer high) {
        if (node == null)
            return true;

        int val = node.val;

        if (low != null && val <= low)
            return false;

        if (high != null && val >= high)
            return false;

        // 当前节点在合法范围内，继续判断左右子树
        return dfs(node.right, val, high) && dfs(node.left, low, val);
    }
}
