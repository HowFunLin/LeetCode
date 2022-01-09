package main.easy;

import struct.TreeNode;

@SuppressWarnings("unused")
public class ConvertSortedArrayToBinarySearchTree {
    /**
     * 108. 将有序数组转换为二叉搜索树
     *
     * @param nums 整数数组 nums ，其中元素已经按 升序 排列
     * @return 转换得到的 高度平衡 二叉搜索树。高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }

    private TreeNode dfs(int[] nums, int l, int r) {
        if (l > r)
            return null;

        int mid = l + (r - l) / 2;

        TreeNode root = new TreeNode(nums[mid]);

        root.left = dfs(nums, l, mid - 1);
        root.right = dfs(nums, mid + 1, r);

        return root;
    }
}
