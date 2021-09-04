package main.medium;

import java.util.Arrays;

@SuppressWarnings("unused")
public class PointsOfNDices {
    /**
     * 剑指 Offer 60. n个骰子的点数
     *
     * @param n 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s
     * @return s的所有可能的值出现的概率，数组第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率
     */
    public double[] dicesProbability(int n) {
        double[] ans = new double[6];
        Arrays.fill(ans, 1d / 6d);

        // 若只有一个骰子，无需进入循环
        double[] temp; // 临时数组用于暂存新数组
        for (int i = 2; i <= n; i++) {
            temp = new double[i * 6 - i + 1];

            // 确定运算的边界值
            for (int j = 0; j <= temp.length - ans.length; j++) {
                int k = j;

                // 新数组的结果由上一个状态推出，临时索引 k 确定当前操作的下标
                for (double probability : ans) {
                    temp[k] += probability / 6d;
                    k++;
                }
            }

            ans = temp;
        }

        return ans;
    }
}
