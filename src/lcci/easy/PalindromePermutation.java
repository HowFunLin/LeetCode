package lcci.easy;

@SuppressWarnings("unused")
public class PalindromePermutation {
    /**
     * 面试题 01.04. 回文排列
     *
     * @param s 字符串
     * @return 是否为某个回文串的排列之一。回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。回文串不一定是字典当中的单词。
     */
    public boolean canPermutePalindrome(String s) {
        int[] bits = new int[128];
        char[] chars = s.toCharArray();

        for (char c : chars)
            bits[c]++;

        boolean isPermitted = true;

        for (int bit : bits) {
            if (bit % 2 != 0) {
                if (isPermitted)
                    isPermitted = false;
                else
                    return false;
            }
        }

        return true;

//        Set<Character> set = new HashSet<>();
//
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//
//            if (set.contains(c))
//                set.remove(c);
//            else
//                set.add(c);
//        }
//
//        return set.size() == 0 || set.size() == 1;
    }
}
