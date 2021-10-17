package main.medium;

import struct.TreeNode;

@SuppressWarnings("unused")
public class KthSmallestElementInABST {
    private int order = 1;
    private int k;
    private TreeNode res;

    /**
     * 230. 二叉搜索树中第K小的元素
     *
     * @param root 二叉搜索树的根节点
     * @param k    整数
     * @return 其中第 k 个最小元素（从 1 开始计数）
     */
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        inorder(root);

        return res.val;
    }

    /**
     * 中序遍历
     *
     * @param node 树结点
     */
    private void inorder(TreeNode node) {
        if (node.left != null)
            inorder(node.left);

        if (order == k)
            res = node;

        order++;

        if (node.right != null)
            inorder(node.right);
    }
}
