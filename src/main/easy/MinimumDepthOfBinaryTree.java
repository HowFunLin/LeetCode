package main.easy;

import struct.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        int depth = 0;

        if (root == null)
            return depth;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        bfs:while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (node.left == null && node.right == null) {
                    depth++;
                    break bfs;
                } else {
                    if (node.left != null)
                        queue.offer(node.left);
                    if (node.right != null)
                        queue.offer(node.right);
                }
            }

            depth++;
        }

        return depth;
    }
}
