package main.easy;

@SuppressWarnings("unused")
public class HammingDistance {
    /**
     * 461. 汉明距离
     *
     * @param x 整数
     * @param y 整数
     * @return 两个整数之间的汉明距离。两个整数之间的 汉明距离 指的是这两个数字对应二进制位不同的位置的数目
     */
    public int hammingDistance(int x, int y) {
        x = x ^ y;
        y = 0;

        while (x != 0) {
            if ((x & 1) == 1)
                y++;

            x >>= 1;
        }

        return y;
    }
}
