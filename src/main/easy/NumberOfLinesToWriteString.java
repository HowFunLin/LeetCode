package main.easy;

@SuppressWarnings("unused")
public class NumberOfLinesToWriteString {
    /**
     * 806. 写字符串需要的行数
     *
     * @param widths 数组 widths[0] 代表 'a' 需要的单位， widths[1] 代表 'b' 需要的单位，...， widths[25] 代表 'z' 需要的单位
     * @param s      把给定的字符串 S 从左到右写到每一行上，每一行的最大宽度为100个单位。如果写字母的时候使这行超过了100 个单位，应该写到下一行
     * @return 长度为2的整数列表。至少多少行能放下S，以及最后一行使用的宽度
     */
    public int[] numberOfLines(int[] widths, String s) {
        int lines = 0, curWidth = 0;

        for (int i = 0; i < s.length(); i++) {
            int width = widths[s.charAt(i) - 'a'];

            if (curWidth + width <= 100) {
                curWidth += width;
            } else {
                lines++;
                curWidth = width;
            }
        }

        return new int[]{lines + 1, curWidth};
    }
}
