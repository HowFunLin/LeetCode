package jianzhi.medium;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

@SuppressWarnings("all")
public class SequenceReconstruction {
    /**
     * 剑指 Offer II 115. 重建序列
     *
     * @param sequences sequences[i] 是 nums 的子序列
     * @return nums 是否序列的唯一最短 超序列
     */
    public boolean sequenceReconstruction(int[] nums, int[][] sequences) {
        int n = nums.length;

        // 拓扑排序，入度数组和下一跳
        int[] in = new int[n + 1];
        Set<Integer>[] graph = new Set[n + 1];

//        Arrays.fill(graph, new HashSet<>()); // Arrays.fill() 方法填充的对象是同一个而不是每个位置均 new

        for (int i = 1; i <= n; i++)
            graph[i] = new HashSet<>();

        for (int[] sequence : sequences) {
            for (int i = 1; i < sequence.length; i++) {
                int next = sequence[i];

                if (graph[sequence[i - 1]].add(next)) // 不重复入度
                    in[next]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= n; i++)
            if (in[i] == 0)
                queue.offer(i); // 起点

        while (!queue.isEmpty()) {
            if (queue.size() > 1)
                return false;

            int num = queue.poll();

            for (Integer next : graph[num]) {
                in[next]--;

                if (in[next] == 0)
                    queue.offer(next);
            }
        }

        return true;
    }
}
