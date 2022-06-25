package jianzhi.medium;

@SuppressWarnings("unused")
public class PaintingHouses {
    /**
     * 剑指 Offer II 091. 粉刷房子
     *
     * @param costs costs[0][0] 表示第 0 号房子粉刷成红色的成本花费；costs[1][2] 表示第 1 号房子粉刷成绿色的花费，以此类推
     * @return 粉刷完所有房子最少的花费成本。相邻的两个房子颜色不能相同。
     */
    public int minCost(int[][] costs) {
        int n = costs.length - 1;

        // 当前颜色为红、蓝、绿三种情况都需要考虑状态转移
        for (int i = 1; i <= n; i++) {
            costs[i][0] += Math.min(costs[i - 1][1], costs[i - 1][2]);
            costs[i][1] += Math.min(costs[i - 1][0], costs[i - 1][2]);
            costs[i][2] += Math.min(costs[i - 1][0], costs[i - 1][1]);
        }

        return Math.min(costs[n][0], Math.min(costs[n][1], costs[n][2]));
    }
}
