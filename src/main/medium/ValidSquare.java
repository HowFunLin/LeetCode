package main.medium;

import java.util.Arrays;

@SuppressWarnings("unused")
public class ValidSquare {
    /**
     * 593. 有效的正方形
     *
     * @return 四个点能否构成一个正方形
     */
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        if (p1[0] == p2[0] && p1[1] == p2[1])
            return false; // 排除四个点都重合的情况，两个或三个点重合

        int[] distances = new int[6];

        distances[0] = calculateDistance(p1, p2);
        distances[1] = calculateDistance(p1, p3);
        distances[2] = calculateDistance(p1, p4);
        distances[3] = calculateDistance(p2, p3);
        distances[4] = calculateDistance(p2, p4);
        distances[5] = calculateDistance(p3, p4);

        Arrays.sort(distances);

        return distances[0] == distances[1] && distances[1] == distances[2] && distances[2] == distances[3] // 四条边
                && distances[4] == distances[5]; // 对角线一定长于四条边，且必须相等
    }

    /**
     * @return p1 和 p2 之间距离的平方
     */
    private int calculateDistance(int[] p1, int[] p2) {
        int x = p1[0] - p2[0], y = p1[1] - p2[1];

        return x * x + y * y;
    }
}
