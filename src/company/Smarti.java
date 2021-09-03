package company;

import struct.ListNode;
import struct.TreeNode;

import java.util.ArrayList;

@SuppressWarnings("unused")
public class Smarti {
    private ArrayList<Integer> res = new ArrayList<>();
    private ArrayList<Integer> temp = new ArrayList<>();

    /**
     * 链表合并
     *
     * @param a 链表A
     * @param b 链表B
     * @return 合并后链表
     */
    public ListNode mergeList(ListNode a, ListNode b) {
        if (a == null)
            return b;

        if (b == null)
            return a;

        ListNode head = new ListNode(-1);
        ListNode res = head;

        while (a != null && b != null) {
            if (a.val < b.val) {
                head.next = a;
                head = head.next;
                a = a.next;
            } else if (a.val > b.val) {
                head.next = b;
                head = head.next;
                b = b.next;
            } else {
                head.next = a;
                head = head.next;
                a = a.next;
                b = b.next;
            }
        }

        if (a != null)
            head.next = a;
        if (b != null)
            head.next = b;

        return res.next;
    }

    /**
     * 二叉树中第一条最深路径
     *
     * @param root 根节点
     * @return 最深路径列表
     */
    public ArrayList<Integer> longestPath(TreeNode root) {
        // write code here
        dfs(root);
        return res;
    }

    /**
     * 回溯 + 深度优先
     *
     * @param node 节点
     */
    private void dfs(TreeNode node) {
        temp.add(node.val);

        if (node.left == null && node.right == null) {
            if (temp.size() > res.size())
                res = new ArrayList<>(temp);

            temp.remove(temp.size() - 1);
            return;
        }

        if (node.left != null)
            dfs(node.left);
        if (node.right != null)
            dfs(node.right);

        temp.remove(temp.size() - 1);
    }
}
