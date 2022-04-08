package main.medium;

import struct.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@SuppressWarnings("unused")
public class N_AryTreeLevelOrderTraversal {
    /**
     * 429. N 叉树的层序遍历
     *
     * @param root N 叉树根节点
     * @return N 叉树节点值的层序遍历
     */
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new LinkedList<>();

        if (root == null)
            return res;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>(size);

            for (int i = 0; i < size; i++) {
                Node cur = queue.poll();

                list.add(cur.val);

                for (Node child : cur.children) {
                    queue.offer(child);
                }
            }

            res.add(list);
        }

        return res;
    }
}
