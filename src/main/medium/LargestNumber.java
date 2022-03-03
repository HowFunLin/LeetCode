package main.medium;

import java.util.Arrays;

@SuppressWarnings("unused")
public class LargestNumber {
    /**
     * 179. 最大数
     *
     * @param nums 非负整数
     * @return 重新排列每个数的顺序（每个数不可拆分）组成的最大的整数
     */
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] strs = new String[n];

        for (int i = 0; i < n; i++)
            strs[i] = String.valueOf(nums[i]);

        Arrays.sort(strs, (s1, s2) -> (s2 + s1).compareTo(s1 + s2)); // 数字之间贪心地进行排序即可满足前后顺序，且要注意从高到低

        StringBuilder sb = new StringBuilder();

        for (String str : strs)
            sb.append(str);

        int i = 0;

        while (i < sb.length() - 1 && sb.charAt(i) == '0') // 消除前导 0
            i++;

        return sb.substring(i);
    }
}
