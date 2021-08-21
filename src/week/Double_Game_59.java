package week;

/**
 * 第 59 场双周赛
 */
@SuppressWarnings("unused")
public class Double_Game_59 {
    /**
     * <h3>5834. 使用特殊打字机键入单词的最少时间</h3>
     * 有一个特殊打字机，它由一个 圆盘 和一个 指针 组成， 圆盘上标有小写英文字母 'a' 到 'z'。
     * 只有 当指针指向某个字母时，它才能被键入。指针 初始时 指向字符 'a' 。
     * 每一秒钟可以执行以下操作之一：
     * 将指针 顺时针 或者 逆时针 移动一个字符；
     * 键入指针 当前 指向的字符。
     *
     * @param word 字符串
     * @return 键入 word 所表示单词的 最少 秒数
     */
    public int minTimeToType(String word) {
        char[] words = word.toCharArray();
        int total = 0;
        char cur = 'a';

        for (char c : words) {
            int a = Math.abs(cur < c ? cur + 26 - c : c + 26 - cur);
            int b = Math.abs(cur - c);
            total += Math.min(a, b);
            cur = c;
        }

        return total + words.length;
    }

    /**
     * <h3>5835. 最大方阵和</h3>
     * 可以执行以下操作 任意次 ：
     * 选择 matrix 中 相邻 两个元素，并将它们都 乘以 -1 。
     *
     * @param matrix n x n 的整数方阵 matrix
     * @return 方阵的 最大 和
     */
    public long maxMatrixSum(int[][] matrix) {
        int min = Integer.MAX_VALUE;
        long ans = 0;
        int lower = 0, zeroes = 0;

        for (int[] array : matrix) {
            for (int i = 0; i < matrix[0].length; i++) {
                if (array[i] < 0)
                    lower++;

                if (array[i] == 0)
                    zeroes++;

                int cur = Math.abs(array[i]);

                if (cur < min)
                    min = cur;

                ans += cur;
            }
        }

        if (lower % 2 != 0 && zeroes == 0)
            return ans - 2 * min;

        return ans;
    }
}
