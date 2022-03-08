package main.medium;

@SuppressWarnings("unused")
public class PlatesBetweenCandles {
    /**
     * 2055. 蜡烛之间的盘子
     *
     * @param s       字符串 s ，它只包含字符 '*' 和 '|' ，其中 '*' 表示一个 盘子 ，'|' 表示一支 蜡烛
     * @param queries 二维整数数组 queries ，其中 queries[i] = [left, right] 表示 子字符串 s[left...right] （包含左右端点的字符）。对于每个查询，需要找到 子字符串中 在 两支蜡烛之间 的盘子的 数目 
     * @return 整数数组 answer ，其中 answer[i] 是第 i 个查询的答案
     */
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int n = s.length();
        int[] prefix = new int[n], nearestLeft = new int[n], nearestRight = new int[n];

        int left = -1, sum = 0;

        for (int right = 0; right < n; right++) { // 构造前缀和数组
            if (s.charAt(right) == '|') {
                if (left != -1)
                    sum += right - left - 1;

                left = right;
            }

            prefix[right] = sum;
        }

        int index = -1;

        for (int i = 0; i < s.length(); i++) { // 计算每个下标左边最近的蜡烛
            if (s.charAt(i) == '|')
                index = i;

            nearestLeft[i] = index;
        }

        index = n;

        for (int i = n - 1; i >= 0; i--) { // 计算每个下标右边最近的蜡烛
            if (s.charAt(i) == '|')
                index = i;

            nearestRight[i] = index;
        }

        n = queries.length;
        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            int r = queries[i][1], l = queries[i][0];

            if (nearestLeft[r] < nearestRight[l])
                answer[i] = 0;
            else
                answer[i] = prefix[nearestLeft[r]] - prefix[nearestRight[l]];
        }

        return answer;
    }
}
