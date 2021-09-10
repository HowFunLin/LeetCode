package main.medium;

@SuppressWarnings("unused")
public class FindTheStudentThatWillReplaceTheChalk {
    /**
     * <h3>1894. 找到需要补充粉笔的学生编号</h3>
     * 一个班级里有 n 个学生，编号为 0 到 n - 1 。
     * 每个学生会依次回答问题，编号为 0 的学生先回答，然后是编号为 1 的学生，以此类推，直到编号为 n - 1 的学生，
     * 然后老师会重复这个过程，重新从编号为 0 的学生开始回答问题。
     *
     * @param chalk 编号为 i 的学生回答问题时，他会消耗 chalk[i] 支粉笔
     * @param k     粉笔盒里总共有 k 支粉笔
     * @return 如果剩余粉笔数量 严格小于 chalk[i] ，那么学生 i 需要 补充 粉笔。返回需要 补充 粉笔的学生 编号 。
     */
    public int chalkReplacer(int[] chalk, int k) {
        int length = chalk.length;

        // 若 k 已经比前缀和中的数小，则直接返回，无需再进行二分查找
        if (chalk[0] > k)
            return 0;

        for (int i = 1; i < length; i++) {
            chalk[i] += chalk[i - 1];

            if (chalk[i] > k)
                return i;
        }

        k %= chalk[length - 1];

        int left = 0, right = length - 1;

        while (left < right) {
            int mid = (right - left) / 2 + left;

            // 出现 == 时，仍能满足当前学生需求，继续 + 1
            if (chalk[mid] <= k)
                left = mid + 1;
            if (chalk[mid] > k)
                right = mid;
        }

        return left;
    }
}
