package main.easy;

@SuppressWarnings("unused")
public class PlusOne {
    /**
     * 66. 加一
     *
     * @param digits 由 整数 组成的 非空 数组，表示非负整数，最高位数字存放在数组的首位， 数组中每个元素只存储单个数字
     * @return 在该数的基础上加一的结果数组
     */
    public int[] plusOne(int[] digits) {
        int plus = 0;

        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] += i == digits.length - 1 ? 1 : plus;
            plus = 0;

            if (digits[i] == 10) {
                digits[i] = 0;
                plus = 1;
            }

            if (plus == 0)
                break;
            else {
                if (i == 0) {
                    int[] res = new int[digits.length + 1];

                    res[0] = 1;

                    return res;
                }
            }
        }

        return digits;
    }
}
