package lcci.easy;

@SuppressWarnings("unused")
public class CheckPermutation {
    /**
     * 面试题 01.02. 判定是否互为字符重排
     *
     * @param s1 字符串
     * @param s2 字符串
     * @return 其中一个字符串的字符重新排列后，能否变成另一个字符串
     */
    public boolean checkPermutation(String s1, String s2) {
        int[] times = new int[128];
        char[] c1 = s1.toCharArray(), c2 = s2.toCharArray();

        for (char c : c1)
            times[c]++;

        for (char c : c2) {
            times[c]--;

            if (times[c] < 0)
                return false;
        }

        return true;
    }
}
