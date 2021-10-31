package main.easy;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class KeyboardRow {
    /**
     * 500. 键盘行
     *
     * @param words 字符串数组 words
     * @return 可以使用在 美式键盘 同一行的字母打印出来的单词
     */
    public String[] findWords(String[] words) {
        int[] table = new int[]{2, 3, 3, 2, 1, 2, 2, 2, 1, 2, 2, 2, 3, 3, 1, 1, 1, 1, 2, 1, 1, 3, 1, 3, 1, 3};
        List<String> temp = new ArrayList<>();

        traversal:
        for (String word : words) {
            int row = 0;

            for (int i = 0; i < word.length(); i++) {
                char cur = word.charAt(i);
                int index = cur > 'Z' ? cur - 'a' : cur - 'A';

                if (i == 0)
                    row = table[index];

                if (table[index] != row)
                    continue traversal;
            }

            temp.add(word);
        }

        return temp.toArray(new String[0]);
    }
}
