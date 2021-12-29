package main.easy;

@SuppressWarnings("unused")
public class LongestPalindrome {
    /**
     * 409. 最长回文串
     *
     * @param s 包含大写字母和小写字母的字符串
     * @return 通过这些字母构造成的最长的回文串
     */
    public int longestPalindrome(String s) {
        int[] times = new int[58];
        int n = s.length();

        for (int i = 0; i < n; i++)
            times[s.charAt(i) - 'A']++;

        int res = 0;

        for (int time : times) {
            res += time / 2 * 2; // 利用 time 对应的字符的偶数部分

            if (time % 2 == 1 && res % 2 == 0) // 回文允许存在一个奇数个的字符
                res++;
        }

        return res;
    }
}
