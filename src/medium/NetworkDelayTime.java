package medium;

import java.util.Arrays;

public class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int n, int k) {
        final int N = n + 1, INF = Integer.MAX_VALUE / 2; // 防止整型溢出 / 2
        int[][] graph = new int[N][N]; // 邻接矩阵
        int[] dist = new int[N];
        boolean[] added = new boolean[N];

        for (int i = 1; i < N; i++)
            Arrays.fill(graph[i], INF);

        for (int[] time : times) {
            int u = time[0], v = time[1], w = time[2];
            graph[u][v] = w;
        }

        Arrays.fill(dist, INF);
        dist[0] = -1;
        dist[k] = 0;

        // 一次往集合加入一个点
        for (int i = 1; i < N; i++)
        {
            int x = -1;
            // 遍历找到距离x最近且未加入集合的结点
            for (int y = 1; y < N; y++) {
                if (!added[y] && (x == -1 || dist[y] < dist[x])) {
                    x = y;
                }
            }
            added[x] = true;
            // 以当前结点为基础遍历更新到其他结点的最小距离
            for (int y = 1; y < N; ++y) {
                dist[y] = Math.min(dist[y], dist[x] + graph[x][y]);
            }
        }

        int ans = Arrays.stream(dist).max().getAsInt();
        return ans == INF ? -1 : ans;
    }
}
