package main.medium;

@SuppressWarnings("unused")
public class AdditiveNumber {
    /**
     * 306. 累加数
     *
     * @param num 只包含数字 '0'-'9' 的字符串
     * @return 字符串 num 是否是 累加数。累加数 是一个字符串，组成它的数字可以形成累加序列，一个有效的 累加序列 必须 至少 包含 3 个数，除了最开始的两个数以外，字符串中的其他数都等于它之前两个数相加的和
     */
    public boolean isAdditiveNumber(String num) {
        return dfs(num, 0, 0, 0L, 0L); // 35 位整数 定义为 long 防止溢出
    }

    /**
     * DFS 剪枝
     *
     * @param num    只包含数字 '0'-'9' 的字符串
     * @param index  当前遍历的字符串索引
     * @param count  当前已经得到的数字个数
     * @param prePre 上一个数字的上一个数字
     * @param pre    上一个数字
     * @return 字符串 num 是否是 累加数
     */
    private boolean dfs(String num, int index, int count, long prePre, long pre) {
        int n = num.length();

        if (index == n)
            return count > 2;

        long cur = 0;

        for (int i = index; i < n; i++) {
            char c = num.charAt(i);

            if (num.charAt(index) == '0' && i > index) // i > index 且 index 为 0 时，存在前置 0
                return false;

            cur = cur * 10 + c - '0';

            if (count >= 2) {
                long sum = prePre + pre;

                if (cur > sum) // 当前数已经大于前两个数之和
                    return false;
                else if (cur < sum) // 当前数小于前两个数之和，循环继续
                    continue;
            }

            // 满足当前数等于前两个数 或者 暂未找到两个数，进入下一层
            // 当前数和前一个数作为下一个数的前两个数，从 i + 1 索引处继续寻找
            if (dfs(num, i + 1, count + 1, pre, cur))
                return true;
        }

        return false;
    }
}
