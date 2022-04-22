package main.medium;

@SuppressWarnings("unused")
public class RotateFunction {
    /**
     * 396. 旋转函数
     *
     * @param nums 长度为 n 的整数数组 nums 的 旋转函数 F 为： F(k) = 0 * nums[0] + 1 * nums[1] + ... + (n - 1) * nums[n - 1]
     * @return F(0), F(1), ..., F(n-1)中的最大值
     */
    public int maxRotateFunction(int[] nums) {
        int f = 0, n = nums.length, sum = 0;

        for (int i = 0; i < n; i++) {
            f += i * nums[i];
            sum += nums[i]; // 遍历的同时计算数组总和，Arrays 工具类耗时过长
        }

        int max = f;

        for (int i = 1; i < n; i++) {
            f += sum - n * nums[n - i];
            max = Math.max(f, max);
        }

        return max;
    }
}
