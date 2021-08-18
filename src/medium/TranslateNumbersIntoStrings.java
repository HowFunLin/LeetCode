package medium;

public class TranslateNumbersIntoStrings {
    /**
     * 剑指 Offer 46. 把数字翻译成字符串
     *
     * @param num 给定一个数字，可按照如下规则翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……
     * @return 数字有多少种不同的翻译方法
     */
    public int translateNum(int num) {
        char[] chars = String.valueOf(num).toCharArray();
        if (chars.length == 1)
            return 1;

        if (chars.length == 2)
            return num < 26 ? 2 : 1;

        int before = 1, ans = 0;
        int previous = (chars[0] - '0') * 10 + chars[1] - '0' < 26 ? 2 : 1;

        for (int i = 2; i < chars.length; i++) {
            int cur = (chars[i - 1] - '0') * 10 + chars[i] - '0';

            if (cur < 26 && cur > 9)
                ans = before + previous;
            else
                ans = previous;

            before = previous;
            previous = ans;
        }

        return ans;
    }
}
