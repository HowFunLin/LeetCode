package main.easy;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class OccurrencesAfterBigram {
    /**
     * 1078. Bigram 分词
     *
     * @param text   文本 text 中可能以 "first second third" 形式出现的情况，其中 second 紧随 first 出现，third 紧随 second 出现
     * @param first  第一个词 first
     * @param second 第二个词 second
     * @return 每种上述情况的第三个词 "third"
     */
    public String[] findOccurrences(String text, String first, String second) {
        List<String> temp = new ArrayList<>();
        String[] words = text.split(" ");
        int n = words.length;

        for (int i = 0; i < n; i++)
            if (i < n - 2 && words[i].equals(first) && words[i + 1].equals(second))
                temp.add(words[i + 2]);

        return temp.toArray(new String[0]);
    }
}
