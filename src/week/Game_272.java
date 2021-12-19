package week;

@SuppressWarnings("unused")
public class Game_272 {
    /**
     * 5956. 找出数组中的第一个回文字符串
     *
     * @param words 字符串数组。回文字符串 的定义为：如果一个字符串正着读和反着读一样，那么该字符串就是一个 回文字符串
     * @return 数组中的 第一个回文字符串 。如果不存在满足要求的字符串，返回一个 空字符串 ""
     */
    public String firstPalindrome(String[] words) {
        traversal:
        for (String word : words) {
            int left = 0, right = word.length() - 1;

            while (left < right) {
                if (word.charAt(left) != word.charAt(right))
                    continue traversal;

                left++;
                right--;
            }

            return word;
        }

        return "";
    }

    /**
     * 5957. 向字符串添加空格
     *
     * @param s      字符串
     * @param spaces 原字符串中需要添加空格的下标。每个空格都应该插入到给定索引处的字符值 之前
     * @return 添加空格后的字符串
     */
    public String addSpaces(String s, int[] spaces) {
        int n = s.length(), sn = spaces.length;
        char[] res = new char[n + sn];

        int resIndex = 0, spaceIndex = 0;

        for (int i = 0; i < n; i++) {
            // space 尚未遍历结束且 res 下标达到 空格 应该插入的位置则插入空格
            while (spaceIndex < sn && resIndex == (spaces[spaceIndex] + spaceIndex)) {
                res[resIndex++] = ' ';
                spaceIndex++;
            }

            res[resIndex++] = s.charAt(i);
        }

        return new String(res);
    }

    /**
     * 5958. 股票平滑下跌阶段的数目
     *
     * @param prices 股票的历史每日股价，其中 prices[i] 是这支股票第 i 天的价格
     * @return 平滑下降阶段 的数目。 平滑下降的阶段 定义为：对于 连续一天或者多天 ，每日股价都比 前一日股价恰好少 1 ，这个阶段第一天的股价没有限制
     */
    public long getDescentPeriods(int[] prices) {
        long cur = 1;
        int index = 0; // 记录当前平滑下降阶段的起始索引

        // DP思想，一维DP转化为常量
        for (int i = 1; i < prices.length; i++) {
            cur += 1; // 无论是否属于上一个平滑阶段结果都会 + 1

            if (prices[i - 1] - prices[i] == 1)
                cur += i - index;
            else
                index = i; // 不属于上一个平滑阶段则更新索引
        }

        return cur;
    }
}
