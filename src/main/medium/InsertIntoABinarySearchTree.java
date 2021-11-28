package main.medium;

import struct.TreeNode;

@SuppressWarnings("unused")
public class InsertIntoABinarySearchTree {
    /**
     * 701. 二叉搜索树中的插入操作
     *
     * @param root 二叉搜索树（BST）的根节点
     * @param val  要插入树中的值，保证新值和原始二叉搜索树中的任意节点值都不同
     * @return 插入后二叉搜索树的根节点
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null)
            return new TreeNode(val);

        if (val > root.val)
            root.right = insertIntoBST(root.right, val);
        else
            root.left = insertIntoBST(root.left, val);

        return root;
    }
}
