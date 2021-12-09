package main.easy;

@SuppressWarnings("unused")
public class CountingBits {
    /**
     * 338. 比特位计数
     *
     * @param n 整数
     * @return 长度为 n + 1 的数组。存储 0 <= i <= n 中的每个 i 的二进制表示中 1 的个数
     */
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        int high = 0;

        for (int i = 1; i <= n; i++) {
            // 确定高位是否进位
            if ((i & (i - 1)) == 0)
                high = i;

            ans[i] = ans[i - high] + 1;
        }

        return ans;
    }
}
