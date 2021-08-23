package easy;

public class GetMaximumInGeneratedArray {
    /**
     * <h3>1646. 获取生成数组中的最大值</h3>
     * <div>1. nums[0] = 0；</div>
     * <div>2. nums[1] = 1；</div>
     * <div>3. 当 2 <= 2 * i <= n 时，nums[2 * i] = nums[i]；</div>
     * <div>4. 当 2 <= 2 * i + 1 <= n 时，nums[2 * i + 1] = nums[i] + nums[i + 1]。</div>
     *
     * @param n 给定整数 n，应用规则生成一个长度为 n + 1 的数组 nums
     * @return 生成数组 nums 中的 最大 值
     */
    public int getMaximumGenerated(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;

        int[] nums = new int[n + 1];
        nums[0] = 0;
        int max = nums[1] = 1;

        for (int i = 2; i <= n; i++) {
            if (i % 2 == 0)
                nums[i] = nums[i / 2];
            else
                nums[i] = nums[i / 2] + nums[i / 2 + 1];

            max = Math.max(max, nums[i]);
        }

        return max;
    }
}
