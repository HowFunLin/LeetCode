package main.medium;

public class ShortestUnsortedContinuousSubarray {
    public int findUnsortedSubarray(int[] nums) {
        // 可在排序之后进行双指针比较直接求解
//        int n = nums.length;
//        int[] arr = nums.clone();
//        Arrays.sort(arr);
//        int i = 0, j = n - 1;
//        while (i <= j && nums[i] == arr[i]) i++; // <= 使得若本身为升序数组，最终i = j + 1，结果返回0
//        while (i <= j && nums[j] == arr[j]) j--;
//        return j - i + 1;

        // 利用大小关系双指针
        int n = nums.length;
        int maxn = Integer.MIN_VALUE, right = -1;
        int minn = Integer.MAX_VALUE, left = -1;

        for (int i = 0; i < n; i++) {
            // right从左向右判断，标记小于当前最大值的索引
            // right指针右边的均大于right指针左边的，若右边没有小于当前maxn的，则继续遍历，有则重新标记right
            if (maxn > nums[i])
                right = i;
            else
                maxn = nums[i];

            // left从右向左判断，标记大于当前最小值的索引
            // left指针左边的均小于left指针右边的，若左边没有大于当前minn的，则继续遍历，有则重新标记left
            if (minn < nums[n - i - 1])
                left = n - i - 1;
            else
                minn = nums[n - i - 1];
        }

        // right指针不移动或者left指针处于最右端，数组本身为升序
        return right == -1 ? 0 : right - left + 1;
    }
}
