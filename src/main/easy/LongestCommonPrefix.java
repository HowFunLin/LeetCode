package main.easy;

@SuppressWarnings("unused")
public class LongestCommonPrefix {
    /**
     * 14. 最长公共前缀
     *
     * @param strs 字符串数组
     * @return 字符串数组中的最长公共前缀。如果不存在公共前缀，返回空字符串 ""
     */
    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            String str = strs[i];
            int j = 0, n = prefix.length();

            for (; j < n && j < str.length(); j++)
                if (str.charAt(j) != prefix.charAt(j))
                    break;

            if (j < n)
                prefix = prefix.substring(0, j);

            if (prefix.length() == 0)
                return "";
        }

        return prefix;
    }
}
