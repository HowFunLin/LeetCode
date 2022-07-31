package main.medium;

import struct.TreeNode;

@SuppressWarnings("unused")
public class MaximumLevelSumOfABinaryTree {
    private long[] levelSum = new long[10001]; // 最大节点数 10000，最多有 10000 层
    private int maxLevel; // 记录最深层，减少对数组的遍历

    /**
     * 1161. 最大层内元素和
     *
     * @return 层内元素之和 最大 的那几层（可能只有一层）的层号其中 最小 的那个
     */
    public int maxLevelSum(TreeNode root) {
        dfs(root, 1);

        long max = Long.MIN_VALUE;
        int level = 1;

        for (int i = 1; i <= maxLevel; i++) {
            long sum = levelSum[i];

            if (sum > max) {
                max = sum;
                level = i; // 该下标即为最小的下标
            }
        }

        return level;
    }

    /**
     * @param level 层数
     */
    private void dfs(TreeNode node, int level) {
        if (node == null)
            return;

        levelSum[level] += node.val;

        if (level > maxLevel)
            maxLevel = level;

        dfs(node.left, level + 1);
        dfs(node.right, level + 1);
    }
}
