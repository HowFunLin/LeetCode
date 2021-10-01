package main.easy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unused")
public class DestinationCity {
    /**
     * 1436. 旅行终点站
     *
     * @param paths 旅行线路用数组 paths 表示，其中 paths[i] = [cityA, cityB] 表示该线路将会从 cityA 直接前往 cityB
     * @return 旅行的终点站，即没有任何可以通往其他城市的线路的城市
     */
    public String destCity(List<List<String>> paths) {
        Map<String, String> map = new HashMap<>();

        for (List<String> path : paths)
            map.put(path.get(0), path.get(1));

        String res = paths.get(0).get(0);

        // 模拟旅行路线
        while (map.containsKey(res))
            res = map.get(res);

        return res;

//        Set<String> set = new HashSet<>();
//
//        for (List<String> path : paths)
//            set.add(path.get(0));
//
//        for (List<String> path : paths) {
//            String destination = path.get(1);
//
//            if (!set.contains(destination))
//                return destination;
//        }
//
//        return "";
    }
}
