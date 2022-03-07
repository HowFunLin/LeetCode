package main.easy;

@SuppressWarnings("unused")
public class PalindromeNumber {
    /**
     * 9. 回文数
     *
     * @param x 整数
     * @return 如果 x 是一个回文整数，返回 true ；否则，返回 false。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数
     */
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) // 存在后置 0 则不可能为回文数
            return false;

        int reversed = 0;

        while (x > reversed) { // 反转后半段
            reversed = reversed * 10 + x % 10;
            x /= 10;
        }

        return x == reversed || x == reversed / 10; // 位数为奇数和偶数的情况都需要考虑
    }
}
