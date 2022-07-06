package main.easy;

import struct.TreeNode;

@SuppressWarnings("unused")
public class SumOfRootToLeafBinaryNumbers {
    private int temp, sum;

    /**
     * 1022. 从根到叶的二进制数之和
     *
     * @return 从根到树上的每一片叶子的路径所表示的二进制数之和，用十进制表示
     */
    public int sumRootToLeaf(TreeNode root) {
        dfs(root);

        return sum;
    }

    /**
     * 回溯
     */
    private void dfs(TreeNode node) {
        temp = (temp << 1) + node.val;

        if (node.left == null && node.right == null) {
            sum += temp;
            temp = (temp - node.val) >> 1;

            return;
        }

        if (node.left != null)
            dfs(node.left);

        if (node.right != null)
            dfs(node.right);

        temp = (temp - node.val) >> 1;
    }
}
