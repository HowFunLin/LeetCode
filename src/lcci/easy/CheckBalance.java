package lcci.easy;

import struct.TreeNode;

@SuppressWarnings("unused")
public class CheckBalance {
    /**
     * 面试题 04.04. 检查平衡性
     *
     * @param root 二叉树根节点
     * @return 二叉树是否平衡。在这个问题中，平衡树的定义如下：任意一个节点，其两棵子树的高度差不超过 1
     */
    public boolean isBalanced(TreeNode root) {
        return height(root) >= 0;
    }

    /**
     * 二叉树的高度
     *
     * @param node 二叉树节点
     * @return 二叉树平衡时返回 树的高度 ；否则，返回 -1
     */
    private int height(TreeNode node) {
        if (node == null)
            return 0;

        int left = height(node.left);
        int right = height(node.right);

        if (left == -1 || right == -1 || Math.abs(left - right) > 1)
            return -1;

        return Math.max(left, right) + 1;
    }
}
