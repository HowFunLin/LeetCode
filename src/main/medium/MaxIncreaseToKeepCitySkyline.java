package main.medium;

@SuppressWarnings("unused")
public class MaxIncreaseToKeepCitySkyline {
    /**
     * 807. 保持城市天际线
     *
     * @param grid grid[i][j]代表位于某处的建筑物的高度
     * @return 建筑物高度可以增加的最大总和。从新数组的所有四个方向（即顶部，底部，左侧和右侧）观看的“天际线”必须与原始数组的天际线相同
     */
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] column = new int[m], row = new int[n];

        for (int j = 0; j < n; j++) {
            int max = -1;

            for (int i = 0; i < m; i++) {
                int cur = grid[i][j];

                if (cur > max)
                    max = cur;
            }

            row[j] = max;
        }

        for (int i = 0; i < m; i++) {
            int max = -1;

            for (int j = 0; j < n; j++) {
                int cur = grid[i][j];

                if (cur > max)
                    max = cur;
            }

            column[i] = max;
        }

        int sum = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int max = Math.min(row[j], column[i]), cur = grid[i][j];

                if (cur < max)
                    sum += max - cur;
            }
        }

        return sum;
    }
}
