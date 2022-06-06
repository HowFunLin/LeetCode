package jianzhi.easy;

@SuppressWarnings("unused")
public class MaximumProductOfWordLengths {
    /**
     * 剑指 Offer II 005. 单词长度的最大乘积
     *
     * @return 两个字符串 words[i] 和 words[j] 不包含相同字符时，它们长度的乘积的最大值。如果没有不包含相同字符的一对字符串，返回 0
     */
    public int maxProduct(String[] words) {
        int n = words.length;
        int[] alphabet = new int[n];

        for (int i = 0; i < n; i++) {
            String word = words[i];
            int bits = 0;

            for (int j = 0; j < word.length(); j++)
                bits |= 1 << (word.charAt(j) - 'a');

            alphabet[i] = bits;
        }

        int max = 0;

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if ((alphabet[i] & alphabet[j]) == 0)
                    max = Math.max(max, words[i].length() * words[j].length());

        return max;
    }
}
