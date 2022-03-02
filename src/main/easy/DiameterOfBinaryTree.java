package main.easy;

import struct.TreeNode;

@SuppressWarnings("unused")
public class DiameterOfBinaryTree {
    private int max;

    /**
     * 543. 二叉树的直径
     *
     * @param root 二叉树
     * @return 二叉树的直径长度。二叉树的直径长度是任意两个结点路径长度中的最大值，这条路径可能穿过也可能不穿过根结点
     */
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);

        return max;
    }

    /**
     * 计算二叉树的深度
     *
     * @param root 二叉树
     * @return 二叉树的深度
     */
    private int depth(TreeNode root) {
        if (root == null)
            return 0;

        int left = depth(root.left), right = depth(root.right);
        max = Math.max(max, left + right); // 计算出左右子树深度的同时计算以当前节点为中心时的直径

        return Math.max(left, right) + 1;
    }
}
