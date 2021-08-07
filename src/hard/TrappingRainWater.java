package hard;

public class TrappingRainWater {
    public int trap(int[] height) {
        int result = 0;
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;

        while (left <right)
        {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            // 小的那一边移动，如果移动后的位置小于小的那一边的最大值，那一定可以接到雨水
            if (height[left] < height[right]) {
                result += leftMax - height[left];
                ++left;
            } else {
                result += rightMax - height[right];
                --right;
            }
        }

        return result;
    }
}
