package medium;

@SuppressWarnings("unused")
public class HouseRobberII {
    public int rob(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        if (nums.length == 2)
            return Math.max(nums[0], nums[1]);

        // 第一种情况：排除最后一个
        int steal1 = nums[0];
        int steal2 = Math.max(nums[0], nums[1]);
        int result = steal2;

        for(int i = 2; i < nums.length - 1; i++) {
            result = Math.max(steal1 + nums[i], steal2);
            steal1 = steal2;
            steal2 = result;
        }

        int temp = result;

        // 第二种情况：排除第一个
        steal1 = nums[1];
        steal2 = Math.max(nums[1], nums[2]);
        result = steal2;

        for(int i = 3; i < nums.length; i++) {
            result = Math.max(steal1 + nums[i], steal2);
            steal1 = steal2;
            steal2 = result;
        }

        return  Math.max(temp, result);
    }
}
