package main.easy;

import java.util.Arrays;

@SuppressWarnings("unused")
public class AssignCookies {
    /**
     * 455. 分发饼干
     *
     * @param g 每个孩子 i，都有一个胃口值 g[i]，这是能让孩子们满足胃口的饼干的最小尺寸
     * @param s 每块饼干 j，都有一个尺寸 s[j]
     * @return 最大能满足孩子的数量。如果 s[j] >= g[i]，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int gn = g.length, sn = s.length, res = 0;

        // 双指针
        for (int i = 0, j = 0; i < gn && j < sn; i++, j++) {
            while (j < sn && s[j] < g[i])
                j++;

            if (j < sn)
                res++;
        }

        return res;
    }
}
