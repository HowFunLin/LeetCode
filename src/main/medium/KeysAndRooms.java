package main.medium;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@SuppressWarnings("unused")
public class KeysAndRooms {
    /**
     * 841. 钥匙和房间
     *
     * @param rooms 其中 rooms[i] 是进入 i 号房间可以获得的钥匙集合
     * @return 能否进入 所有 房间
     */
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size(), num = 0;
        boolean[] visited = new boolean[n];

        Queue<Integer> queue = new LinkedList<>();

        queue.offer(0);
        visited[0] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int room = queue.poll();

                num++;

                for (int key : rooms.get(room)) {
                    if (!visited[key]) {
                        queue.offer(key);
                        visited[key] = true;
                    }
                }
            }
        }

        return num == n;
    }
}
