package jianzhi.medium;

@SuppressWarnings("unused")
public class SingleNumberII {
    /**
     * 剑指 Offer II 004. 只出现一次的数字
     *
     * @param nums 整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次
     * @return 只出现了一次的元素
     */
    public int singleNumber(int[] nums) {
        int[] counts = new int[32];

        for (int num : nums) {
            for (int i = 31; i >= 0; i--) {
                counts[i] += num & 1; // 仍为类似哈希表的原理
                num >>= 1;
            }
        }

        int res = 0;

        for (int count : counts) {
            res <<= 1;
            res |= count % 3; // 1 的个数不为 3 的倍数即为出现一次的数字的位数
        }

        return res;
    }
}
