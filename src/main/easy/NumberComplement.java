package main.easy;

@SuppressWarnings("unused")
public class NumberComplement {
    /**
     * 476. 数字的补数
     *
     * @param num 正 整数
     * @return 正整数的补数，补数是对该数的二进制表示取反
     */
    public int findComplement(int num) {
        if (num == 0)
            return 1;

        int res = 0;

        for (int i = 0; num > 0; i++) {
            int temp = num & 1;
            num >>= 1;

            temp = temp == 0 ? 1 : 0;

            if (temp == 1) {
                temp <<= i;
                res ^= temp;
            }
        }

        return res;
    }
}
