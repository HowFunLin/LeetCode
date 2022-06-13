package main.easy;

@SuppressWarnings("unused")
public class HeightChecker {
    /**
     * 1051. 高度检查器
     *
     * @param heights heights[i] 是这一行中第 i 位学生的高度（下标从 0 开始）
     * @return 满足 heights[i] != expected[i] 的 下标数量。学生需要按照 非递减 的高度顺序排成一行。排序后的高度情况用整数数组 expected 表示
     */
    public int heightChecker(int[] heights) {
        int[] expected = new int[101]; // heights[i] 在 1 ~ 100 之间

        for (int height : heights)
            expected[height]++;

        int sum = 0, index = 0;

        for (int i = 1; i < 101; i++)
            for (int j = 0; j < expected[i]; j++)
                if (heights[index++] != i) // 当前索引的高度不满足期望高度
                    sum++;

        return sum;
    }
}
