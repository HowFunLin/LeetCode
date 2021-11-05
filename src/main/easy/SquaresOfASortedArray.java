package main.easy;

@SuppressWarnings("unused")
public class SquaresOfASortedArray {
    /**
     * 977. 有序数组的平方
     *
     * @param nums 非递减顺序 排序的整数数组 nums
     * @return 按 非递减顺序 排序的 每个数字的平方 组成的新数组
     */
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1, index = n - 1;
        int[] res = new int[n];

        while (left <= right) {
            int l = Math.abs(nums[left]), r = Math.abs(nums[right]);

            if (l > r) {
                res[index--] = l * l;
                left++;
            } else {
                res[index--] = r * r;
                right--;
            }
        }

        return res;
    }
}
