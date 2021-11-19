package main.medium;

@SuppressWarnings("unused")
public class IntegerReplacement {
    /**
     * 397. 整数替换
     *
     * @param n 正整数 n 。如果 n 是偶数，则用 n / 2替换 n ；如果 n 是奇数，则可以用 n + 1或n - 1替换 n
     * @return n 变为 1 所需的最小替换次数
     */
    public int integerReplacement(int n) {
        int ans = 0;
        while (n != 1) {
            if (n % 2 == 0) {
                ++ans;
                n /= 2;
            }
            // 基于余4后的值判断 (+1 | -1) / 2 操作后的奇数处理的贪心解
            // 分子 n +/- 数后的值必须被 4 整除
            else if (n % 4 == 1) {
                // -1 / 2 优于 +1 / 2
                ans += 2;
                n /= 2;
            } else {
                // n == 3 时直接操作两次成为 1 并结束循环
                if (n == 3) {
                    ans += 2;
                    n = 1;
                }
                // +1 / 2 优于 -1 / 2
                else {
                    ans += 2;
                    n = n / 2 + 1;
                }
            }
        }
        return ans;
    }
}
