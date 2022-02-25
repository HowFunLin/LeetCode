package main.medium;

import struct.TreeNode;

@SuppressWarnings("unused")
public class ConvertBSTToGreaterTree {
    private int sum;

    /**
     * 538. 把二叉搜索树转换为累加树
     *
     * @param root 二叉 搜索 树的根节点
     * @return 转换得到的累加树（Greater Sum Tree），使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和
     */
    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right); // 每个节点均向右遍历到最深
            sum += root.val;
            root.val = sum;
            convertBST(root.left); // 计算出结果后向左遍历是否有节点
        }

        return root;
    }
}
