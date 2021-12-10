package main.medium;

import java.util.LinkedList;
import java.util.List;

@SuppressWarnings({"unused", "unchecked"})
public class CourseSchedule {
    private boolean[] visited, onPath;
    private boolean hasCycle = false;

    /**
     * 207. 课程表
     *
     * @param numCourses    选修 numCourses 门课程，记为 0 到 numCourses - 1
     * @param prerequisites 在选修某些课程之前需要一些先修课程。先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [a, b] ，表示如果要学习课程 a 则 必须 先学习课程  b
     * @return 是否可能完成所有课程的学习
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new LinkedList[numCourses];

        for (int i = 0; i < numCourses; i++)
            graph[i] = new LinkedList<>();

        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];

        for (int[] prerequisite : prerequisites)
            graph[prerequisite[1]].add(prerequisite[0]);

        for (int i = 0; i < numCourses; i++)
            traversal(graph, i);

        return !hasCycle;
    }

    /**
     * 遍历
     *
     * @param graph 有向图
     * @param i     当前节点
     */
    private void traversal(List<Integer>[] graph, int i) {
        // 判断当前路径是否存在环
        if (onPath[i])
            hasCycle = true;

        // 存在环或者已遍历则直接结束
        if (hasCycle || visited[i])
            return;

        visited[i] = true;
        onPath[i] = true;

        // 遍历后续节点
        for (int next : graph[i])
            traversal(graph, next);

        // 拓扑排序在此添加当前节点并反转（反转后序遍历）

        // 当前路径遍历结束，退出节点
        onPath[i] = false;
    }
}
