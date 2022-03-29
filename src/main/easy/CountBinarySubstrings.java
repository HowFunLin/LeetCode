package main.easy;

@SuppressWarnings("unused")
public class CountBinarySubstrings {
    /**
     * 696. 计数二进制子串
     *
     * @return 具有相同数量 0 和 1 的非空（连续）子字符串的数量，并且这些子字符串中的所有 0 和所有 1 都是成组连续的
     */
    public int countBinarySubstrings(String s) {
        int before = 0, temp = 0, res = 0;
        char cur = s.charAt(0);

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == cur) {
                temp++;
            } else {
                res += Math.min(before, temp);

                before = temp;
                temp = 1;
                cur = c;
            }
        }

        res += Math.min(before, temp);

        return res;
    }
}
