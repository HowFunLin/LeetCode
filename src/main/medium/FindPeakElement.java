package main.medium;

@SuppressWarnings("unused")
public class FindPeakElement {
    /**
     * 162. 寻找峰值
     *
     * @param nums 整数数组 nums，假设 nums[-1] = nums[n] = -∞
     * @return 找到峰值元素并返回其索引；峰值元素是指其值严格大于左右相邻值的元素，数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可
     */
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = (right - left) / 2 + left;

            // 当前中点可能为峰值，或者左边一定存在峰值
            if (nums[mid] > nums[mid + 1])
                right = mid;
                // 否则右边一定存在峰值
            else
                left = mid + 1;
        }

        return right;
    }
}
