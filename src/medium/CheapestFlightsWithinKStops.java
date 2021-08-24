package medium;

import java.util.Arrays;

@SuppressWarnings("unused")
public class CheapestFlightsWithinKStops {
    /**
     * 787. K 站中转内最便宜的航班
     *
     * @param n       有 n 个城市通过一些航班连接
     * @param flights 航班数组 flights[i] = [from, to, price] ，表示该航班都从城市 from 开始，以价格 price 抵达城市 to
     * @param src     出发城市 src
     * @param dst     目的地 dst
     * @param k       最多经过 k 站中转
     * @return 从 src 到 dst 的 最便宜 的 价格
     */
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        final int INF = 10000 * 101 + 1;

        // costs[飞行次数][终点] 最多飞行 k + 1 次，存在飞行 0 次的情况
        int[][] costs = new int[k + 2][n];

        for (int[] cost : costs)
            Arrays.fill(cost, INF);

        costs[0][src] = 0;

        for (int times = 1; times <= k + 1; times++) {
            for (int[] flight : flights) {
                int from = flight[0], to = flight[1], price = flight[2];

                costs[times][to] = Math.min(costs[times][to], costs[times - 1][from] + price);
            }
        }

        int ans = INF;

        for (int times = 0; times <= k + 1; times++)
            ans = Math.min(ans, costs[times][dst]);

        return ans == INF ? -1 : ans;
    }
}
