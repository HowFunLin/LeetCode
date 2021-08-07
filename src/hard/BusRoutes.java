package hard;

import java.util.*;

public class BusRoutes {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        Map<Integer, Set<Integer>> stopToRoutes = new HashMap<>();
        Set<Integer> visitedRoutes = new HashSet<>(); // 去过的路线

        // 站点和路线的映射
        for (int i = 0; i < routes.length; i++)
        {
            for (int stop : routes[i])
            {
                if (stopToRoutes.get(stop) == null)
                    stopToRoutes.put(stop, new HashSet<>(Arrays.asList(i)));
                else
                    stopToRoutes.get(stop).add(i);
            }
        }

        // BFS
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);

        int res = 0;

        while (!queue.isEmpty())
        {
            int size = queue.size();

            for (int i = 0; i < size; i++)
            {
                int cur = queue.poll();
                Set<Integer> route = stopToRoutes.get(cur);

                for (int index : route)
                {
                    if (!visitedRoutes.contains(index))
                    {
                        for (int stop : routes[index])
                        {
                            if (stop != cur)
                                queue.offer(stop);

                            if (stop == target)
                                return res;
                        }

                        visitedRoutes.add(index);
                    }
                }
            }

            res++;
        }

        return -1;
    }
}
