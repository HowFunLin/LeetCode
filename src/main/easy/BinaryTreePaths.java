package main.easy;

import struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class BinaryTreePaths {
    private StringBuilder builder = new StringBuilder();
    private List<String> res = new ArrayList<>();

    /**
     * 257. 二叉树的所有路径
     *
     * @param root 二叉树的根节点
     * @return 所有从根节点到叶子节点的路径
     */
    public List<String> binaryTreePaths(TreeNode root) {
        backtrack(root);

        return res;
    }

    /**
     * 回溯
     *
     * @param node 当前遍历的节点
     */
    private void backtrack(TreeNode node) {
        int length = builder.length();

        builder.append("->").append(node.val);

        if (node.left == null && node.right == null) {
            res.add(builder.toString().substring(2));
            builder.delete(length, builder.length());
            return;
        }

        if (node.left != null)
            backtrack(node.left);

        if (node.right != null)
            backtrack(node.right);

        builder.delete(length, builder.length());
    }
}
