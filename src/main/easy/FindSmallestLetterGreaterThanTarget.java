package main.easy;

@SuppressWarnings("unused")
public class FindSmallestLetterGreaterThanTarget {
    /**
     * 744. 寻找比目标字母大的最小字母
     *
     * @param letters 排序后的字符列表 letters ，列表中只包含小写英文字母
     * @return 在这一有序列表里比目标字母 target 大的最小字母
     */
    public char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length;
        int left = 0, right = n;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (letters[mid] <= target) // 右侧边界
                left = mid + 1;
            else
                right = mid;
        }

        return letters[left % n];
    }
}
