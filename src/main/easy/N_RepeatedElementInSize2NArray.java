package main.easy;

@SuppressWarnings("unused")
public class N_RepeatedElementInSize2NArray {
    /**
     * 961. 在长度 2N 的数组中找出重复 N 次的元素
     *
     * @param nums nums.length == 2 * n，包含 n + 1 个 不同的 元素，恰有一个元素重复 n 次
     * @return 重复了 n 次的那个元素
     */
    public int repeatedNTimes(int[] nums) {
        int first = nums[0], cur = nums[1], count = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == first)
                return first;

            // 摩尔投票（若第一个数不为重复数）
            if (nums[i] == cur)
                count++;
            else {
                if (--count < 0) {
                    cur = nums[i];
                    count = 1;
                }
            }

            if (count > 1)
                return cur;
        }

        return cur;
    }
}
