package jianzhi.easy;

@SuppressWarnings("unused")
public class CountingBits {
    /**
     * 剑指 Offer II 003. 前 n 个数字二进制中 1 的个数
     *
     * @return 0 到 n 之间的每个数字的二进制表示中 1 的个数的数组
     */
    public int[] countBits(int n) {
        int[] res = new int[n + 1];

        for (int i = 0; i <= n; i++)
            // 当 i 为奇数时：res[i] = res[i - 1] + 1
            // 当 i 为偶数时：res[i] = res[i / 2]
            // 得出如下式子：
            res[i] = res[i >> 1] + (i & 1);

        return res;
    }
}
