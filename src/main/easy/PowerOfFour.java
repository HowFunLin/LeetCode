package main.easy;

@SuppressWarnings("unused")
public class PowerOfFour {
    /**
     * 342. 4的幂
     *
     * @param n 整数
     * @return n 是否是 4 的幂次方
     */
    public boolean isPowerOfFour(int n) {
        while (n > 1) {
            if ((n & 3) != 0)
                return false;

            n >>= 2;
        }

        return n == 1;
    }
}
