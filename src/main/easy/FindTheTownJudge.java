package main.easy;

@SuppressWarnings("unused")
public class FindTheTownJudge {
    /**
     * 997. 找到小镇的法官
     *
     * @param n     小镇里有 n 个人，按从 1 到 n 的顺序编号
     * @param trust 数组 trust ，其中 trust[i] = [a, b] 表示编号为 a 的人信任编号为 b 的人
     * @return 如果小镇法官存在并且可以确定他的身份，返回该法官的编号；否则，返回 -1
     */
    public int findJudge(int n, int[][] trust) {
        int[] in = new int[n + 1];
        int[] out = new int[n + 1];

        for (int[] t : trust) {
            out[t[0]]++;
            in[t[1]]++;
        }

        for (int i = 1; i <= n; i++)
            if (out[i] == 0 && in[i] == n - 1)
                return i;

        return -1;
    }
}
