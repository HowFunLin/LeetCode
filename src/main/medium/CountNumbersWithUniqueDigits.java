package main.medium;

@SuppressWarnings("unused")
public class CountNumbersWithUniqueDigits {
    /**
     * 357. 统计各位数字都不同的数字个数
     *
     * @return 各位数字都不同的数字 x 的个数，其中 0 <= x < 10^n
     */
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0)
            return 1;

        if (n == 1)
            return 10;

        int res = 10, cur = 9;

        // 最高位只能选择 1 ~ 9，第二位选择除第一位以外的 0 ~ 9 之间的数，以此类推
        for (int i = 0; i < n - 1; i++) {
            cur *= 9 - i;
            res += cur;
        }

        return res;
    }
}
