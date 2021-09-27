package lcci.medium;

import struct.ListNode;
import struct.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

@SuppressWarnings("unused")
public class ListOfDepth {
    /**
     * 面试题 04.03. 特定深度节点链表
     *
     * @param tree 二叉树
     * @return 包含所有深度上所有节点的链表（比如，若一棵树的深度为 D，则会创建出 D 个链表）的数组
     */
    public ListNode[] listOfDepth(TreeNode tree) {
        if (tree == null)
            return new ListNode[0];

        List<ListNode> res = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();

        queue.offer(tree);

        while (!queue.isEmpty()) {
            int times = queue.size();

            ListNode head = new ListNode(0);
            ListNode ptr = head;

            for (int i = 0; i < times; i++) {
                TreeNode cur = queue.poll();

                if (cur != null) {
                    if (cur.left != null)
                        queue.offer(cur.left);
                    if (cur.right != null)
                        queue.offer(cur.right);

                    ptr.next = new ListNode(cur.val);
                }

                ptr = ptr.next;
            }

            res.add(head.next);
        }

        return res.toArray(new ListNode[0]);
    }
}
