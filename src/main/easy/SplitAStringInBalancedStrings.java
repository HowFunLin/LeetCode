package main.easy;

@SuppressWarnings("unused")
public class SplitAStringInBalancedStrings {
    /**
     * 1221. 分割平衡字符串
     *
     * @param s 平衡字符串 s ， 平衡字符串 中，'L' 和 'R' 字符的数量是相同的
     * @return 可以通过分割得到的平衡字符串的 最大数量
     */
    public int balancedStringSplit(String s) {
        int count = 0, sum = 0;

        for (int i = 0; i < s.length(); i++) {
            sum = s.charAt(i) == 'L' ? sum + 1 : sum - 1;

            if (sum == 0)
                count++;
        }

        return count;
    }
}
