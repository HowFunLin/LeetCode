package main.easy;

@SuppressWarnings("unused")
public class UglyNumber {
    /**
     * 263. 丑数
     *
     * @param n 整数
     * @return n 是否为 丑数 。丑数 就是只包含质因数 2、3 和/或 5 的正整数
     */
    public boolean isUgly(int n) {
        if (n <= 0)
            return false;

        int[] factors = {2, 3, 5};

        // 若 n 为丑数，可分解为 2 ^ a * 3 ^ b * 5 ^ c 的形式
        for (int factor : factors)
            while (n % factor == 0)
                n /= factor;

        return n == 1;
    }
}
