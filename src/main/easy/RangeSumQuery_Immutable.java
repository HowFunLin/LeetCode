package main.easy;

@SuppressWarnings("unused")
public class RangeSumQuery_Immutable {
    /**
     * 303. 区域和检索 - 数组不可变
     */
    class NumArray {
        private int[] prefix; // 构建前缀和数组

        /**
         * 使用数组 nums 初始化对象
         */
        public NumArray(int[] nums) {
            int sum = 0, n = nums.length;
            prefix = new int[n];

            for (int i = 0; i < n; i++) {
                sum += nums[i];

                prefix[i] = sum;
            }
        }

        /**
         * @return 数组 nums 中索引 left 和 right 之间的元素的 总和 ，包含 left 和 right 两点
         */
        public int sumRange(int left, int right) {
            return prefix[right] - (left == 0 ? 0 : prefix[left - 1]);
        }
    }
}
