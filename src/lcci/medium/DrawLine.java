package lcci.medium;

@SuppressWarnings("unused")
public class DrawLine {
    /**
     * 面试题 05.08. 绘制直线
     *
     * @param length 数组长度，屏幕高度 = length / (w / 32)
     * @param w      屏幕宽度 bit
     * @param x1     直线开始位置 bit
     * @param x2     直线结束位置 bit
     * @param y      直线所在行数
     * @return 绘制后的数组
     */
    public int[] drawLine(int length, int w, int x1, int x2, int y) {
        int[] res = new int[length];
        int start = (w * y + x1) / 32, end = (w * y + x2) / 32;

        for (int i = start; i <= end; i++)
            res[i] = -1;

        res[start] >>>= x1 % 32; // >>>运算忽略操作数的正负，仅移位
        res[end] = res[end] & (Integer.MIN_VALUE >> x2 % 32); // >>运算操作数为负，高位补1

        return res;
    }
}
