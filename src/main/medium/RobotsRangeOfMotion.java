package main.medium;

public class RobotsRangeOfMotion {
    private int m, n, k;
    private boolean[][] visited;

    public int movingCount(int m, int n, int k) {
        this.m = m;
        this.n = n;
        this.k = k;
        visited = new boolean[m][n];

        return dfs(0, 0, 0, 0);
    }

    private int dfs(int i, int j, int sum_i, int sum_j)
    {
        if (i >= m || j >= n || k < sum_i + sum_j || visited[i][j])
            return 0;

        visited[i][j] = true;

        return 1 + dfs(i + 1, j, (i + 1) / 10 + (i + 1) % 10, sum_j) + dfs(i, j + 1, sum_i,(j + 1) / 10 + (j + 1) % 10);
    }
}
