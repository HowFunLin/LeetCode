package main.easy;

@SuppressWarnings("unused")
public class ValidBoomerang {
    /**
     * 1037. 有效的回旋镖
     *
     * @param points points[i] = [xi, yi] 表示 X-Y 平面上的一个点，回旋镖 定义为一组三个点，这些点 各不相同 且 不在一条直线上
     * @return 如果这些点是否构成一个 回旋镖
     */
    public boolean isBoomerang(int[][] points) {
        // 点1 与 点0 的斜率 k1 != 点2 与 点0 的斜率 k2，转换为交叉相乘
        return (points[1][1] - points[0][1]) * (points[2][0] - points[0][0]) != (points[1][0] - points[0][0]) * (points[2][1] - points[0][1]);
    }
}
