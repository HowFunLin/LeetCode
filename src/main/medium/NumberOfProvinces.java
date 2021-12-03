package main.medium;

@SuppressWarnings("unused")
public class NumberOfProvinces {
    private boolean[] visited;

    /**
     * 547. 省份数量
     *
     * @param isConnected n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，而 isConnected[i][j] = 0 表示二者不直接相连
     * @return 矩阵中 省份 的数量。省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市
     */
    public int findCircleNum(int[][] isConnected) {
        int cities = isConnected.length;
        visited = new boolean[cities];
        int provinces = 0;

        for (int i = 0; i < cities; i++) {
            if (!visited[i]) {
                dfs(isConnected, cities, i);
                provinces++;
            }
        }

        return provinces;
    }

    /**
     * 深度优先遍历
     *
     * @param isConnected n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，而 isConnected[i][j] = 0 表示二者不直接相连
     * @param cities      城市数量
     * @param i           当前遍历的城市下标
     */
    private void dfs(int[][] isConnected, int cities, int i) {
        // j 从 0 开始遍历所有可能的城市
        for (int j = 0; j < cities; j++) {
            if (isConnected[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                dfs(isConnected, cities, j);
            }
        }
    }
}
