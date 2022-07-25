package main.medium;

import struct.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

@SuppressWarnings("unused")
public class CompleteBinaryTreeInserter {
    /**
     * 919. 完全二叉树插入器
     */
    class CBTInserter {
        // private ArrayList<TreeNode> tree = new ArrayList<>();
        private Queue<TreeNode> queue; // 只存储左右子节点未满的节点而不存储整棵树
        private TreeNode root;

        public CBTInserter(TreeNode root) {
            queue = new LinkedList<>();
            this.root = root;

            Queue<TreeNode> temp = new LinkedList<>();

            temp.offer(root);

            while (!temp.isEmpty()) {
                TreeNode node = temp.poll();

//                tree.add(node);

                if (node.left != null)
                    temp.offer(node.left);
                if (node.right != null)
                    temp.offer(node.right);

                if (node.left == null || node.right == null)
                    queue.offer(node);
            }
        }

        /**
         * 向树中插入一个值为 Node.val == val的新节点
         *
         * @return 插入节点 TreeNode 的父节点的值
         */
        public int insert(int val) {
            TreeNode node = new TreeNode(val);

//            tree.add(node);

//            int cur = tree.size();
//            TreeNode parent = tree.get(cur / 2 - 1);
//
//            if ((cur & 1) == 0)
//                parent.left = node;
//            else
//                parent.right = node;

            TreeNode parent = queue.peek();

            if (parent.left == null)
                parent.left = node;
            else if (parent.right == null) {
                parent.right = node;
                queue.poll(); // 左右节点已填充则出队
            }

            queue.offer(node);

            return parent.val;
        }

        public TreeNode get_root() {
//            return tree.get(0);
            return root;
        }
    }
}
