package main.easy;

@SuppressWarnings("unused")
public class MaximumScoreAfterSplittingAString {
    /**
     * 1422. 分割字符串的最大得分
     *
     * @param s 由若干 0 和 1 组成的字符串
     * @return 将字符串分割成两个 非空 子字符串所能获得的最大得分。 得分 为 左 子字符串中 0 的数量加上 右 子字符串中 1 的数量
     */
    public int maxScore(String s) {
        int n = s.length(), count = 0;
        char[] cs = s.toCharArray();
        int[] ones = new int[n]; // ones[i] 表示从 i 开始的右字符串中 1 的数量

        for (int i = n - 1; i > 0; i--) {
            if (cs[i] == '1')
                count++;

            ones[i] = count;
        }

        int res = 0;
        count = 0;

        for (int i = 0; i < n - 1; i++) {
            if (cs[i] == '0')
                count++;

            int score = count + ones[i + 1];

            if (score > res)
                res = score;
        }

        return res;
    }
}
