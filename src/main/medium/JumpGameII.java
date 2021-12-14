package main.medium;

@SuppressWarnings("unused")
public class JumpGameII {
    /**
     * 45. 跳跃游戏 II
     *
     * @param nums 非负整数数组，数组中的每个元素代表你在该位置可以跳跃的最大长度，最初位于数组的第一个位置
     * @return 到达数组的最后一个位置最少的跳跃次数
     */
    public int jump(int[] nums) {
        int end = 0, maxPosition = 0, steps = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);

            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }

        return steps;
    }
}
