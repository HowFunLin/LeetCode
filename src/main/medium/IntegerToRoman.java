package main.medium;

@SuppressWarnings("unused")
public class IntegerToRoman {
    // 打表
    private static final String[] thousands = new String[]{"", "M", "MM", "MMM"};
    private static final String[] hundreds = new String[]{"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    private static final String[] tens = new String[]{"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    private static final String[] ones = new String[]{"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

    /**
     * 12. 整数转罗马数字
     */
    public String intToRoman(int num) {
        return thousands[num / 1000] +
                hundreds[num % 1000 / 100] +
                tens[num % 100 / 10] +
                ones[num % 10];
    }
}
