package lcci.easy;

@SuppressWarnings("unused")
public class Exchange {
    /**
     * 面试题 05.07. 配对交换
     *
     * @param num 整数
     * @return 配对交换的结果。交换某个整数的奇数位和偶数位，位0与位1交换，位2与位3交换，以此类推
     */
    public int exchangeBits(int num) {
        int res = 0, n = 3;

        for (int i = 0; num != 0; i += 2) {
            int x = num & n;

            if (x == 2)
                x = 1;
            else if (x == 1)
                x = 2;

            res |= x << i;

            num >>= 2;
        }

        return res;
    }
}
