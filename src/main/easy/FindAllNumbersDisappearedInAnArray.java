package main.easy;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class FindAllNumbersDisappearedInAnArray {
    /**
     * 448. 找到所有数组中消失的数字
     *
     * @param nums 含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内
     * @return 以数组的形式返回所有在 [1, n] 范围内但没有出现在 nums 中的数字
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;

        for (int num : nums)
            nums[(num - 1) % n] += n; // 遍历到的值可能已经发生修改，求余得到原来位置的值

        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < n; i++)
            if (nums[i] <= n)
                res.add(i + 1);

        return res;
    }
}
