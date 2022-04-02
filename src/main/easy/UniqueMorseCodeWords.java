package main.easy;

import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("unused")
public class UniqueMorseCodeWords {
    public static final String[] table =
            new String[]{
                    ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.",
                    "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."
            };

    /**
     * 804. 唯一摩尔斯密码词
     *
     * @return 对 words 中所有单词进行单词翻译后不同 单词翻译 的数量
     */
    public int uniqueMorseRepresentations(String[] words) {
        Set<String> set = new HashSet<>();

        for (String word : words) {
            StringBuilder builder = new StringBuilder();

            for (int i = 0; i < word.length(); i++)
                builder.append(table[word.charAt(i) - 'a']);

            set.add(builder.toString());
        }

        return set.size();
    }
}
