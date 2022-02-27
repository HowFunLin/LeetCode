package week;

@SuppressWarnings("unused")
public class Game_282 {
    /**
     * 6008. 统计包含给定前缀的字符串
     *
     * @param words 字符串数组
     * @param pref  前缀字符串
     * @return words 中以 pref 作为 前缀 的字符串的数目
     */
    public int prefixCount(String[] words, String pref) {
        int res = 0;

        traversal:
        for (String word : words) {
            for (int i = 0; i < pref.length(); i++) {
                if (i >= word.length() || word.charAt(i) != pref.charAt(i))
                    continue traversal;
            }

            res++;
        }

        return res;
    }

    /**
     * 6009. 使两字符串互为字母异位词的最少步骤数
     *
     * @param s 字符串
     * @param t 字符串
     * @return 使 s 和 t 互为 字母异位词 所需的最少步骤数。在一步操作中，你可以给 s 或者 t 追加 任一字符
     */
    public int minSteps(String s, String t) {
        int[] st = new int[128], tt = new int[128];

        for (int i = 0; i < s.length(); i++) {
            st[s.charAt(i)]++;
        }

        for (int i = 0; i < t.length(); i++) {
            tt[t.charAt(i)]++;
        }

        int res = 0;

        for (int i = 0; i < 128; i++) {
            res += Math.abs(st[i] - tt[i]);
        }

        return res;
    }
}
