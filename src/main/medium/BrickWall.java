package main.medium;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unused")
public class BrickWall {
    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (List<Integer> bricks : wall)
        {
            int length = 0;

            // 会把砖墙的长度计算在内，导致结果一定为0
//            for (int brick : bricks)
//            {
//                length += brick;
//                map.put(length, map.getOrDefault(length, 0) + 1);
//            }

            for (int i = 0; i < bricks.size() - 1; i++)
            {
                length += bricks.get(i);
                map.put(length, map.getOrDefault(length, 0) + 1);
            }
        }

        int max = 0;

        for (Map.Entry<Integer, Integer> entry : map.entrySet())
            max = Math.max(max, entry.getValue());

        return wall.size() - max;
    }
}
