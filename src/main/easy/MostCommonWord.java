package main.easy;

import java.util.*;

@SuppressWarnings("unused")
public class MostCommonWord {
    /**
     * 819. 最常见的单词
     *
     * @param paragraph 段落中的单词不区分大小写
     * @param banned    禁用列表中的单词用小写字母表示，不含标点符号
     * @return 出现次数最多，同时不在禁用列表中的单词（小写字母）
     */
    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph += "."; // 可以在循环内直接得出结果

        Set<String> banSet = new HashSet<>(Arrays.asList(banned));

        Map<String, Integer> count = new HashMap<>();

        String ans = "";
        int max = 0;

        StringBuilder word = new StringBuilder();

        for (char c : paragraph.toCharArray()) {
            if (Character.isLetter(c)) {
                word.append(Character.toLowerCase(c));
            } else if (word.length() > 0) { // 当前字符不为字母且 StringBuilder 存在字符
                String finalWord = word.toString();

                if (!banSet.contains(finalWord)) {
                    count.put(finalWord, count.getOrDefault(finalWord, 0) + 1);

                    if (count.get(finalWord) > max) {
                        ans = finalWord;
                        max = count.get(finalWord);
                    }
                }

                word = new StringBuilder();
            }
        }

        return ans;
    }
}
