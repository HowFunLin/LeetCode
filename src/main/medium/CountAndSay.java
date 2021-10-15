package main.medium;

@SuppressWarnings("unused")
public class CountAndSay {
    /**
     * <h3>38. 外观数列</h3>
     * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述；
     * 要 描述 一个数字字符串，首先要将字符串分割为 最小 数量的组，每个组都由连续的最多 相同字符 组成；
     * 然后对于每个组，先描述字符的数量，然后描述字符，形成一个描述组；
     * 要将描述转换为数字字符串，先将每组中的字符数量用数字替换，再将所有描述组连接起来；
     * countAndSay(n) 是对 countAndSay(n-1) 的描述，然后转换成另一个数字字符串
     *
     * @param n 正整数 n
     * @return 外观数列的第 n 项。
     */
    private String countAndSay(int n) {
        if (n == 1)
            return "1";

        String res = countAndSay(n - 1);

        StringBuilder builder = new StringBuilder();

        char[] cs = res.toCharArray();
        char temp = cs[0];
        int times = 0;

        for (char c : cs) {
            if (c == temp)
                times++;
            else {
                builder.append(times).append(temp);
                temp = c;
                times = 1;
            }
        }

        builder.append(times).append(temp);

        return builder.toString();
    }
}
