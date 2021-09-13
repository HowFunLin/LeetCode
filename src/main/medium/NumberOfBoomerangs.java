package main.medium;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
public class NumberOfBoomerangs {
    /**
     * 447. 回旋镖的数量
     *
     * @param points 平面上 n 对 互不相同 的点 points ，其中 points[i] = [x, y]
     * @return 平面上所有回旋镖的数量。回旋镖 是由点 (i, j, k) 表示的元组 ，其中 i 和 j 之间的距离和 i 和 k 之间的距离相等（需要考虑元组的顺序）
     */
    public int numberOfBoomerangs(int[][] points) {
        int res = 0;

        Map<Integer, Integer> map = new HashMap<>();
        for (int[] p : points) {
            for (int[] q : points) {
                int dist = (p[0] - q[0]) * (q[0] - p[0]) + (p[1] - q[1]) * (q[1] - p[1]);
                map.put(dist, map.getOrDefault(dist, 0) + 1);
            }

            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int nums = entry.getValue();
                res += nums * (nums - 1);
            }

            map.clear();
        }

        return res;
    }
}
