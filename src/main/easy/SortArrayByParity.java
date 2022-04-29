package main.easy;

@SuppressWarnings("unused")
public class SortArrayByParity {
    /**
     * 905. 按奇偶排序数组
     *
     * @return 满足将 nums 中的的所有偶数元素移动到数组的前面，后跟所有奇数元素的 任一数组
     */
    public int[] sortArrayByParity(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            while (left < right && ((nums[left] & 1) == 0))
                left++;

            while (left < right && ((nums[right] & 1) == 1))
                right--;

            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }

        return nums;
    }
}
