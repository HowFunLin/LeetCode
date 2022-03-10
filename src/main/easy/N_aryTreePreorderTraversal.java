package main.easy;

import struct.Node;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class N_aryTreePreorderTraversal {
    List<Integer> res = new ArrayList<>();

    /**
     * 589. N 叉树的前序遍历
     *
     * @param root n 叉树的根节点  root
     * @return 其节点值的 前序遍历 的集合
     */
    public List<Integer> preorder(Node root) {
        preorderTraversal(root);

        return res;
    }

    /**
     * 前序遍历 N 叉树并将遍历到的节点加入集合
     *
     * @param node 当前遍历的节点
     */
    private void preorderTraversal(Node node) {
        if (node == null)
            return;

        res.add(node.val);

        for (Node child : node.children)
            preorderTraversal(child);
    }
}
