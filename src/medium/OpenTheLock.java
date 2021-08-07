package medium;

import java.util.*;

public class OpenTheLock {
    public int openLock(String[] deadends, String target) {
        // 死亡数字加入Set集合
        HashSet<Integer> set = new HashSet<>();
        for (String deadend : deadends)
            set.add(Integer.parseInt(deadend));

        // 初始数字为死亡数字，无法解锁
        if (set.contains(0))
            return -1;

        // 初始数字为解锁数字，直接解锁
        int tar = Integer.parseInt(target);
        if (tar == 0)
            return 0;

        int res = 0;
        // 维护visited数组，剪枝
        boolean[] visited = new boolean[10000];
        // BFS
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);

        while (!queue.isEmpty())
        {
            int size = queue.size();
            for (int j = 0; j < size; j++)
            {
                int cur = queue.poll();
                if (cur == tar)
                    return res;

                // 个十百千
                for (int i = 1; i <= 1000; i *= 10)
                {
                    // i对应的位数+1，为9则退0
                    int next = cur / i % 10 == 9 ? cur - i * 9 : cur + i;

                    if (!visited[next])
                    {
                        visited[next] = true;
                        if (!set.contains(next))
                            queue.offer(next);
                    }

                    // i对应的位数-1，为0则进9
                    int pre = cur / i % 10 == 0 ? cur + i * 9 : cur - i;

                    if (!visited[pre])
                    {
                        visited[pre] = true;
                        if (!set.contains(pre))
                            queue.offer(pre);
                    }
                }
            }

            res++;
        }

        return -1;

//        int times = 0;
//
//        List<String> dead = new ArrayList<>();
//        for (String deadend : deadends)
//            dead.add(deadend);
//
//        Set<String> visited = new HashSet<>();
//        visited.add("0000");
//
//        Queue<String> queue = new LinkedList<>();
//        queue.offer("0000");
//
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//
//            for (int i = 0; i < size; i++) {
//                String str = queue.poll();
//
//                if (str.equals(target))
//                    return times;
//
//                if (dead.contains(str))
//                    continue;
//
//                for (int j = 0; j < 4; j++) {
//                    char[] plusChars = str.toCharArray();
//
//                    if (plusChars[j] == '9')
//                        plusChars[j] = '0';
//                    else
//                        plusChars[j] += 1;
//
//                    String plusString = new String(plusChars);
//
//                    if (!visited.contains(plusString))
//                    {
//                        queue.offer(plusString);
//                        visited.add(plusString);
//                    }
//
//                    char[] minusChars = str.toCharArray();
//
//                    if (minusChars[j] == '0')
//                        minusChars[j] = '9';
//                    else
//                        minusChars[j] -= 1;
//
//                    String minusString = new String(minusChars);
//
//                    if (!visited.contains(minusString))
//                    {
//                        queue.offer(minusString);
//                        visited.add(minusString);
//                    }
//                }
//            }
//
//            times++;
//        }
//
//        return -1;
    }
}
