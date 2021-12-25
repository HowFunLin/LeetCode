package main.medium;

import struct.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

@SuppressWarnings("unused")
public class EvenOddTree {
    /**
     * 1609. 奇偶树
     *
     * @param root 二叉树的根节点
     * @return 二叉树是否为 奇偶树。二叉树根节点所在层下标为 0 ，根的子节点所在层下标为 1 ，根的孙节点所在层下标为 2 ，依此类推；偶数下标 层上的所有节点的值都是 奇 整数，从左到右按顺序 严格递增；奇数下标 层上的所有节点的值都是 偶 整数，从左到右按顺序 严格递减
     */
    public boolean isEvenOddTree(TreeNode root) {
        boolean isEven = true;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size(), temp = isEven ? 0 : 1000001;

            while (size-- > 0) {
                TreeNode node = queue.poll();
                int cur = node.val;

                if (isEven && (cur % 2 == 0 || cur <= temp))
                    return false;
                if (!isEven && (cur % 2 != 0 || cur >= temp))
                    return false;

                temp = cur;

                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }

            isEven = !isEven;
        }

        return true;
    }
}
