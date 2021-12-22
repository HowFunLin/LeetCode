package main.medium;

@SuppressWarnings("unused")
public class RepeatedStringMatch {
    /**
     * 686. 重复叠加字符串匹配
     *
     * @param a 字符串
     * @param b 字符串
     * @return 使得字符串 b 成为叠加后的字符串 a 的子串的重复叠加的最小次数。如果不存在则返回 -1
     */
    public int repeatedStringMatch(String a, String b) {
        StringBuilder builder = new StringBuilder();
        int ans = 0;

        while (builder.length() < b.length()) {
            builder.append(a);
            ans++;
        }

        builder.append(a); // 防止 a 的长度的倍数恰好等于 b 且 b 恰好位于 a 的中间（多出一个 a 不影响求出的索引位置）

        int i = indexOf(builder.toString(), b);

        if (i == -1)
            return -1;

        return i + b.length() > a.length() * ans ? ans + 1 : ans;
    }

    /**
     * KMP 算法
     *
     * @param s 原串
     * @param p 匹配串
     * @return 匹配串在原串的起始下标
     */
    private int indexOf(String s, String p) {
        if (p.isEmpty())
            return 0;

        int n = s.length(), m = p.length();

        // 哨兵
        s = " " + s;
        p = " " + p;

        char[] sc = s.toCharArray(), pc = p.toCharArray();

        int[] next = new int[m + 1];

        // 构建 next 数组
        for (int i = 2, j = 0; i <= m; i++) {
            while (j > 0 && pc[i] != pc[j + 1])
                j = next[j];

            if (pc[i] == pc[j + 1])
                j++;

            next[i] = j;
        }

        // 对字符串 s 进行匹配
        for (int i = 1, j = 0; i <= n; i++) {
            while (j > 0 && sc[i] != pc[j + 1])
                j = next[j];

            if (sc[i] == pc[j + 1])
                j++;

            if (j == m)
                return i - m;
        }

        return -1;
    }
}
