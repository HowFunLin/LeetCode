package main.easy;

import struct.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@SuppressWarnings("unused")
public class AverageOfLevelsInBinaryTree {
    /**
     * 637. 二叉树的层平均值
     *
     * @param root 非空二叉树的根节点
     * @return 以数组的形式返回每一层节点的平均值。与实际答案相差 10-5 以内的答案可以被接受
     */
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        // BFS
        while (!queue.isEmpty()) {
            int size = queue.size(), num = size;
            double avg = 0;

            while (size-- > 0) {
                TreeNode cur = queue.poll();

                avg += cur.val;

                if (cur.left != null)
                    queue.offer(cur.left);
                if (cur.right != null)
                    queue.offer(cur.right);
            }

            avg /= num;

            res.add(avg);
        }

        return res;
    }
}
