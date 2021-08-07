package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestoreTheArrayFromAdjacentPairs {
    public int[] restoreArray(int[][] adjacentPairs) {
        int n = adjacentPairs.length + 1;
        int[] res = new int[n];
        Map<Integer, List<Integer>> neighbors = new HashMap<>();

        for (int i = 0; i < n - 1; i++)
        {
            neighbors.putIfAbsent(adjacentPairs[i][0], new ArrayList<>());
            neighbors.putIfAbsent(adjacentPairs[i][1], new ArrayList<>());
            neighbors.get(adjacentPairs[i][0]).add(adjacentPairs[i][1]);
            neighbors.get(adjacentPairs[i][1]).add(adjacentPairs[i][0]);
        }

        for (Map.Entry<Integer, List<Integer>> entry : neighbors.entrySet())
        {
            if (entry.getValue().size() == 1)
            {
                res[0] = entry.getKey();
                res[1] = entry.getValue().get(0);
                break;
            }
        }

        for (int i = 2; i < n; i++)
        {
            List<Integer> neighborList = neighbors.get(res[i - 1]);
            res[i] = res[i - 2] == neighborList.get(0) ? neighborList.get(1) : neighborList.get(0);
        }

        return res;
    }
}
