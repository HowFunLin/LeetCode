package main.medium;

import java.util.Arrays;

public class ContiguousArray {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        // counts数组仅用于存储索引，而不存储前缀和
        int[] counts = new int[2 * n + 1];
        Arrays.fill(counts, -1);
//        int[] sum = new int[n + 1];
//        for (int i = 1; i <= n; i++)
//            sum[i] = sum[i - 1] + (nums[i - 1] == 1 ? 1 : -1);

        int count = 0;
        int res = 0;

//        HashMap<Integer, Integer> map = new HashMap<>();
//        map.put(0, 0); // base case 若没有元素，前缀和为0，索引为0
        for (int i = 0; i < n; i++)
        {
//            if (!map.containsKey(sum[i - 2]))
//                map.put(sum[i - 2], i - 2);
//            if (map.containsKey(sum[i]))
//                res = Math.max(res, i - map.get(sum[i]));
            count += (nums[i] == 1 ? 1 : -1);
            if (count == 0)
                res = i + 1;
            // 加上原数组的长度，用于防止出现负数的情况
            else if (counts[count + n] != -1)
                res = Math.max(res, i - counts[count + n]);
            else
                counts[count + n] = i;
        }

        return res;
    }
}
