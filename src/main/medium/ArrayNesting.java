package main.medium;

@SuppressWarnings("unused")
public class ArrayNesting {
    /**
     * 565. 数组嵌套
     *
     * @param nums 索引从0开始长度为N的数组A，包含0到N - 1的所有整数
     * @return 最大的集合S的大小。其中 S[i] = {A[i], A[A[i]], A[A[A[i]]], ... }，不断添加直到S出现重复的元素
     */
    public int arrayNesting(int[] nums) {
        int n = nums.length, len = 0, remain = n;
        boolean[] visited = new boolean[n]; // 记录是否访问过

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int index = i, count = 0;

                while (!visited[index]) {
                    visited[index] = true;
                    index = nums[index];

                    count++;
                }

                remain -= count;
                len = Math.max(len, count);

                if (remain < len) // 剪枝，剩余的数的数量如果不能继续生成更长数组，则 len 已经为最大值
                    break;
            }
        }

        return len;
    }
}
