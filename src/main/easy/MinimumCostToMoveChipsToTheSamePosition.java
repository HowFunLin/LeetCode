package main.easy;

@SuppressWarnings("unused")
public class MinimumCostToMoveChipsToTheSamePosition {
    /**
     * 1217. 玩筹码
     *
     * @param position 第 i 个筹码的位置是 position[i]。position[i] +- 2 代价为 0，+- 1 代价为 1
     * @return 将所有筹码移动到同一位置上所需要的 最小代价
     */
    public int minCostToMoveChips(int[] position) {
        int odd = 0, even = 0;

        for (int p : position) {
            if ((p & 1) == 1)
                odd++;
            else
                even++;
        }

        return Math.min(odd, even); // 使所有元素奇偶性一致的最小花费
    }
}
