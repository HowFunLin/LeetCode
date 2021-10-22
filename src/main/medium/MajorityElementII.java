package main.medium;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class MajorityElementII {
    /**
     * 229. 求众数 II
     *
     * @param nums 大小为 n 的整数数组
     * @return 所有出现超过 ⌊ n/3 ⌋ 次的元素
     */
    public List<Integer> majorityElement(int[] nums) {
        // 最多只有两个元素，摩尔投票
        int element1 = 0, element2 = 0;
        int vote1 = 0, vote2 = 0;

        for (int num : nums) {
            if (vote1 > 0 && num == element1)
                vote1++;
            else if (vote2 > 0 && num == element2)
                vote2++;
            else if (vote1 == 0) {
                element1 = num;
                vote1++;
            } else if (vote2 == 0) {
                element2 = num;
                vote2++;
            } else {
                vote1--;
                vote2--;
            }
        }

        int count1 = 0, count2 = 0;
        int n = nums.length;

        for (int num : nums)
            if (vote1 > 0 && num == element1)
                count1++;
            else if (vote2 > 0 && num == element2)
                count2++;

        List<Integer> res = new ArrayList<>();

        if (count1 > n / 3)
            res.add(element1);
        if (count2 > n / 3)
            res.add(element2);

        return res;
    }
}
