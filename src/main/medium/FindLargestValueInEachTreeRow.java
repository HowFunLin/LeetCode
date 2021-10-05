package main.medium;

import struct.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

@SuppressWarnings("unused")
public class FindLargestValueInEachTreeRow {
    /**
     * 515. 在每个树行中找最大值
     *
     * @param root 二叉树根节点
     * @return 每一层的最大值的集合
     */
    public List<Integer> largestValues(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();

        queue.offer(root);

        while (!queue.isEmpty()) {
            int max = Integer.MIN_VALUE, size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();

                if (cur != null)
                {
                    if (cur.val > max)
                        max = cur.val;

                    if (cur.left != null)
                        queue.offer(cur.left);
                    if (cur.right != null)
                        queue.offer(cur.right);
                }
            }

            res.add(max);
        }

        return res;
    }
}
