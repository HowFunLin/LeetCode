package main.easy;

import struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class FindModeInBinarySearchTree {
    private List<Integer> temp = new ArrayList<>();
    private int base, count, maxCount;

    /**
     * 501. 二叉搜索树中的众数
     *
     * @param root 含重复值的二叉搜索树（BST）的根节点
     * @return BST 中的所有 众数（即，出现频率最高的元素）。如果树中有不止一个众数，可以按 任意顺序 返回
     */
    public int[] findMode(TreeNode root) {
        TreeNode cur = root, pre;

        // Morris 中序遍历
        while (cur != null) {
            if (cur.left == null) {
                update(cur.val);

                cur = cur.right;

                continue;
            }

            pre = cur.left;

            while (pre.right != null && pre.right != cur)
                pre = pre.right;

            if (pre.right == null) {
                pre.right = cur;
                cur = cur.left;
            } else { // 前驱节点已被访问，直接访问当前节点
                pre.right = null;

                update(cur.val);

                cur = cur.right;
            }
        }

        int size = temp.size();
        int[] res = new int[size];

        for (int i = 0; i < size; i++)
            res[i] = temp.get(i);

        return res;
    }

    /**
     * 更新众数
     *
     * @param cur 当前节点的节点值
     */
    private void update(int cur) {
        if (cur == base)
            count++;
        else {
            base = cur;
            count = 1;
        }

        if (count == maxCount)
            temp.add(cur);
        else if (count > maxCount) {
            maxCount = count;

            temp.clear();
            temp.add(cur);
        }
    }
}
