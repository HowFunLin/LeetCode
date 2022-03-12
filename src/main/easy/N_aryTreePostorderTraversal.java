package main.easy;

import struct.Node;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class N_aryTreePostorderTraversal {
    private List<Integer> res = new ArrayList<>();

    /**
     * 590. N 叉树的后序遍历
     *
     * @param root n 叉树的根节点  root
     * @return 其节点值的 后序遍历 的集合
     */
    public List<Integer> postorder(Node root) {
        postorderTraversal(root);

        return res;
    }

    /**
     * 后序遍历 N 叉树并将遍历到的节点加入集合
     *
     * @param node 当前遍历的节点
     */
    private void postorderTraversal(Node node) {
        if (node == null)
            return;

        for (Node child : node.children)
            postorderTraversal(child);

        res.add(node.val);
    }
}
