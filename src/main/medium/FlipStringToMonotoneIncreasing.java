package main.medium;

@SuppressWarnings("unused")
public class FlipStringToMonotoneIncreasing {
    /**
     * 926. 将字符串翻转到单调递增
     *
     * @param s 二进制字符串
     * @return 使 s 单调递增的最小翻转次数。如果一个二进制字符串，是以一些 0（可能没有 0）后面跟着一些 1（也可能没有 1）的形式组成的，那么该字符串是 单调递增 的
     */
    public int minFlipsMonoIncr(String s) {
        int res = 0, ones = 0;

        for (char c : s.toCharArray()) {
            if (c == '0')
                res = Math.min(res + 1, ones); // 选择在已反转的二进制字符串后反转当前 0 和反转前面所有 1 之间的最优解
            else
                ones++;
        }

        return res;
    }
}
