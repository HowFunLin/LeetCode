package main.easy;

@SuppressWarnings("unused")
public class AddStrings {
    /**
     * 415. 字符串相加
     *
     * @param num1 字符串形式的非负整数
     * @param num2 字符串形式的非负整数
     * @return num1 和 num2 之和的字符串形式
     */
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1, add = 0;
        StringBuilder builder = new StringBuilder();

        while (i >= 0 || j >= 0 || add != 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;

            int temp = x + y + add;

            builder.append(temp % 10);
            add = temp / 10;

            i--;
            j--;
        }

        return builder.reverse().toString();
    }
}
