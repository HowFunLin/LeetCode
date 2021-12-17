package main.medium;

@SuppressWarnings("unused")
public class ProductOfArrayExceptSelf {
    /**
     * 238. 除自身以外数组的乘积
     *
     * @param nums 长度为 n 的整数数组 nums，其中 n > 1
     * @return 输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积
     */
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        int left = 1, right = 1;

        for (int i = 0; i < n; i++) {
            res[i] = left;
            left *= nums[i];
        }

        for (int i = n - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }

        return res;
    }
}
