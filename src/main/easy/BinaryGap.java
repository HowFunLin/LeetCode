package main.easy;

@SuppressWarnings("unused")
public class BinaryGap {
    /**
     * 868. 二进制间距
     *
     * @return n 的二进制表示中两个 相邻 1 之间的 最长距离 。如果不存在两个相邻的 1，返回 0
     */
    public int binaryGap(int n) {
        int start = -1, max = 0;

        for (int i = 0; n > 0; i++) {
            if ((n & 1) == 1) {
                if (start != -1)
                    max = Math.max(i - start, max);

                start = i;
            }

            n >>= 1;
        }

        return max;
    }
}
