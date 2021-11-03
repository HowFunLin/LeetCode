package main.medium;

@SuppressWarnings("unused")
public class JumpGame {
    /**
     * 55. 跳跃游戏
     *
     * @param nums 非负整数数组 nums ，最初位于数组的 第一个下标，数组中的每个元素代表在该位置可以跳跃的最大长度
     * @return 是否能够到达最后一个下标
     */
    public boolean canJump(int[] nums) {
        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i > max)
                break;

            max = Math.max(max, i + nums[i]);

            if (max >= nums.length - 1)
                return true;
        }

        return false;
    }
}
