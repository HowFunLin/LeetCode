package main.easy;

import struct.TreeNode;

@SuppressWarnings("unused")
public class SameTree {
    /**
     * 100. 相同的树
     *
     * @param p 二叉树的根节点
     * @param q 二叉树的根节点
     * @return 两棵树是否相同。如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;

        if ((p == null && q != null) || (p != null && q == null) || (p.val != q.val))
            return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
