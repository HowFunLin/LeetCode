package main.easy;

import struct.TreeNode;

@SuppressWarnings("unused")
public class PathSum {
    /**
     * 112. 路径总和
     *
     * @param root      根节点
     * @param targetSum 目标和
     * @return 该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null)
            return false;

        if (root.left == null && root.right == null)
            return root.val == targetSum;

        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }
}
