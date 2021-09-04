package main.medium;

import struct.TreeNode;

import java.util.*;

@SuppressWarnings("unused")
public class BinaryTreeZigzagLevelOrderTraversal {
    // 定义为域，供方法调用
    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();

        if (root == null) {
            return ans;
        }

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);
        boolean isOrderLeft = true;

        while (!nodeQueue.isEmpty()) {
            Deque<Integer> levelList = new LinkedList<>();
            int size = nodeQueue.size();

            for (int i = 0; i < size; ++i) {
                TreeNode curNode = nodeQueue.poll();

                if (isOrderLeft) {
                    levelList.offerLast(curNode.val);
                } else {
                    levelList.offerFirst(curNode.val);
                }

                if (curNode.left != null) {
                    nodeQueue.offer(curNode.left);
                }

                if (curNode.right != null) {
                    nodeQueue.offer(curNode.right);
                }
            }

            ans.add(new LinkedList<>(levelList));

            isOrderLeft = !isOrderLeft;
        }

        return ans;
    }

    /**
     * 剑指 Offer 32 - III. 从上到下打印二叉树 III
     *
     * @param root 二叉树根节点
     * @return 之字形遍历结果
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        levelOrder(root, 0);

        for (int i = 1; i < ans.size(); i = i + 2)
            Collections.reverse(ans.get(i));


        return ans;
    }

    /**
     * DFS存储遍历结果
     *
     * @param root  二叉树结点
     * @param level 层次
     */
    private void levelOrder(TreeNode root, int level) {
        if (root == null)
            return;

        if (level >= ans.size())
            ans.add(new ArrayList<>());

        ans.get(level).add(root.val);

        levelOrder(root.left, level + 1);
        levelOrder(root.right, level + 1);
    }
}
