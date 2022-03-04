package main.easy;

@SuppressWarnings("unused")
public class ValidPalindrome {
    /**
     * 125. 验证回文串
     *
     * @param s 字符串
     * @return 是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写
     */
    public boolean isPalindrome(String s) {
        int n = s.length();
        int left = 0, right = n - 1;

        s = s.toLowerCase();

        while (left < right) {
            while (left < right && !Character.isLetter(s.charAt(left)) && !Character.isDigit(s.charAt(left)))
                left++;

            while (left < right && !Character.isLetter(s.charAt(right)) && !Character.isDigit(s.charAt(right)))
                right--;

            if (s.charAt(left++) != s.charAt(right--))
                return false;
        }

        return true;
    }
}
