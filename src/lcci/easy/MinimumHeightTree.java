package lcci.easy;

import struct.TreeNode;

@SuppressWarnings("unused")
public class MinimumHeightTree {
    /**
     * 面试题 04.02. 最小高度树
     *
     * @param nums 有序整数数组，元素各不相同且按升序排列
     * @return 高度最小的二叉搜索树
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return createTree(nums, 0, nums.length - 1);
    }

    private TreeNode createTree(int[] nums, int start, int end) {
        if (end < start)
            return null;

        int mid = start + (end - start) / 2;

        TreeNode node = new TreeNode(nums[mid]);

        node.left = createTree(nums, start, mid - 1);
        node.right = createTree(nums, mid + 1, end);

        return node;
    }
}
