package main.easy;

import struct.TreeNode;

@SuppressWarnings("unused")
public class MergeTwoBinaryTrees {
    /**
     * 617. 合并二叉树
     *
     * @param root1 二叉树1
     * @param root2 二叉树2
     * @return 合并后的二叉树。如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点
     */
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null)
            return root2;

        if (root2 == null)
            return root1;

        TreeNode root = new TreeNode(root1.val + root2.val);

        root.left = mergeTrees(root1.left, root2.left);
        root.right = mergeTrees(root1.right, root2.right);

        return root;
    }
}
