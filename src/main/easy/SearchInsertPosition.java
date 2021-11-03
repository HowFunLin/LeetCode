package main.easy;

@SuppressWarnings("unused")
public class SearchInsertPosition {
    /**
     * 35. 搜索插入位置
     *
     * @param nums   排序数组
     * @param target 目标值
     * @return 数组中目标值索引；如果目标值不存在于数组中，返回它将会被按顺序插入的位置（时间复杂度为 O(log n)）
     */
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        if (target < nums[left])
            return 0;

        if (target > nums[right])
            return nums.length;

        while (left < right) {
            int mid = (right - left) / 2 + left;

            if (nums[mid] < target)
                left = mid + 1;
            else
                right = mid;
        }

        return right;
    }
}
