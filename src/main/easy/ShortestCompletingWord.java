package main.easy;

import java.util.Arrays;

@SuppressWarnings("unused")
public class ShortestCompletingWord {
    /**
     * 748. 最短补全词
     *
     * @param licensePlate 字符串。忽略 licensePlate 中的 数字和空格。不区分大小写
     * @param words        字符串数组。 words[i] 由小写英文字母组成
     * @return words 中的 最短补全词。补全词 是一个包含 licensePlate 中所有的字母的单词。在所有补全词中，最短的那个就是 最短补全词。当有多个单词都符合最短补全词的匹配条件时取 words 中 最靠前的 那个
     */
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] license = new int[26];

        for (int i = 0; i < licensePlate.length(); i++) {
            char cur = licensePlate.charAt(i);

            if ((cur >= '0' && cur <= '9') || cur == ' ')
                continue;

            if (cur >= 'a')
                license[cur - 'a']++;
            else
                license[cur - 'A']++;
        }

        int[] wordPlate = new int[26];
        int length = Integer.MAX_VALUE;
        String res = null;

        iterate:
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                char cur = word.charAt(i);

                if (cur >= 'a')
                    wordPlate[cur - 'a']++;
                else
                    wordPlate[cur - 'A']++;
            }

            for (int i = 0; i < 26; i++) {
                if (license[i] > wordPlate[i]) {
                    Arrays.fill(wordPlate, 0);
                    continue iterate;
                }
            }

            if (word.length() < length) {
                length = word.length();
                res = word;
            }

            Arrays.fill(wordPlate, 0);
        }

        return res;
    }
}
