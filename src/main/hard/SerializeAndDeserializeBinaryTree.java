package main.hard;

import struct.TreeNode;

import java.util.Collections;
import java.util.LinkedList;

@SuppressWarnings("unused")
public class SerializeAndDeserializeBinaryTree {
    /**
     * 297. 二叉树的序列化与反序列化
     */
    class Codec {
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();

            preorder(root, sb);

            return sb.toString();
        }

        /**
         * 先序遍历
         *
         * @param sb StringBuilder 优化字符串拼接
         */
        private void preorder(TreeNode node, StringBuilder sb) {
            if (node == null) {
                sb.append("null,");
                return;
            }

            sb.append(node.val).append(",");

            preorder(node.left, sb);
            preorder(node.right, sb);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            LinkedList<String> dataList = new LinkedList<>();

            Collections.addAll(dataList, data.split(","));

            return construct(dataList);
        }

        /**
         * 根据先序遍历顺序构造树
         */
        private TreeNode construct(LinkedList<String> data) {
            String cur = data.removeFirst();

            if (cur.equals("null"))
                return null;

            TreeNode node = new TreeNode(Integer.valueOf(cur));

            node.left = construct(data);
            node.right = construct(data);

            return node;
        }
    }
}
