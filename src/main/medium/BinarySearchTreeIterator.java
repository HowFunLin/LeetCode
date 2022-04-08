package main.medium;

import struct.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

@SuppressWarnings("unused")
public class BinarySearchTreeIterator {
    /**
     * 173. 二叉搜索树迭代器
     */
    class BSTIterator {
        private TreeNode cur;
        private Deque<TreeNode> stack;

        public BSTIterator(TreeNode root) {
            cur = root;
            stack = new LinkedList<>(); // 满足最大空间复杂度为 O(h)，若要求 O(n) 可用数组存储中序遍历结果
        }

        /**
         * @return 将指针向右移动后指针处的数字
         */
        public int next() {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();

            int res = cur.val;

            cur = cur.right;

            return res;
        }

        /**
         * @return 向指针右侧遍历是否存在数字
         */
        public boolean hasNext() {
            // cur 不等于 null 或 栈中仍有出栈的元素 即为还有后续节点
            return cur != null || !stack.isEmpty();
        }
    }
}
