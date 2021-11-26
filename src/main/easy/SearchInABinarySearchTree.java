package main.easy;

import struct.TreeNode;

@SuppressWarnings("unused")
public class SearchInABinarySearchTree {
    /**
     * 700. 二叉搜索树中的搜索
     *
     * @param root 根节点
     * @param val  给定值
     * @return 以BST中节点值等于给定值的节点为根的子树。 如果节点不存在，则返回 NULL
     */
    public TreeNode searchBST(TreeNode root, int val) {
        while (root != null) {
            if (val > root.val)
                root = root.right;
            else if (val < root.val)
                root = root.left;
            else
                return root;
        }

        return null;
    }
}
