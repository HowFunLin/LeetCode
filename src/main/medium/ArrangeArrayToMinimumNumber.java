package main.medium;

import java.util.Arrays;

@SuppressWarnings("unused")
public class ArrangeArrayToMinimumNumber {
    /**
     * 剑指 Offer 45. 把数组排成最小的数
     *
     * @param nums 非负整数数组
     * @return 把数组里所有数字拼接起来排成一个数，返回能拼接出的所有数字中最小的一个
     */
    public String minNumber(int[] nums) {
        String[] strings = new String[nums.length];
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < nums.length; i++)
            strings[i] = String.valueOf(nums[i]);

        // 利用String的字典序排序和自定义拼接排序（防止字典序中更长的字符默认排在更后）
        // 例如 3 和 30 ， 303 < 330 ，则 30 的权重小于 3
        Arrays.sort(strings, (a, b) -> (a + b).compareTo(b + a));

        for (String str : strings)
            ans.append(str);

        return ans.toString();
    }
}
