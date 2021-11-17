package main.medium;

@SuppressWarnings("unused")
public class MaximumProductOfWordLengths {
    /**
     * 318. 最大单词长度乘积
     *
     * @param words 字符串数组，每个单词只包含小写字母
     * @return length(word[i]) * length(word[j]) 的最大值，并且这两个单词不含有公共字母。如果不存在这样的两个单词，返回 0
     */
    public int maxProduct(String[] words) {
        int length = words.length;
        int[] masks = new int[length];

        for (int i = 0; i < length; i++) {
            String word = words[i];

            for (int j = 0; j < word.length(); j++)
                masks[i] |= 1 << (word.charAt(j) - 'a');
        }

        int res = 0;

        for (int i = 0; i < length; i++)
            for (int j = i; j < length; j++)
                if ((masks[i] & masks[j]) == 0)
                    res = Math.max(res, words[i].length() * words[j].length());

        return res;
    }
}
