package main.medium;

import struct.TreeNode;

@SuppressWarnings("all")
public class BinaryTreePruning {
    /**
     * 814. 二叉树剪枝
     *
     * @param root 二叉树的根结点 root ，树的每个结点的值要么是 0 ，要么是 1
     * @return 移除了所有不包含 1 的子树的原二叉树
     */
    public TreeNode pruneTree(TreeNode root) {
        if (root == null)
            return null;

        // 本质上是后序遍历变种，自下往上地断开满足条件的节点
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);

        if (root.left == null && root.right == null && root.val == 0)
            return null;

        return root;
    }
}
