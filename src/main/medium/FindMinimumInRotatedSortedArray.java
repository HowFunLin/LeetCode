package main.medium;

@SuppressWarnings("unused")
public class FindMinimumInRotatedSortedArray {
    /**
     * 153. 寻找旋转排序数组中的最小值
     *
     * @param nums 元素值 互不相同 的数组 nums ，由升序排列的原数组进行多次旋转得到，例如数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]]
     * @return 数组中的 最小元素
     */
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = (right - left) / 2 + left;

            // 中点大于右边的值说明最小值仍在右边
            if (nums[mid] > nums[right])
                left = mid + 1;
            else
                right = mid;
        }

        return nums[left];
    }
}
