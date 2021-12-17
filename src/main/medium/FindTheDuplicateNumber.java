package main.medium;

@SuppressWarnings("unused")
public class FindTheDuplicateNumber {
    /**
     * 287. 寻找重复数
     *
     * @param nums 包含 n + 1 个整数的数组 nums ，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数
     * @return 重复的整数
     */
    public int findDuplicate(int[] nums) {
        // 根据下标与数组值的映射关系构建链表
        // 一定存在不同的下标映射相同的值，则链表成环
        // 转化为找出环的入口节点
        int slow = nums[0], fast = nums[nums[0]];

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        slow = 0;

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}
