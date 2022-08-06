package main.easy;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class StringMatchingInAnArray {
    /**
     * 1408. 数组中的字符串匹配
     *
     * @return words 中是其他单词的子字符串的所有单词
     */
    public List<String> stringMatching(String[] words) {
        int n = words.length;
        List<String> res = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    if (words[j].contains(words[i])) {
                        res.add(words[i]);
                        break;
                    }
                }
            }
        }

        return res;
    }
}
