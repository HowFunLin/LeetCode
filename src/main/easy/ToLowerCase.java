package main.easy;

@SuppressWarnings("unused")
public class ToLowerCase {
    /**
     * 709. 转换成小写字母
     *
     * @param s 字符串
     * @return 字符串中的大写字母转换成相同的小写字母后的字符串
     */
    public String toLowerCase(String s) {
        char[] sc = s.toCharArray();

        for (int i = 0; i < sc.length; i++) {
            char c = sc[i];

            if (c >= 'A' && c <= 'Z')
                sc[i] = (char) (c + 'a' - 'A');
        }

        return new String(sc);
    }
}
