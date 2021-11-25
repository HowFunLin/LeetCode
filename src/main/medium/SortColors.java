package main.medium;

import static struct.Swap.swapInt;

@SuppressWarnings("unused")
public class SortColors {
    /**
     * 75. 颜色分类
     *
     * @param nums 包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。使用整数 0、 1 和 2 分别表示红色、白色和蓝色
     */
    public void sortColors(int[] nums) {
        int p0 = 0, p2 = nums.length - 1;

        for (int i = 0; i <= p2; i++) {
            while (i <= p2 && nums[i] == 2) {
                swapInt(nums, i, p2);
                p2--;
            }

            if (nums[i] == 0) {
                swapInt(nums, i, p0);
                p0++;
            }
        }
    }
}
