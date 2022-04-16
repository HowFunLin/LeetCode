package main.easy;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unused")
public class UncommonWordsFromTwoSentences {
    /**
     * 884. 两句话中的不常见单词
     *
     * @return 句子 s1 和 s2 中所有 不常用单词 的列表。
     * 如果某个单词在其中一个句子中恰好出现一次，在另一个句子中却 没有出现 ，那么这个单词就是 不常见的
     */
    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> map = new HashMap<>();

        String[] ss1 = s1.split(" "), ss2 = s2.split(" ");

        for (String s : ss1)
            map.put(s, map.getOrDefault(s, 0) + 1);

        for (String s : ss2)
            map.put(s, map.getOrDefault(s, 0) + 1);

        List<String> list = new LinkedList<>();

        for (Map.Entry<String, Integer> entry : map.entrySet())
            if (entry.getValue() == 1)
                list.add(entry.getKey());

        return list.toArray(new String[0]);
    }
}
