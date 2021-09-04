package main.medium;

@SuppressWarnings("unused")
public class CircularArrayLoop {
    /**
     * 457. 环形数组是否存在循环
     *
     * @param nums 环形数组
     * @return 是否存在循环
     */
    public boolean circularArrayLoop(int[] nums) {
        int length = nums.length;

        for (int i = 0; i < length; i++) {
            // 当前下标无法构成循环，直接跳过
            if (nums[i] == 0)
                continue;

            int slow = i, fast = next(nums, i);

            // 确保全正或者全负
            while (nums[slow] * nums[fast] > 0 && nums[slow] * nums[next(nums, fast)] > 0) {
                if (slow == fast) {
                    if (slow != next(nums, slow))
                        return true;
                        // 慢指针的下一步仍为慢指针本身，则循环长度为1，不成立
                    else
                        break;
                }

                slow = next(nums, slow);
                fast = next(nums, next(nums, fast));
            }

            int unLoop = i;

            // 将打破全正或全负的索引之前的所有途经索引都设置为0，表示无法构成循环
            while (nums[unLoop] * nums[next(nums, unLoop)] > 0) {
                int temp = unLoop;
                unLoop = next(nums, unLoop);
                nums[temp] = 0;
            }
        }

        return false;
    }

    /**
     * 当前下标移动的下一个位置
     *
     * @param nums  环形数组
     * @param index 当前下标
     * @return 下一个位置
     */
    private int next(int[] nums, int index) {
        int next = (index + nums[index]) % nums.length;
        // 下标若小于0，加上数组长度才是正确位置
        return next < 0 ? next + nums.length : next;
    }
}
