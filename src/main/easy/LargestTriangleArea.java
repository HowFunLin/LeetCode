package main.easy;

@SuppressWarnings("unused")
public class LargestTriangleArea {
    /**
     * 812. 最大三角形面积
     *
     * @param points 包含多个点的集合，从其中取三个点组成三角形
     * @return 能组成的最大三角形的面积
     */
    public double largestTriangleArea(int[][] points) {
        int n = points.length;
        double res = 0d;

        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++)
                for (int k = j + 1; k < n; k++)
                    res = Math.max(res, area(points[i], points[j], points[k]));

        return res;
    }

    /**
     * 鞋带公式
     *
     * @return 点 p、q、r 组成的三角形的面积
     */
    private double area(int[] p, int[] q, int[] r) {
        return 0.5 * Math.abs(p[0] * q[1] + q[0] * r[1] + r[0] * p[1] - p[1] * q[0] - q[1] * r[0] - r[1] * p[0]);
    }
}
