package main.medium;

import java.util.LinkedList;

@SuppressWarnings("unused")
public class LoudAndRich {
    /**
     * 851. 喧闹和富有
     *
     * @param richer richer[i] = [a, b] 表示 person a 比 person b 更有钱，且所给出的数据 逻辑自恰
     * @param quiet  quiet[i] 是 person i 的安静值
     * @return 整数数组 answer 。answer[x] = y 的前提是，在所有拥有的钱肯定不少于 person x 的人中，person y 是最安静的人，也就是安静值 quiet[y] 最小的人
     */
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;

        int[][] graph = new int[n][n];
        int[] in = new int[n];

        for (int[] rich : richer) {
            int a = rich[0], b = rich[1];

            graph[a][b] = 1;
            in[b]++;
        }

        LinkedList<Integer> queue = new LinkedList<>();
        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            answer[i] = i;

            if (in[i] == 0)
                queue.offerLast(i);
        }

        while (!queue.isEmpty()) {
            int cur = queue.pollFirst();

            for (int i = 0; i < n; i++) {
                if (graph[cur][i] == 1) {
                    int p = answer[cur];

                    // 当前节点存储的安静值相对于下一个节点的安静值更小则替换
                    if (quiet[p] < quiet[answer[i]])
                        answer[i] = p;

                    if (--in[i] == 0)
                        queue.offerLast(i);
                }
            }
        }

        return answer;
    }
}
