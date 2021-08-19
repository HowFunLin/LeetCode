package easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ReverseVowelsOfAString {
    /**
     * 345. 反转字符串中的元音字母
     *
     * @param s 字符串
     * @return 反转元音字母后的字符串
     */
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

        int left = 0, right = s.length() - 1;

        while (left < right) {
            if (vowels.contains(chars[left])) {
                while (!vowels.contains(chars[right]))
                    right--;

                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;

                // 处理当前右指针之后，右指针继续左移
                right--;
            }

            // 无论左边下标是否为元音字母，左指针继续右移
            left++;
        }

        return new String(chars);
    }
}
