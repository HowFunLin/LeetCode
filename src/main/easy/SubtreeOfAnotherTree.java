package main.easy;

import struct.TreeNode;

@SuppressWarnings("unused")
public class SubtreeOfAnotherTree {
    /**
     * 572. 另一棵树的子树
     *
     * @param root    二叉树
     * @param subRoot 二叉树
     * @return root 中是否包含和 subRoot 具有相同结构和节点值的子树
     */
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null)
            return true;
        if (root == null)
            return false;

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot) || isSameTree(root, subRoot);
    }

    /**
     * 判断两颗二叉树结构和节点值是否相同
     *
     * @param root    二叉树
     * @param subRoot 二叉树
     * @return 两颗二叉树结构和节点值是否相同
     */
    private boolean isSameTree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null)
            return true;

        if (root == null || subRoot == null || root.val != subRoot.val)
            return false;

        return isSameTree(root.left, subRoot.left) && isSameTree(root.right, subRoot.right);
    }
}
