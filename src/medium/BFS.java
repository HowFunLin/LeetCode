package medium;

import struct.TreeNode;

import java.util.*;

public class BFS {
    public int[] levelOrder(TreeNode root) {
        if (root == null)
            return new int[]{};

        List<Integer> traversal = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty())
        {
            int size = queue.size();

            for (int i = 0; i < size; i++)
            {
                TreeNode cur = queue.poll();

                traversal.add(cur.val);

                if (cur.left != null)
                    queue.offer(cur.left);
                if (cur.right != null)
                    queue.offer(cur.right);
            }
        }

        int[] res = new int[traversal.size()];
        for (int i = 0; i < traversal.size(); i++)
            res[i] = traversal.get(i);

        return res;
    }
}
