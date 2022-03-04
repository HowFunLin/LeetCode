package main.medium;

@SuppressWarnings("unused")
public class FactorialTrailingZeroes {
    /**
     * 172. 阶乘后的零
     *
     * @param n 整数
     * @return n! 结果中尾随零的数量
     */
    public int trailingZeroes(int n) {
        int count = 0;

        while (n > 0) {
            // 仅有 2 和 5 相乘可得到尾随 0，2 的倍数比 5 的倍数更多，因此仅需计算 5 的倍数的个数
            count += n / 5;
            // 当为 5 的次方时，与对应次方 2 的倍数相乘会多得到一个 0，直接将 n / 5 即可
            n /= 5;
        }

        return count;
    }
}
