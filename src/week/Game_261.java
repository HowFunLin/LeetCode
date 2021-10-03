package week;

import java.util.Arrays;

/**
 * 第 261 场周赛
 */
@SuppressWarnings("unused")
public class Game_261 {
    /**
     * 5890. 转换字符串的最少操作次数
     *
     * @param s 字符串 s ，由 n 个字符组成，每个字符不是 'X' 就是 'O'
     * @return 将 s 中所有字符均转换为 'O' 需要执行的 最少 操作次数。一次 操作 定义为从 s 中选出 三个连续字符 并将选中的每个字符都转换为 'O' 。如果字符已经是 'O' ，只需要保持 不变
     */
    public int minimumMoves(String s) {
        int times = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'X') {
                times++;
                i += 2;
            }
        }

        return times;
    }

    /**
     * <h3>5891. 找出缺失的观测数据</h3>
     * 现有一份 n + m 次投掷单个 六面 骰子的观测数据，骰子的每个面从 1 到 6 编号
     *
     * @param rolls 剩余的 m 次投掷的数据，长度为 m 的整数数组 rolls ，其中 rolls[i] 是第 i 次观测的值
     * @param mean  n + m 次投掷的 平均值
     * @param n     观测数据中缺失了 n 份
     * @return 长度为 n 的数组，包含所有缺失的观测数据。如果存在多组符合要求的答案，只需要返回其中任意一组即可。如果不存在答案，返回一个空数组
     */
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;

        int sumAll = mean * (m + n);
        int sumRolls = Arrays.stream(rolls).sum();

        int missingAll = sumAll - sumRolls;
        int missing = missingAll / n;

        int remain = missingAll % n;

        if ((missing > 6) || (missing == 6 && remain > 0) || missing < 1)
            return new int[0];

        int[] res = new int[n];

        Arrays.fill(res, missing);

        for (int i = 0; i < remain; i++)
            res[i] += 1;

        return res;
    }
}
