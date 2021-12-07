package main.medium;

@SuppressWarnings("unused")
public class IntegerBreak {
    /**
     * 343. 整数拆分
     *
     * @param n 正整数
     * @return 将 n 拆分为至少两个正整数的和，可以获得的最大乘积
     */
    public int integerBreak(int n) {
        if (n <= 3)
            return n - 1;

        // n 大于 4 时，拆为 2 和 3 得到的乘积更大，尽可能拆为更多的 3
        int m = n / 3, remainder = n % 3;

        if (remainder == 0)
            return (int) Math.pow(3, m);
        else if (remainder == 1) // 余数为 1 时，拆分为 2 * 2 收益大于 1 * 3
            return (int) Math.pow(3, m - 1) * 4;
        else
            return (int) Math.pow(3, m) * 2;
    }
}
