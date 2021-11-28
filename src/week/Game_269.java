package week;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 第 269 场周赛
 */
@SuppressWarnings("unused")
public class Game_269 {
    /**
     * 5938. 找出数组排序后的目标下标
     *
     * @param nums   整数数组
     * @param target 目标元素。 目标下标 是一个满足 nums[i] == target 的下标 i
     * @return 由 nums 按 非递减 顺序排序后目标下标组成的列表。如果不存在目标下标，返回一个 空 列表。返回的列表必须按 递增 顺序排列
     */
    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> res = new ArrayList<>();

        Arrays.sort(nums);

        int index = Arrays.binarySearch(nums, target);

        if (index < 0)
            return res;

        while (index >= 0 && nums[index] == target)
            index--;

        index++;

        while (index < nums.length && nums[index] == target) {
            res.add(index);
            index++;
        }

        return res;
    }

    /**
     * 5939. 半径为 k 的子数组平均值
     *
     * @param nums 数组
     * @param k    半径
     * @return 返回一个长度为 n 的数组 avgs ，其中 avgs[i] 是以下标 i 为中心的子数组的 半径为 k 的子数组平均值。半径为 k 的子数组平均值 是指：nums 中一个以下标 i 为 中心 且 半径 为 k 的子数组中所有元素的平均值，即下标在 i - k 和 i + k 范围（含 i - k 和 i + k）内所有元素的平均值。使用截断式 整数除法 ，即需要去掉结果的小数部分。如果在下标 i 前或后不足 k 个元素，那么 半径为 k 的子数组平均值 是 -1
     */
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n];

        Arrays.fill(res, -1);

        int num = 2 * k + 1;

        if (num > n)
            return res;

        if (k == 0)
            return nums;

        long sum = 0;

        for (int i = 0; i < num; i++)
            sum += nums[i];

        for (int i = k; i < n - k; i++) {
            res[i] = (int) (sum / num);

            if (i < n - k - 1) {
                sum += nums[i + k + 1];
                sum -= nums[i - k];
            }
        }

        return res;
    }

    /**
     * 5940. 从数组中移除最大值和最小值
     *
     * @param nums 数组，由若干 互不相同 的整数组成
     * @return 将数组中最小值和最大值 都 移除需要的最小删除次数。一次 删除 操作定义为从数组的 前面 移除一个元素或从数组的 后面 移除一个元素
     */
    public int minimumDeletions(int[] nums) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int minIndex = -1, maxIndex = -1;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            if (num < min) {
                min = num;
                minIndex = i;
            }
            if (num > max) {
                max = num;
                maxIndex = i;
            }
        }

        int n = nums.length;

        int preDel = Math.max(minIndex, maxIndex) + 1;
        int backDel = n - Math.min(minIndex, maxIndex);
        int bothDel;

        if (minIndex < maxIndex)
            bothDel = minIndex + 1 + n - maxIndex;
        else
            bothDel = maxIndex + 1 + n - minIndex;

        return Math.min(bothDel, Math.min(preDel, backDel));
    }
}
