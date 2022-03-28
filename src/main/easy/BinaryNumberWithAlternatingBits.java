package main.easy;

@SuppressWarnings("unused")
public class BinaryNumberWithAlternatingBits {
    /**
     * 693. 交替位二进制数
     *
     * @param n 正整数
     * @return n 的二进制表示是否总是 0、1 交替出现
     */
    public boolean hasAlternatingBits(int n) {
        int temp = n & 1;

        while (n > 0) {
            if ((n & 1) != temp)
                return false;

            n >>= 1;
            temp ^= 1;
        }

        return true;
    }
}
