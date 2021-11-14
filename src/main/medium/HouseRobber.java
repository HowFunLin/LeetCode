package main.medium;

@SuppressWarnings("unused")
public class HouseRobber {
    /**
     * 198. 打家劫舍
     *
     * @param nums 代表每个房屋存放金额的非负整数数组。相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警
     * @return 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额
     */
    public int rob(int[] nums) {
        if (nums.length == 1)
            return nums[0];

        // 空间压缩版DP
        int a = nums[0], b = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            int temp = b;
            b = Math.max(b, a + nums[i]);
            a = temp;
        }

        return b;
    }
}
