package main.medium;

import struct.TreeNode;

@SuppressWarnings("unused")
public class DeleteNodeInABST {
    /**
     * 450. 删除二叉搜索树中的节点
     *
     * @param root 二叉搜索树的根节点 root
     * @param key  值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变
     * @return 二叉搜索树（有可能被更新）的根节点的引用
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return root;

        if (root.val == key)
            return newTree(root);

        if (root.val > key)
            root.left = deleteNode(root.left, key);

        if (root.val < key)
            root.right = deleteNode(root.right, key);

        return root;
    }

    /**
     * 更新以 要删除的节点 为根的树
     *
     * @param root 要删除的节点
     * @return 删除节点后生成的树的根节点的引用
     */
    private TreeNode newTree(TreeNode root) {
        if (root.left == null && root.right == null)
            return null;

        if (root.left == null)
            return root.right;

        if (root.right == null)
            return root.left;

        TreeNode pre = root, cur = root.right;

        while (cur.left != null) {
            pre = cur;
            cur = cur.left;
        }

        // 用 右子树 的 最左节点 替换 要删除的节点
        if (cur != root.right) {
            pre.left = cur.right;
            cur.left = root.left;
            cur.right = root.right;
        }
        // 右子树 不存在 左节点 则 直接在 右子树 插入 要删除的节点 的 左子树
        else {
            cur.left = root.left;
        }

        return cur;
    }
}
