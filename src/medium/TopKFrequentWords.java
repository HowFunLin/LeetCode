package medium;

import java.util.*;

public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();

        for (String word : words)
            map.put(word, map.getOrDefault(word, 0) + 1);

        PriorityQueue<String> queue = new PriorityQueue<>(k, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (map.get(o1) == map.get(o2))
                    return o1.compareTo(o2);

                return map.get(o2) - map.get(o1);
            }
        });

        for (String word : words)
            queue.add(word);

        List<String> list = new ArrayList<>();

        list.add(queue.poll());

        return list;
    }
}
