package main.medium;

@SuppressWarnings("unused")
public class FindTheWinnerOfTheCircularGame {
    /**
     * 1823. 找出游戏的获胜者
     *
     * @param n 共有 n 名小伙伴一起做游戏，小伙伴们围成一圈，按 顺时针顺序 从 1 到 n 编号
     * @param k 沿着顺时针方向数 k 名小伙伴，计数时需要 包含 起始时的那位小伙伴。逐个绕圈进行计数，一些小伙伴可能会被数过不止一次。数到的最后一名小伙伴需要离开圈子，并视作输掉游戏。从刚刚输掉的小伙伴的 顺时针下一位 小伙伴 继续计数，圈子中最后一名小伙伴赢得游戏
     * @return 游戏的获胜者
     */
    public int findTheWinner(int n, int k) {
//        int res = 1; // 当只有一个参赛者时，结果为自己
//
//        // 每多一人胜者为原胜者 + k
//        for (int i = 2; i <= n; i++)
//            res = (res + k) % i == 0 ? i : (res + k) % i;
//
//        return res;

        if (n == 1)
            return 1;

        // 例如第一种情况，第一轮编号 k 输掉游戏，第二轮起始值为 k + 1 => 1，因此节点的编号变化为 findTheWinner(n - 1, k) + k
        // 需要对计算出的编号进行求余，且由于不存在 0，因此需要 -1 求余再 +1
        return (findTheWinner(n - 1, k) + k - 1) % n + 1;
    }
}
