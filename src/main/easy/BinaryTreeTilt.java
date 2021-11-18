package main.easy;

import struct.TreeNode;

@SuppressWarnings("unused")
public class BinaryTreeTilt {
    private int sum;

    /**
     * 563. 二叉树的坡度
     *
     * @param root 二叉树根节点
     * @return 整个树 的坡度。树的 节点的坡度 定义即为，该节点左子树的节点之和和右子树节点之和的 差的绝对值 。如果没有左子树的话，左子树的节点之和为 0 ；没有右子树的话也是一样。空结点的坡度是 0。整个树 的坡度就是其所有节点的坡度之和。
     */
    public int findTilt(TreeNode root) {
        if (root != null)
            dfs(root);

        return sum;
    }

    /**
     * 深度优先遍历
     *
     * @param node 二叉树节点
     * @return 当前节点左右子树节点之和
     */
    private int dfs(TreeNode node) {
        if (node.left == null && node.right == null)
            return 0;

        int left = 0, right = 0;

        if (node.left != null)
            left = node.left.val + dfs(node.left);

        if (node.right != null)
            right = node.right.val + dfs(node.right);

        sum += Math.abs(left - right);

        return left + right;
    }
}
