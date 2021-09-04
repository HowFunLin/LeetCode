package main.hard;

import java.util.HashMap;

public class MaxPointsOnALine {
    public int maxPoints(int[][] points) {
        int res = 1;

        for (int i = 0; i < points.length; i++) {
            // 每次确定一个新起点要使用新的计数
            HashMap<String, Integer> map = new HashMap<>();
            int x1 = points[i][0], y1 = points[i][1];

            int max = 0;
            for (int j = i + 1; j < points.length; j++) {
                int x2 = points[j][0], y2 = points[j][1];
                int x = x2 - x1, y = y2 - y1;
                int k = gcd(x, y);

                // 避免精度丢失造成的问题
                String key = x / k + "_" + y / k;
                map.put(key, map.getOrDefault(key, 0) + 1);

                max = Math.max(max, map.get(key));
            }

            res = Math.max(res, max + 1);
        }

        return res;
    }

    // 欧几里得算法
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
