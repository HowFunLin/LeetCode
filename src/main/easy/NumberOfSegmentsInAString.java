package main.easy;

@SuppressWarnings("unused")
public class NumberOfSegmentsInAString {
    /**
     * 434. 字符串中的单词数
     *
     * @param s 字符串
     * @return 字符串中的单词个数，这里的单词指的是连续的不是空格的字符
     */
    public int countSegments(String s) {
        boolean isSegment = false;
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);

            if (cur == ' ') {
                isSegment = false;
                continue;
            }

            if (!isSegment) {
                count++;
                isSegment = true;
            }
        }

        return count;
    }
}
