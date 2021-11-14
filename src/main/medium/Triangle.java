package main.medium;

import java.util.List;

@SuppressWarnings("unused")
public class Triangle {
    /**
     * 120. 三角形最小路径和
     *
     * @param triangle 三角形。每一步只能移动到下一行中相邻的结点上；相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点
     * @return 自顶向下的最小路径和
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> pre = triangle.get(i - 1);
            List<Integer> row = triangle.get(i);

            for (int j = 0; j < row.size(); j++) {
                if (j == 0)
                    row.set(0, pre.get(0) + row.get(0));
                else if (j == pre.size())
                    row.set(j, pre.get(j - 1) + row.get(j));
                else
                    row.set(j, Math.min(pre.get(j - 1) + row.get(j), pre.get(j) + row.get(j)));
            }
        }

        return triangle.get(triangle.size() - 1).stream().min(Integer::compareTo).orElse(-1);
    }
}
