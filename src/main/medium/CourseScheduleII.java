package main.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@SuppressWarnings("unused")
public class CourseScheduleII {
    /**
     * 210. 课程表 II
     *
     * @param numCourses    总共有 numCourses 门课需要选，记为 0 到 numCourses - 1
     * @param prerequisites 数组 prerequisites ，其中 prerequisites[i] = [a, b] ，表示在选修课程 a 前 必须 先选修 b
     * @return 为了学完所有课程所安排的学习顺序。可能会有多个正确的顺序，只要返回 任意一种 即可。如果不可能完成所有课程，返回 空数组
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>(numCourses);
        int[] in = new int[numCourses]; // 入度

        for (int i = 0; i < numCourses; i++)
            graph.add(new ArrayList<>());

        for (int[] prerequisite : prerequisites) {
            graph.get(prerequisite[1]).add(prerequisite[0]);
            in[prerequisite[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (in[i] == 0) {
                queue.offer(i);
                in[i] = -1;
            }
        }

        int[] res = new int[numCourses];
        int index = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int cur = queue.poll();

                res[index++] = cur;

                for (int child : graph.get(cur)) {
                    if (in[child] == -1)
                        continue;

                    in[child]--;

                    if (in[child] == 0)
                        queue.offer(child);
                }
            }
        }

        if (index < numCourses) // 不存在入度为 0 的课程但仍有课程未完成，存在互相依赖，无法完成学习
            return new int[0];

        return res;
    }
}
