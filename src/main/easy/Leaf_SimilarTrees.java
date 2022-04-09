package main.easy;

import struct.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

@SuppressWarnings("unused")
public class Leaf_SimilarTrees {
    /**
     * 872. 叶子相似的树
     *
     * @return 两个根结点分别为 root1 和 root2 的树是否叶相似的。如果有两棵二叉树的叶值序列是相同，那么认为它们是 叶相似 的
     */
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        Queue<Integer> sequence1 = new LinkedList<>(), sequence2 = new LinkedList<>();

        if (root1 != null)
            dfs(root1, sequence1);

        if (root2 != null)
            dfs(root2, sequence2);

        return sequence1.equals(sequence2);
    }

    /**
     * 深度优先遍历
     *
     * @param sequence 存储叶子节点序列
     */
    private void dfs(TreeNode node, Queue<Integer> sequence) {
        if (node.left == null && node.right == null) {
            sequence.offer(node.val);
        } else {
            if (node.left != null)
                dfs(node.left, sequence);
            if (node.right != null)
                dfs(node.right, sequence);
        }
    }
}
