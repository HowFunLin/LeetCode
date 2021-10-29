package main.medium;

@SuppressWarnings("unused")
public class ContainerWithMostWater {
    /**
     * 11. 盛最多水的容器
     *
     * @param height n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)
     * @return 其中可以容纳最多的水的两条线与 x 轴共同构成的容器
     */
    public int maxArea(int[] height) {
        int res = 0, left = 0, right = height.length - 1;

        // 贪心，短边往内收缩
        while (left < right)
            res = height[left] < height[right] ? Math.max(res, (right - left) * height[left++]) : Math.max(res, (right - left) * height[right--]);

        return res;
    }
}
