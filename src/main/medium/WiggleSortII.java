package main.medium;

@SuppressWarnings("unused")
public class WiggleSortII {
    /**
     * 324. 摆动排序 II
     *
     * @param nums 整数数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序
     */
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        int[] bucket = new int[5001]; // 桶排序

        for (int num : nums)
            bucket[num]++;

        int indexEven = 0, indexOdd = 1;

        for (int i = 5000; i >= 0; i--) {
            // 将重复的当前数值全部放入数组
            while (bucket[i] > 0 && indexOdd < n) {
                bucket[i]--;
                nums[indexOdd] = i;
                indexOdd += 2;
            }

            // 大数已经全部放入数组后再放小数
            while (indexOdd >= n && bucket[i] > 0 && indexEven < n) {
                bucket[i]--;
                nums[indexEven] = i;
                indexEven += 2;
            }
        }

        // 其他思路：类似快速排序中 partition 的方式选出中位数
    }
}
