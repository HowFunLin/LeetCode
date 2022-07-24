package main.easy;

@SuppressWarnings("unused")
public class DistanceBetweenBusStops {
    /**
     * 1184. 公交站间的距离
     *
     * @param distance 环形公交路线上有 n 个站，distance[i] 表示编号为 i 的车站和编号为 (i + 1) % n 的车站之间的距离
     * @return 乘客从出发点 start 到目的地 destination 之间的最短距离
     */
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int left = Math.min(start, destination), right = Math.max(start, destination);

        int distance1 = 0;

        for (int i = left; i < right; i++)
            distance1 += distance[i];

        int distance2 = 0;

        for (int i = 0; i < left; i++)
            distance2 += distance[i];

        for (int i = right; i < distance.length; i++)
            distance2 += distance[i];

        return Math.min(distance1, distance2);
    }
}
