package main.medium;

import struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class AllElementsInTwoBinarySearchTrees {
    /**
     * 1305. 两棵二叉搜索树中的所有元素
     *
     * @return 包含 两棵树 中的所有整数并按 升序 排序的列表
     */
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>(5000), list2 = new ArrayList<>(5000);

        inorder(list1, root1);
        inorder(list2, root2);

        int m = list1.size(), n = list2.size();
        List<Integer> res = new ArrayList<>(m + n);
        int i = 0, j = 0;

        while (true) {
            if (i == m) {
                res.addAll(list2.subList(j, n));
                break;
            }

            if (j == n) {
                res.addAll(list1.subList(i, m));
                break;
            }

            if (list1.get(i) < list2.get(j))
                res.add(list1.get(i++));
            else
                res.add(list2.get(j++));
        }

        return res;
    }

    /**
     * 中序遍历
     */
    private void inorder(List<Integer> list, TreeNode node) {
        if (node != null) {
            inorder(list, node.left);

            list.add(node.val);

            inorder(list, node.right);
        }
    }
}
