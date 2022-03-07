package main.easy;

@SuppressWarnings("unused")
public class Base7 {
    /**
     * 504. 七进制数
     *
     * @param num 整数
     * @return 整数转化为 7 进制后的字符串形式
     */
    public String convertToBase7(int num) {
        if (num == 0)
            return "0";

        StringBuilder sb = new StringBuilder();
        int temp = Math.abs(num);

        while (temp > 0) {
            sb.insert(0, temp % 7);
            temp /= 7;
        }

        if (num < 0)
            sb.insert(0, '-');

        return sb.toString();
    }
}
