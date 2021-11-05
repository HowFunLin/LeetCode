package struct;

public class Reverse {
    /**
     * 反转数组
     *
     * @param nums  数组
     * @param left  起始下标
     * @param right 结束下标
     */
    public static void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            left++;
            right--;
        }
    }
}
