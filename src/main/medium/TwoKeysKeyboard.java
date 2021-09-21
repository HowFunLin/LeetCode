package main.medium;

@SuppressWarnings("unused")
public class TwoKeysKeyboard {
    /**
     * <h3>650. 只有两个键的键盘</h3>
     * 最初记事本上只有一个字符 'A' 。你每次可以对这个记事本进行两种操作：
     * Copy All（复制全部）：复制这个记事本中的所有字符（不允许仅复制部分字符）；
     * Paste（粘贴）：粘贴 上一次 复制的字符
     *
     * @param n 数字 n ，需要使用最少的操作次数，在记事本上输出 恰好 n 个 'A'
     * @return 能够打印出 n 个 'A' 的最少操作次数
     */
    public int minSteps(int n) {
        int opts = 0;

        // 分解质因数，每个质因数 m 对应 1 次复制全部和 m - 1 次粘贴
        for (int i = 2; i * i <= n; i++) {
            while (n % i == 0) {
                n /= i;
                opts += i;
            }
        }

        // 所有质因数之和对应最少操作次数
        if (n > 1)
            opts += n;

        return opts;
    }
}
