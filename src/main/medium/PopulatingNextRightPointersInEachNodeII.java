package main.medium;

import struct.Node;

@SuppressWarnings("unused")
public class PopulatingNextRightPointersInEachNodeII {
    class Solution {
        private Node last, nextStart;

        /**
         * 117. 填充每个节点的下一个右侧节点指针 II
         *
         * @param root 二叉树根节点
         * @return 填充后的二叉树。填充二叉树的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。初始状态下，所有 next 指针都被设置为 NULL
         */
        public Node connect(Node root) {
            if (root == null)
                return null;

            Node start = root;

            // 基于 BFS ，使用链表指针实现常数级空间复杂度
            while (start != null) {
                last = null;
                nextStart = null;

                for (Node node = start; node != null; node = node.next) {
                    if (node.left != null)
                        helper(node.left);

                    if (node.right != null)
                        helper(node.right);
                }

                start = nextStart;
            }

            return root;
        }

        /**
         * 连接当前节点到该层并更新当前层的最后指针及下一层的开始指针
         *
         * @param node 节点
         */
        private void helper(Node node) {
            if (last != null)
                last.next = node;

            if (nextStart == null)
                nextStart = node;

            last = node;
        }
    }
}
