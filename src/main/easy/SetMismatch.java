package main.easy;

@SuppressWarnings("unused")
public class SetMismatch {
    /**
     * 645. 错误的集合
     *
     * @param nums 集合 s 本应包含从 1 到 n 的整数，因为数据错误，集合 丢失了一个数字 并且 有一个数字重复
     * @return 重复出现的整数，丢失的整数组成的数组
     */
    public int[] findErrorNums(int[] nums) {
        boolean[] appear = new boolean[nums.length + 1];
        int[] res = new int[2];

        for (int num : nums) {
            if (appear[num])
                res[0] = num;
            else
                appear[num] = true;
        }

        for (int i = 1; i < appear.length; i++)
            if (!appear[i])
                res[1] = i;

        return res;
    }
}
